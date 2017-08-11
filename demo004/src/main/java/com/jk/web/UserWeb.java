package com.jk.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.InternalResourceView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.Map;

@Controller
@RequestMapping("/user")
@SessionAttributes(names = {"userid", "token"}, types = {User.class})
public class UserWeb {


    @RequestMapping("/modelandview")
    public ModelAndView modelAndView() {
        //1、初始化ModelAndView并设置视图信息hello，完成后跳转hello.jsp视图
        ModelAndView modelAndView = new ModelAndView("hello");

        //2、添加数据模型
        modelAndView.addObject("userid", "a025asdf2c5asd23");

        //3、添加数据模型
        User user = new User();
        user.setUserid("5asd5cas5c4asd2");
        user.setUserName("jack");

        modelAndView.addObject("user", user);
        //4、返回ModelAndView
        return modelAndView;
    }

    @RequestMapping("/testmap")
    public String testMap(Map<String, Object> map) {

        map.put("token", "id52asdasdc5");

        User user1 = new User();
        user1.setUserid("5asd5cas5c4asd2");
        user1.setUserName("jack");
        map.put("user1", user1);

        return "hello";
    }
}
