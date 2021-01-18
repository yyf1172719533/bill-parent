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
    
    public static final ResultObj ADD_SUCCESS = new ResultObj(200, "注册成功");
    public static final ResultObj ADD_ERROR = new ResultObj(-1, "注册失败");

    public static final ResultObj LOGIN_SUCCESS = new ResultObj(200, "登录成功");
    public static final ResultObj LOGIN_ERROR = new ResultObj(-1, "登录失败，密码不正确！");

    public static final ResultObj DELETE_SUCCESS = new ResultObj(200, "删除成功");
    public static final ResultObj DELETE_ERROR = new ResultObj(-1, "删除失败");

    public static final ResultObj ADD_BILL_SUCCESS = new ResultObj(200, "添加成功");
    public static final ResultObj ADD_BILL_ERROR = new ResultObj(-1, "添加失败");

    public static final ResultObj UPDATE_BILL_SUCCESS = new ResultObj(200, "修改成功");
    public static final ResultObj UPDATE_BILL_ERROR = new ResultObj(-1, "修改失败");

    public static final ResultObj DATA_ERROR = new ResultObj(-1, "数据异常");

    public static final ResultObj USER_EXIST = new ResultObj(-1, "该用户已存在");

    public static final ResultObj USER_NOT_EXIST = new ResultObj(-1, "该用户不存在");
}
