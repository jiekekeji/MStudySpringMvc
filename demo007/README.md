springmvc4.x-处理静态资源
===

1、DispatcherServlet请求映射为 /,则springMvc将捕获WEB容器的所有请求(包括静态资源请求)，SpringMvc将静态资源的请求
挡住普通的请求查找对应的处理器，找不到将导致错误。

2、解决办法，在springmvc的配置文件spring-mvc.xml加入：
```
    <mvc:default-servlet-handler/>

    <mvc:annotation-driven/>
```

配置<mvc:default-servlet-handler/>的含义：
```
    <!--
    default-servlet-handler 将在 SpringMVC 上下文中定义一个 DefaultServletHttpRequestHandler,
    它会对进入 DispatcherServlet 的请求进行筛查, 如果发现是没有经过映射的请求, 就将该请求交由 WEB 应用服务器默认的
    Servlet 处理. 如果不是静态资源的请求，才由 DispatcherServlet 继续处理

    一般 WEB 应用服务器默认的 Servlet 的名称都是 default.
    若所使用的 WEB 服务器的默认 Servlet 名称不是 default，则需要通过 default-servlet-name 属性显式指定

    -->

```