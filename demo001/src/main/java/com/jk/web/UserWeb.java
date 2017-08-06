package com.jk.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserWeb {

    @RequestMapping("sayhello")
    public String sayHello() {
        return "hello springmvc";
    }
}
