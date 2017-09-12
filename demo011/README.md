springmvc4.x-spring和springmvc整合(独立的配置文件)
===

一、整合过程：
-------
1、在resources目录下创建spring的配置文件spring.xml和springmvc的配置文件spring-mvc.xml:

spring.xml:
```
<!--spring扫描器,不扫描@Controller和@ControllerAdvice注解,这两个注解给springmvc扫描-->
<context:component-scan base-package="com.jk">
    <context:exclude-filter type="annotation"
                            expression="org.springframework.stereotype.Controller"></context:exclude-filter>
    <context:exclude-filter type="annotation"
                            expression="org.springframework.web.bind.annotation.ControllerAdvice"></context:exclude-filter>
</context:component-scan>
```
spring-mvc.xml:
```
<!-- 自动扫描  @Controller,只扫描以下的两个注解,其他的有spring扫描-->
<context:component-scan base-package="com.jk" use-default-filters="false">
    <context:include-filter type="annotation"
                            expression="org.springframework.stereotype.Controller"></context:include-filter>
    <context:include-filter type="annotation"
                            expression="org.springframework.web.bind.annotation.ControllerAdvice"></context:include-filter>
</context:component-scan>
```

spring和springmvc都扫描cm.jk包，如果不区别开来，bean会被重复扫描创建，所以用include-filter和exclude-filter区别。

2、在web.xml中配置启动spring和springmvc的ioc容器:

web.xml:
```
    <!--start 配置spring IOC容器的监听器-->
    <context-param>
        <param-name>contextConfigLocation</param-name>
        <param-value>classpath:spring.xml</param-value>
    </context-param>
    <!-- 启动 IOC 容器的 ServletContextListener -->
    <listener>
        <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
    </listener>
    <!--end 配置spring IOC容器的监听器-->
    
    <!--start 配置springmvc IOC容器-->
    <servlet>
        <servlet-name>Dispatcher</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
        <init-param>
            <param-name>contextConfigLocation</param-name>
            <param-value>classpath:spring-mvc.xml</param-value>
        </init-param>
        <load-on-startup>1</load-on-startup>
    </servlet>
    <servlet-mapping>
        <servlet-name>Dispatcher</servlet-name>
        <!--<url-pattern>/</url-pattern>  会匹配到/login这样的路径型url，不会匹配到模式为*.jsp这样的后缀型url-->
        <!--<url-pattern>/*</url-pattern> 会匹配所有url：路径型的和后缀型的url(包括/login,*.jsp,*.js和*.html等)-->
        <url-pattern>/</url-pattern>
    </servlet-mapping>
    <!--end 配置springmvc IOC容器-->
```

3、测试代码：

3.1、服务UserService.java:
```
@Service
public class UserService {
    public UserService() {
        System.out.println("User");
    }
}
```

3.2、控制器:
```
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
```

4、spring IOC容器和springmvc IOC容器的关系，在springmvc IOC可以引用到spring IOC，但是spring IOC无法引用到springmvc IOC容器：

比如在控制器UserWeb中可以通过@Autowired获取UserService，

但是在UserService中无法通过通过@Autowired获取UserWeb。