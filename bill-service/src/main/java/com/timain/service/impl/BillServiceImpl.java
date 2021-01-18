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
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
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
        wrapper.eq("USER_ID", billsVO.getUserId());
        wrapper.like(StringUtils.isNotBlank(billsVO.getTitle()), "TITLE", billsVO.getTitle());
        wrapper.eq(null!=billsVO.getTypeId(), "TYPE_ID", billsVO.getTypeId());
        wrapper.ge(null!=billsVO.getStartTime(), "BILL_TIME", billsVO.getStartTime());
        wrapper.le(null!=billsVO.getEndTime(), "BILL_TIME", billsVO.getEndTime());
        wrapper.orderByDesc("BILL_TIME");
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

    /**
     * 修改账单信息
     *
     * @param bills
     */
    @Override
    public void updateBill(Bills bills) {
        billsMapper.updateById(bills);
    }

    /**
     * 批量删除账单信息
     *
     * @param billsVO
     * @return
     */
    @Override
    public int deleteBills(BillsVO billsVO) {
        return billsMapper.deleteBatchIds(Arrays.asList(billsVO.getIds()));
    }
}
