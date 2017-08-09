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

    /**
     * 请求参数中必须包含userid,phone,并且phone的值不能为null,
     * 如果请求参数不包含userid,或者不包含phone,或者phone的值为null都不能匹配到该方法
     *
     * @return
     */
    @RequestMapping(value = "/updateUserName", params = {"userid", "phone", "phone!=null"})
    public String updateUserName() {
        return "success";
    }

    /**
     * 请求头中必须包含token，并且token的值不能为null,否则匹配不到
     * @return
     */
    @RequestMapping(value = "/updatePassword", headers = {"token", "token!=null"})
    public String updatePassword() {
        return "success";
    }


}
