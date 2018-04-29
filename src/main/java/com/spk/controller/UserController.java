package com.spk.controller;


import com.alibaba.fastjson.JSON;
import com.spk.model.User;
import com.spk.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private IUserService userService;

    @RequestMapping("/showUser")
    @ResponseBody
    public String toIndex(HttpServletRequest request){
        User user = new User();
        try {
            int userId = Integer.parseInt(request.getParameter("id"));
            user = this.userService.getUserById(userId);
        }catch (Exception e){
            e.printStackTrace();
        }
        return JSON.toJSONString(user);
    }
}
