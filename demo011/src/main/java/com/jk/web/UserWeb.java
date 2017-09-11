package com.jk.web;

import com.jk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.InternalResourceView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("user")
public class UserWeb {

    @Autowired
    UserService userService;

    public UserWeb() {
        System.out.println("UserWeb");
    }

    @RequestMapping(value = "findUserByID")
    @ResponseBody
    public String findUserByID(String id) {

        return "ok";
    }

}
