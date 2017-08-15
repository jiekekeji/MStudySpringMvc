package com.jk.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserWeb {

    @RequestMapping("sayhello")
    public String sayHello() throws Exception {
        System.out.println("user sayhello");
        if (true) {
            throw new Exception("普通异常");
        }
        return "hello";
    }
}
