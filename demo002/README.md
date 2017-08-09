springmvc4.x-@RequestMapping注解
==============================

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

二、映射请求方法:value 指定访问的路径,method指定访问的方法，

```
    @RequestMapping(value = "/register", method = RequestMethod.POST)
```

完整示例

```
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register() {

        return "success";
    }
```

三、映射请求参数,通过params属性.例子:请求参数中必须包含userid,phone,并且phone的值不能为null, 如果请求参数不包含userid,或者不包含phone,或者phone的值为null都不能匹配到该方法:

```
@RequestMapping(value = "/updateUserName", params = {"userid", "phone", "phone!=null"})
```

完整示例

```
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
```

四、映射请求头。例子：请求头中必须包含token，并且token的值不能为null,否则匹配不到。

```
@RequestMapping(value = "/updatePassword", headers = {"token", "token!=null"})
```

完整示例

```
    /**
     * 请求头中必须包含token，并且token的值不能为null,否则匹配不到
     * @return
     */
    @RequestMapping(value = "/updatePassword", headers = {"token", "token!=null"})
    public String updatePassword() {
        return "success";
    }
```






