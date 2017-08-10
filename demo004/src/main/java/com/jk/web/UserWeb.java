package com.jk.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.InternalResourceView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Controller
@RequestMapping("/user")
public class UserWeb {


    @RequestMapping("/modelandview")
    public String modelAndView() {

        return "hello";
    }
}
