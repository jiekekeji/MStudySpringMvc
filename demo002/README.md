springmvc4.x-控制器方法路径映射
======================

一、映射路径:@RequestMapping注解可以作用于方法也可以作用于类
---
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

二、带请求方法的路径映射:value 指定访问的路径,method指定访问的方法，
-----------------------------------------
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

三、带请求参数的路径映射：通过params属性.例子:请求参数中必须包含userid,phone,并且phone的值不能为null, 如果请求参数不包含userid,或者不包含phone,或者phone的值为null都不能匹配到该方法:
-----------------------------------------------------------------------------------------------------------------------
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

四、带请求头的路径映射:例子,请求头中必须包含token，并且token的值不能为null,否则匹配不到。
-----------------------------------------------------
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

五、@PathVariable 绑定 URL 占位符到入参:
---
1、带占位符的 URL 是 Spring3.0 新增的功能，该功能在SpringMVC 向 REST 目标挺进发展过程中具有里程碑的意义。

2、通过 @PathVariable 可以将 URL 中占位符参数绑定到控制器处理方法的入参中：URL 中的 {xxx} 占位符可以通过@PathVariable("xxx") 绑定到操作方法的入参中。

将URL中的占位符userid映射到方法参数userid中:

```
    @RequestMapping(value = "/updateEmail/{userid}")
    public String updateEmail(@PathVariable("userid") String userid) {
        System.out.println("接收的请求参数userid:" + userid);
        return "success";
    }
```

请求路径为：/updateEmail/123 ，那么获取到的userid=123。

