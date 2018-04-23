package com.practis.controller;

import com.practis.model.User;
import com.practis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.File;


@Controller
public class Login {
    @Autowired
    private UserService userService;

    @RequestMapping("login")
    public synchronized String login(User user, String code, HttpServletRequest request) {
        System.out.println(user);
        if (userService.selectByUsername(user) != null) {
            if (userService.selectByUser(user) != null && code.trim().toString().equals(request.getSession().getAttribute("verify").toString().trim())) {
                request.getSession().setAttribute("user", userService.selectByUser(user));
                File file = new File(request.getServletContext().getRealPath("/") + "/images/code");
                file.delete();
                return "index";

            } else {
                request.setAttribute("message", "密码错误");
                return "page/login/login";
            }

        } else if (!code.trim().toString().equals(request.getSession().getAttribute("verify").toString().trim())) {
            request.setAttribute("codeMessage", "验证码不正确");
            return "page/login/login";
        } else {
            request.setAttribute("message", "账号不存在");
            return "page/login/login";
        }
    }
}

