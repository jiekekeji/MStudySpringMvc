package com.jk.web;

import com.jk.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.InternalResourceView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Controller
public class UserWeb {

    @com.jk.annotation.HelloInterceptor
    @RequestMapping("/sayhello")
    public String sayHello() {
        System.out.println("sayhello");
        return "hello";
    }
}
