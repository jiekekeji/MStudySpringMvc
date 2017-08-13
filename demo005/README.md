springmvc4.x-重定向和转发
===

1、重定向:用户访问/user/login,告诉用户重新请求/user/info,并携带参数：
```
@Controller
@RequestMapping("/user")
public class UserWeb {

    @RequestMapping("login")
    public String login() {
        System.out.println("login");
        //拼接参数传值
        return "redirect:/user/info?userid=j3k2jd3&username=jack";
    }

    @RequestMapping("info")
    public String info(String userid, String username) {
        System.out.println("info:userid=" + userid + " username=" + username);
        return "hello";
    }
}
```
页面访问/user/login
```
<a href="/demo005/user/login">login</a>
```

2、转发：用户请求/user/register,将请求转发到到/user/ingo处理，请求/user/register的参数会自动传递给/user/ingo:
```
@Controller
@RequestMapping("/user")
public class UserWeb {

    @RequestMapping("register")
    public String register() {
        System.out.println("register");
        return "forward:/user/info";
    }

    @RequestMapping("info")
    public String info(String userid, String username) {
        System.out.println("info:userid=" + userid + " username=" + username);
        return "hello";
    }
}
```
页面访问/user/register:
```
<a href="/demo005/user/register?userid=j3k2jd3&username=jack">register</a>
```
