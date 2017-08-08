package com.jk.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.InternalResourceView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Controller
@RequestMapping("/user")
public class UserWeb {

    @RequestMapping("/login")
    public String login() {
        return "success";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register() {
        return "success";
    }

    @RequestMapping(value = "/updateUserName", params = {"userid!=null","phone"})
    public String updateUserName() {
        return "success";
    }

}
