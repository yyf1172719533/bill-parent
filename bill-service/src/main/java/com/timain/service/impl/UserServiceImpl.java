package com.timain.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.timain.dto.UserDTO;
import com.timain.mapper.UserMapper;
import com.timain.pojo.User;
import com.timain.service.UserService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: yyf
 * @Date: 2021/1/15 9:15
 * @Version: 1.0
 */
@Service(timeout = 600000)
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    @Override
    public int addUser(User user) {
        return this.userMapper.insert(user);
    }

    /**
     * 根据用户名查询用户
     *
     * @param userDTO
     * @return
     */
    @Override
    public User findUserByName(UserDTO userDTO) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("USER_NAME", userDTO.getUserName());
        return userMapper.selectOne(queryWrapper);
    }
}
