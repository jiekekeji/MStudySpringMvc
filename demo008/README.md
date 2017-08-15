springmvc4.x-自定义拦截器
===

一、Spring MVC 也可以使用拦截器对请求进行拦截处理，用户可以自定义拦截器来实现特定的功能，自定义的拦截器必须实现HandlerInterceptor接口。
----
        preHandle()：
        这个方法在业务处理器处理请求之前被调用，在该方法中对用户请求 request 进行处理。
        如果程序员决定该拦截器对请求进行拦截处理后还要调用其他的拦截器，或者是业务处理器去进行处理，则返回true；
        如果程序员决定不需要再调用其他的组件去处理请求，则返回false。
        
        postHandle()：
        这个方法在业务处理器处理完请求后调用，但是DispatcherServlet 向客户端返回响应前被调用，在该方法中对用户请求request进行处理。
        
        afterCompletion()：
        这个方法在 DispatcherServlet 完全处理完请求后被调用，可以在该方法中进行一些资源清理的操作。

二、实现过程：
---
1、定义HelloInterceptor，继承HandlerInterceptorAdapter，实现响应的方法：
```
public class HelloInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle");
        return super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle");
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion");
        super.afterCompletion(request, response, handler, ex);
    }
}
```

2、定义拦截器注解：
```
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface HelloInterceptor {
}
```

3、配置拦截器，在springmvc的配置文件中配置拦截器：
```
<!--拦截器配置-->
<mvc:interceptors>
    <!-- 权限拦截器 -->
    <mvc:interceptor>
        <!--拦截规则，拦截所有请求,这样配置静态资源的请求会被拦截-->
        <mvc:mapping path="/*"/>
        <!-- 需排除拦截的地址,如static下的静态资源不需要拦截 -->
        <mvc:exclude-mapping path="/static/**"/>
        <bean class=" com.jk.web.HelloInterceptor"/>
    </mvc:interceptor>
</mvc:interceptors>
```

4、在响应的控制器方法上加上拦截器注解：@com.jk.annotation.HelloInterceptor
```
@Controller
public class UserWeb {

    @com.jk.annotation.HelloInterceptor
    @RequestMapping("/sayhello")
    public String sayHello() {
        System.out.println("sayhello");
        return "hello";
    }
}
```