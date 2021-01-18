package com.timain.service;

import com.timain.dto.UserDTO;
import com.timain.pojo.User;

/**
 * @Author: yyf
 * @Date: 2021/1/15 9:14
 * @Version: 1.0
 */
public interface UserService {

    /**
     * 添加用户
     * @param user
     * @return
     */
    int addUser(User user);

    /**
     * 根据用户名查询用户
     * @param userDTO
     * @return
     */
    User findUserByName(UserDTO userDTO);
}
