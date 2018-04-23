package com.practis.controller;

import com.practis.model.User;
import com.practis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;

@Controller
public class Register {
    @Autowired
    private UserService userService;

    @RequestMapping("/reg")
    public String reg(User user, HttpServletRequest request){
        System.out.println(userService.selectByUsername(user)+"******");
        //查询账号是否存在
        if(userService.selectByUsername(user)==null){
            System.out.println(userService.insertSelective(user));
            return "page/login/login";
        }else {
            request.setAttribute("message","账号已存在");
            return "reg";
        }
    }
}
