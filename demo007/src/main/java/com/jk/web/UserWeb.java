package com.jk.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.InternalResourceView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Controller
public class UserWeb {

    /**
     * 1,通过@RequestMapping类映射请求的URL
     * 2,返回值会通过视图解析器解析为物理视图,对于InternalResourceViewResolver解析规则:
     * 前缀+返回值+后缀
     * 3,解析完成后做转发操作
     *
     * @return
     */
    @RequestMapping("/sayhello")
    public String sayHello() {
        System.out.println("sayhello");
        return "hello";
    }
}
