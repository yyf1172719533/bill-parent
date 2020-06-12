package com.timain.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yyf
 * @version 1.0
 * @date 2020/6/12 15:05
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultObj {
    
    private Integer code = 200;
    private String msg = "";

    public ResultObj(String msg) {
        super();
        this.msg = msg;
    }
    
    public static final ResultObj ADD_SUCCESS = new ResultObj("添加成功");
    public static final ResultObj ADD_ERROR = new ResultObj(-1, "添加失败");
}
