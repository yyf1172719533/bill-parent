package com.timain.web.controller;

import com.timain.common.DataGridView;
import com.timain.common.ResultObj;
import com.timain.pojo.Bills;
import com.timain.service.BillService;
import com.timain.vo.BillsVO;
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
            this.billService.addBill(bills);
            return ResultObj.ADD_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.ADD_ERROR;
        }
    }
}
