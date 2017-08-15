package com.jk.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exception")
public class ExceptionWeb {

    @RequestMapping("/sayhello")
    public String sayHello() {
        System.out.println("exception sayhello");
        return "hello";
    }
}
