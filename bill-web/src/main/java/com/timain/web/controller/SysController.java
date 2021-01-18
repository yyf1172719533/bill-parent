package com.timain.web.controller;

import com.timain.common.ResultObj;
import com.timain.dto.UserDTO;
import com.timain.pojo.User;
import com.timain.service.UserService;
import com.timain.web.utils.LoginUtils;
import com.timain.web.utils.Md5Utils;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: yyf
 * @Date: 2021/1/14 15:59
 * @Version: 1.0
 */
@RequestMapping("sys")
@Controller
public class SysController {

    @Reference
    private UserService userService;

    /**
     * 跳转到登录页面
     * @return
     */
    @RequestMapping("toLogin")
    public String toLogin() {
        return "login";
    }

    /**
     * 跳转到注册页面
     * @return
     */
    @RequestMapping("toRegister")
    public String toRegister() {
        return "register";
    }

    /**
     * 注册用户
     * @param userDTO
     * @return
     */
    @RequestMapping("doRegister")
    @ResponseBody
    public ResultObj doRegister(UserDTO userDTO) {
        if (StringUtils.isBlank(userDTO.getUserName()) || StringUtils.isBlank(userDTO.getPassword())) {
            return ResultObj.DATA_ERROR;
        }
        User existUser = userService.findUserByName(userDTO);
        if (null != existUser) {
            return ResultObj.USER_EXIST;
        }
        User user = new User();
        user.setUserName(userDTO.getUserName())
            .setPassword(Md5Utils.md5Pwd(userDTO.getPassword()));
        int i = userService.addUser(user);
        if (i > 0) {
            return ResultObj.ADD_SUCCESS;
        }
        return ResultObj.ADD_ERROR;
    }

    /**
     * 用户登录
     * @param userDTO
     * @return
     */
    @RequestMapping("doLogin")
    @ResponseBody
    public ResultObj doLogin(UserDTO userDTO) {
        if (StringUtils.isBlank(userDTO.getUserName()) || StringUtils.isBlank(userDTO.getPassword())) {
            return ResultObj.DATA_ERROR;
        }
        User user = userService.findUserByName(userDTO);
        if (null == user) {
            return ResultObj.USER_NOT_EXIST;
        }
        String password = userDTO.getPassword();
        if (user.getPassword().equals(Md5Utils.md5Pwd(password))) {
            LoginUtils.getSession().setAttribute("user", user);
            return ResultObj.LOGIN_SUCCESS;
        }
        return ResultObj.LOGIN_ERROR;
    }

    /**
     * 跳转到首页
     * @return
     */
    @RequestMapping("toIndex")
    public String toIndex(Model model) {
        User user = (User) LoginUtils.getSession().getAttribute("user");
        model.addAttribute("user", user);
        return "billIndex";
    }

    /**
     * 退出登录
     * @return
     */
    @RequestMapping("logout")
    public String logout() {
        LoginUtils.getSession().removeAttribute("user");
        return "redirect:/sys/toLogin";
    }
}
