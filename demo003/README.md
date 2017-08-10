springmvc4.x-控制器方法入参
====================

1、使用@RequestParam把请求参数传递给方法参数;@RequestParam的属性:
---
```
   value:请求参数名称；
   
   required：请求参数是否是必须的，默认为必须,如不存在抛异常；
   
   defaultValue：请求参数的默认值

```

例子:
```
    @RequestMapping("/sayhello")
    public String sayHello(@RequestParam(value = ("userid"), required = true) String userid) {
        System.out.println("sayhello:" + userid);
        return "hello";
    }
   
   //客户端请求
   <a href="/demo003/sayhello?userid=123465">RequestParam例子1</a>
```

```
    @RequestMapping("/register")
    public String register(@RequestParam(value = ("gender"), defaultValue = "woman") String gender) {
        System.out.println("register:" + gender);
        return "hello";
    }
    
    //客户端请求
    <a href="/demo003/register?gender=man">RequestParam例子2</a>
```

2、使用@RequestHeader将请求头映射到方法的参数中，@RequestHeader属性:
---
```
   value:请求头的键，如 value = ("Accept-Language")；
   
   required：该请求头是否是必须的，默认为必须,如不存在抛异常；
   
   defaultValue：请求头的默认值

```
例子：
```
    @RequestMapping("/login")
    public String login(@RequestHeader(value = ("Accept-Language"), required = false) String acceptLanguage) {
        System.out.println("login:" + acceptLanguage);
        return "hello";
    }
```

3、使用@CookieValue将cookie值映射到方法的参数中，@CookieValue属性：
---
```
   value:cookie的键，如value = ("JSESSIONID")；
   
   required：该cookie值是否是必须的，默认为必须,如不存在抛异常；
   
   defaultValue：cookie值的默认值

```
例子:
```
    @RequestMapping("/info")
    public String info(@CookieValue(value = ("JSESSIONID"), required = false) String jsessionid) {
        System.out.println("info:" + jsessionid);
        return "hello";
    }
```

4、将请求参数绑定到bean对象中，springmvc会自动将请求参数名和对象的属性名进行自动的匹配,自动为该对象填充属性值,支持级联属性.
----------------------------------------------------------------------

4.1、先创建两个类，User和Address,User里有Address：

Address.java:
```
package com.jk.web;

public class Address {
    private String city;
    private String road;

    public String getRoad() {
        return road;
    }
    public void setRoad(String road) {
        this.road = road;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", road='" + road + '\'' +
                '}';
    }
}

```
User.java:
```
package com.jk.web;
public class User {

    private String userid;
    private int age;
    private Address address;

    public String getUserid() {
        return userid;
    }
    public void setUserid(String userid) {
        this.userid = userid;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }
    @Override
    public String toString() {
        return "User{" +
                "userid='" + userid + '\'' +
                ", age=" + age +
                ", address=" + address +
                '}';
    }
}

```
4.2、控制器，直接将User作为方法参数:
```
    @RequestMapping("/update")
    public String update(User user) {
        System.out.println("info:" + user);
        return "hello";
    }
```
4.3、客户端请求：
```
<form action="/demo003/update" method="post">
    <input name="userid" type="text" placeholder="userid">
    <input name="age" type="text" placeholder="age">
    
    <%--user里有个address,address里有city,需要这么写--%>
    
    <input name="address.city" type="text" placeholder="city">
    <input name="address.road" type="text" placeholder="road">
    <input type="submit" value="提交">
</form>
```
5、使用Servlet API作为方法的参数:可以作为参数的Servlet API类型：
----
```
    HttpServletRequest 
    HttpServletResponse 
    HttpSession 
    java.security.Principal 
    Locale 
    InputStream 
    OutputStream 
    Reader 
    Writer
```
例子:
```
    @RequestMapping("/add")
    public String add(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("request:" + request + "--response:" + response);
        return "hello";
    }
```