package com.timain.dto;

import com.timain.pojo.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @Author: yyf
 * @Date: 2021/1/14 16:52
 * @Version: 1.0
 */
@Data
@Accessors(chain = true)
public class UserDTO extends User {
}
