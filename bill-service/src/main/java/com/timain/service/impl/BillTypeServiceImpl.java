package com.timain.service.impl;

import com.timain.common.DataGridView;
import com.timain.mapper.BillTypeMapper;
import com.timain.pojo.BillType;
import com.timain.service.BillTypeService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author yyf
 * @version 1.0
 * @date 2020/6/12 16:42
 */
@Service(timeout = 600000)
public class BillTypeServiceImpl implements BillTypeService {
    
    @Autowired
    private BillTypeMapper billTypeMapper;
    
    
    @Override
    public DataGridView selectAll() {
        List<BillType> billTypes = billTypeMapper.selectList(null);
        return new DataGridView(Long.valueOf(billTypes.size()), billTypes);
    }
}
