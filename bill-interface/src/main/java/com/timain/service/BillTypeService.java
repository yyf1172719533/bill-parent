package com.timain.service;

import com.timain.common.DataGridView;

/**
 * @author yyf
 * @version 1.0
 * @date 2020/6/12 16:34
 */
public interface BillTypeService {

    /**
     * 查询所有类型
     * @return
     */
    DataGridView selectAll();
}
