package com.jk.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequestMapping("/com")
public class ComWeb {


    /**
     * @param username
     * @param map
     */
    @ModelAttribute
    public void beforeMethods(@RequestParam(value = "username", required = true) String username,
                              Map<String, Object> map) {
        System.out.println("beforeMethods username=" + username);

        User user = new User();
        user.setUserName(username);
        user.setUserid("as23asdfc56");

        //放入请求域中，传递给下一个方法
        map.put("user", user);
    }

    @RequestMapping(value = "update")
    public String update(User user) {
        System.out.println("update user=" + user);
        return "hello";
    }

    @RequestMapping(value = "add")
    public String add(User user) {
        System.out.println("add user=" + user);
        return "hello";
    }
}
