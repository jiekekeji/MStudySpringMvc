package com.jk.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.InternalResourceView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Controller
@RequestMapping("/user")
public class UserWeb {

    @RequestMapping("login")
    public String login() {
        System.out.println("login");
        return "redirect:/user/info?userid=j3k2jd3&username=jack";
    }

    @RequestMapping("register")
    public String register() {
        System.out.println("register");
        return "forward:/user/info";
    }

    @RequestMapping("info")
    public String info(String userid, String username) {
        System.out.println("info:userid=" + userid + " username=" + username);
        return "hello";
    }
}
