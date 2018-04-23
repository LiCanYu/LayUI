package com.practis.controller;

import com.alibaba.fastjson.JSON;
import com.practis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.HashMap;
import java.util.Map;

@Controller
public class IndexLoading {
    @Autowired
    private UserService userService;

    @RequestMapping("loading")
    public Object loading(){
        Map map=new HashMap();
        map.put("用户总数",userService.selectNum());
        System.out.println("11111111111111111111");
        return JSON.toJSON(map);
    }
    //跳转到登录页面
    @RequestMapping("tologin")
    public String tologin(){
        return "page/login/login";
    }
//    @RequestMapping("/toIndex")
//    public ModelAndView toIndex(){
//        ModelAndView m = new ModelAndView();
//        m.setViewName("page/login/login");
//        return m;
//    }
    //跳转到注册页面
    @RequestMapping("toreg")
    public String toreg(){
        return "reg";
    }
    //跳转到用户信息页面
    @RequestMapping("toUserInfo")
    public String toUserInfo(){
        return "page/user/userInfo";
    }
}
