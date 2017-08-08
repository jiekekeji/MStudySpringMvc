springmvc-@RequestMapping
===

一、映射路径:@RequestMapping注解可以作用于方法也可以作用于类

1、映射方法:如下访问路径为相对于web应用跟目录:
```
@Controller
public class UserWeb {

    @RequestMapping("/login")
    public String login() {

        return "success";
    }
}
```

2、映射类:给方法的路径加上一个相对路径,访问路径为 /user/login
```
@Controller
@RequestMapping("/user")
public class UserWeb {

    @RequestMapping("/login")
    public String login() {

        return "success";
    }
}
```

二、映射请求方法:
```
    @RequestMapping(value = "/register", method = RequestMethod.POST)
```
value 指定访问的路径,method指定访问的方法:
```
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register() {

        return "success";
    }
```
