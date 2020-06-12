package com.timain.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.timain.common.DataGridView;
import com.timain.mapper.BillTypeMapper;
import com.timain.mapper.BillsMapper;
import com.timain.pojo.BillType;
import com.timain.pojo.Bills;
import com.timain.service.BillService;
import com.timain.vo.BillsVO;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * @author yyf
 * @version 1.0
 * @date 2020/6/12 16:41
 */
@Service(timeout = 600000)
public class BillServiceImpl implements BillService {
    
    @Autowired
    private BillsMapper billsMapper;
    @Autowired
    private BillTypeMapper billTypeMapper;
    
    @Override
    public DataGridView findAll(BillsVO billsVO) {
        Page<Bills> page = new Page<>(billsVO.getPage(), billsVO.getLimit());
        QueryWrapper<Bills> wrapper = new QueryWrapper<>();
        wrapper.eq(null!=billsVO.getTypeId(), "typeid", billsVO.getTypeId());
        wrapper.ge(null!=billsVO.getStartTime(), "billtime", billsVO.getStartTime());
        wrapper.le(null!=billsVO.getEndTime(), "billtime", billsVO.getEndTime());
        wrapper.orderByDesc("billtime");
        this.billsMapper.selectPage(page, wrapper);
        List<Bills> list = page.getRecords();
        for (Bills bills : list) {
            BillType billType = billTypeMapper.selectById(bills.getTypeId());
            bills.setTypeName(billType.getName());
        }
        return new DataGridView(page.getTotal(), list);
    }

    @Override
    public void addBill(Bills bills) {
        bills.setBillTime(new Date());
        billsMapper.insert(bills);
    }
}
