package com.timain.web.controller;

import com.timain.common.DataGridView;
import com.timain.common.ResultObj;
import com.timain.pojo.Bills;
import com.timain.pojo.User;
import com.timain.service.BillService;
import com.timain.vo.BillsVO;
import com.timain.web.utils.LoginUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yyf
 * @version 1.0
 * @date 2020/6/12 18:17
 */
@RequestMapping("bills")
@RestController
public class BillController {
    
    @Reference
    private BillService billService;

    /**
     * 分页查询账单
     * @param billsVO
     * @return
     */
    @RequestMapping("loadAllBills")
    public DataGridView loadAllBills(BillsVO billsVO) {
        User user = (User) LoginUtils.getSession().getAttribute("user");
        billsVO.setUserId(user.getId());
        return this.billService.findAll(billsVO);
    }

    /**
     * 添加账单
     * @param bills
     * @return
     */
    @RequestMapping("addBills")
    public ResultObj addBills(Bills bills) {
        try {
            User user = (User) LoginUtils.getSession().getAttribute("user");
            bills.setUserId(user.getId());
            this.billService.addBill(bills);
            return ResultObj.ADD_BILL_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.ADD_BILL_ERROR;
        }
    }

    /**
     * 修改账单信息
     * @param bills
     * @return
     */
    @RequestMapping("updateBills")
    public ResultObj updateBills(Bills bills) {
        try {
            billService.updateBill(bills);
            return ResultObj.UPDATE_BILL_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.UPDATE_BILL_ERROR;
        }
    }

    /**
     * 批量删除
     * @param billsVO
     * @return
     */
    @RequestMapping("delMoreBills")
    public ResultObj delMoreBills(BillsVO billsVO) {
        int i = billService.deleteBills(billsVO);
        if (i > 0) {
            return ResultObj.DELETE_SUCCESS;
        }
        return ResultObj.DELETE_ERROR;
    }
}
