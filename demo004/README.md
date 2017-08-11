springmvc4.x-方法数据处理
===================

一、放入请求域中
--------

1、ModelAndView：控制器处理方法的返回值如果为 ModelAndView, 则其既包含视图信息，也包含模型数据信息。

控制器方法:
```
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
```

视图hello.jsp,从请求域中获取数据模型：
```
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>ModelAndView:${requestScope.userid },userid=${requestScope.user.userid},username=${requestScope.user.userName}</p>
</body>
</html>
```

2、Map:控制器方法的入参为 Map，

控制器方法:
```
    @RequestMapping("/testmap")
    public String testMap(Map<String, Object> map) {

        map.put("token", "id52asdasdc5");

        User user1 = new User();
        user1.setUserid("5asd5cas5c4asd2");
        user1.setUserName("jack");
        map.put("user1", user1);

        return "hello";
    }
```
视图hello.jsp,从请求域中获取数据模型：
```
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<p>TestMap:${requestScope.token },userid=${requestScope.user1.userid},username=${requestScope.user1.userName}</p>

</body>
</html>

```


二、放入会话域中
--------

1、@SessionAttributes:应用到Controller上面，可以将Model中的属性同步到session当中。

2、@SessionAttributes参数：
```
    1、names：这是一个字符串数组。里面应写需要存储到session中数据的名称。

　　2、types：根据指定参数的类型，将模型中对应类型的参数存储到session中

　  3、value：其实和names是一样的。
```

```
@SessionAttributes(names = {"userid", "token"}, types = {User.class})
```
将请求域中Model属性为userid,token,类型为User的读放入session域中，

3、控制器:
```
package com.jk.web;

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

```

视图hello.jsp,从会话域中获取数据模型：
```
<%--
  Created by IntelliJ IDEA.
  User: jack
  Date: 17/8/8
  Time: 00:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<p>
    SessionAttributes:userid=${sessionScope.userid },token=${sessionScope.token },user=${sessionScope.user1 },user1=${sessionScope.user1 }
</p>

</body>
</html>


```