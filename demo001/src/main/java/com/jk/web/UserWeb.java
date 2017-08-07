package com.jk.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserWeb {

    @ResponseBody
    @RequestMapping("/sayhello")
    public String sayHello() {
        return "hello springmvc";
    }
}
