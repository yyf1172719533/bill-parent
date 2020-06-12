package com.timain.web.controller;

import com.timain.common.DataGridView;
import com.timain.service.BillTypeService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yyf
 * @version 1.0
 * @date 2020/6/12 18:17
 */
@RestController
@RequestMapping("billType")
public class BillTypeController {
    
    @Reference
    private BillTypeService billTypeService;

    /**
     * 查询所有类型
     * @return
     */
    @RequestMapping("loadAllBillType")
    public DataGridView loadAllBillType() {
        return this.billTypeService.selectAll();
    }
}
