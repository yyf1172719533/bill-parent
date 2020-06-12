package com.timain.service;

import com.timain.common.DataGridView;
import com.timain.pojo.Bills;
import com.timain.vo.BillsVO;

/**
 * @author yyf
 * @version 1.0
 * @date 2020/6/12 16:27
 */
public interface BillService {

    /**
     * 查询全部账单
     * @return
     */
    DataGridView findAll(BillsVO billsVO);

    /**
     * 添加账单
     * @param bills
     */
    void addBill(Bills bills);
}
