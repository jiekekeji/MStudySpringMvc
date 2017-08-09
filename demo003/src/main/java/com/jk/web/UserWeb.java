package com.jk.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.InternalResourceView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Controller
public class UserWeb {

    /**
     * 使用@RequestParam把请求参数传递给方法;
     * 参数名称:value = ("userid"),
     * 是否必须:required = true,默认为必须,如不存在抛异常
     *
     * @param userid
     * @return
     */
    @RequestMapping("/sayhello")
    public String sayHello(@RequestParam(value = ("userid"), required = true) String userid) {
        System.out.println("sayhello:" + userid);
        return "hello";
    }

    /**
     * 默认值:defaultValue = "njklnlk"
     *
     * @param gender
     * @return
     */
    @RequestMapping("/register")
    public String register(@RequestParam(value = ("gender"), defaultValue = "woman") String gender) {
        System.out.println("register:" + gender);
        return "hello";
    }

    /**
     * 使用@RequestHeader将请求头映射到方法的参数中,
     * 请求的键:value = ("Accept-Language"),
     * 是否必须:required = true,默认为必须,如不存在抛异常
     *
     * @param acceptLanguage
     * @return
     */
    @RequestMapping("/login")
    public String login(@RequestHeader(value = ("Accept-Language"), required = false) String acceptLanguage) {
        System.out.println("login:" + acceptLanguage);
        return "hello";
    }

    /**
     * 使用@CookieValue将cookie映射到方法的参数中,
     * cookie的键:value = ("JSESSIONID"),
     * 是否必须:required = true,默认为必须,如不存在抛异常
     *
     * @param jsessionid
     * @return
     */
    @RequestMapping("/info")
    public String info(@CookieValue(value = ("JSESSIONID"), required = false) String jsessionid) {
        System.out.println("info:" + jsessionid);
        return "hello";
    }


    /**
     * 使用对象绑定请求参数值
     * springmvc会自动请求参数名和对象的属性进行自动的匹配,自动为该对象填充属性值,支持级联属性.
     *
     * @param user
     * @return
     */
    @RequestMapping("/update")
    public String update(User user) {
        System.out.println("info:" + user);
        return "hello";
    }
}
