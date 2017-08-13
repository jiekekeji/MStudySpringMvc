springmvc4.x-视图和视图解析器
===

一、试图解析流程：
---
1、调用目标方法，SpringMVC将目标方法返回的String、View、ModelMap或是ModelAndView都转换为一个ModelAndView对象；

2、然后通过视图解析器（ViewResolver）对ModelAndView对象中的View对象进行解析，将该逻辑视图View对象解析为一个物理视图View对象；

3、最后调用物理视图View对象的render()方法进行视图渲染，得到响应结果。

二、常用视图实现类
---

![图片](https://github.com/jiekekeji/MStudySpringMvc/blob/master/demo006/preview/demo006.png)

三、视图实现类InternalResourceViewResolver 配置实例：
---
```
    <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
        <property name="prefix" value="/WEB-INF/views/"></property>
        <property name="suffix" value=".jsp"></property>
    </bean>
```

控制器方法：
```
    @Controller
    public class UserWeb {
    
        /**
         * 1,通过@RequestMapping类映射请求的URL
         * 2,返回值会通过视图解析器解析为物理视图,对于InternalResourceViewResolver解析规则:
         * 前缀+返回值+后缀
         * 3,解析完成后做转发操作
         *
         * @return
         */
        @RequestMapping("/sayhello")
        public String sayHello() {
    
            return "hello";
        }
    }
```