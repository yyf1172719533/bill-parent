package com.timain.vo;

import com.timain.pojo.Bills;
import lombok.Data;

import java.util.Date;

/**
 * @author yyf
 * @version 1.0
 * @date 2020/6/12 16:31
 */
@Data
public class BillsVO extends Bills {
    
    private static final long serialVersionUID = -3660665284950881552L;
    
    private Integer page = 1;
    private Integer limit = 10;
    private Date startTime;
    private Date endTime;
}
