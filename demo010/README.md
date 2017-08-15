springmvc4.x-文件上传
===

一、在pom.xml中加入如下依赖：
---
```
<!--start 文件上传需要的jar包 -->
<dependency>
    <groupId>commons-fileupload</groupId>
    <artifactId>commons-fileupload</artifactId>
    <version>1.2.1</version>
</dependency>

<dependency>
    <groupId>commons-io</groupId>
    <artifactId>commons-io</artifactId>
    <version>1.4</version>
</dependency>
<!--end 文件上传需要的jar包 -->
```

二、在springmvc的配置文件中加入如下配置:
---
```
<!-- 文件上传配置 -->
<bean id="multipartResolver" class="org.springframework.web.multipart.commons.CommonsMultipartResolver">
    <!-- 默认编码 -->
    <property name="defaultEncoding" value="UTF-8"/>
    <!-- 上传文件大小限制为31M，31*1024*1024 -->
    <property name="maxUploadSize" value="32505856"/>
    <!-- 内存中的最大值 -->
    <property name="maxInMemorySize" value="4096"/>
</bean>
```

三、单文件上传：
---
1、控制器：
```
    /**
     * 单文件上传
     *
     * @param file
     * @return
     */
    @RequestMapping(value = "uploadfile1", method = RequestMethod.POST)
    @ResponseBody
    public String loadFile1(@RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            //保存上传的文件
            if (saveFile(file)) {
                return "ok";
            }
        }
        return "error";
    }
    
    //保存上传的文件
    private Boolean saveFile(MultipartFile file) {
        // 文件存放服务端的位置
        String rootPath = "H:/TestDir";
        try {
            File dir = new File(rootPath + File.separator + "tmpFiles");
            if (!dir.exists()) {
                dir.mkdirs();
            }
            File serverFile = new File(dir.getAbsolutePath() + File.separator + file.getOriginalFilename());
            file.transferTo(serverFile);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
```
2、客户端页面,注意：enctype="multipart/form-data"  :
```
<form method="post" enctype="multipart/form-data" action="/demo010/user/uploadfile1">
    <input type="file" name="file"/>
    <input type="submit" value="Submit"/>
</form>
```

四、多文件上传 :
1、控制器

```
   @RequestMapping(value = "uploadfile2", method = RequestMethod.POST)
   @ResponseBody
   public String loadFile2(@RequestParam("files") MultipartFile[] files) {
       List<String> list = new ArrayList<String>();
       if (files != null && files.length > 0) {
           //循环获取file数组中得文件
           for (int i = 0; i < files.length; i++) {
               MultipartFile file = files[i];
               if (saveFile(file)) {
                   list.add("ok");
               } else {
                   list.add("error");
               }
           }
       }
       System.out.println(list);
       return list.toString();
   }
    //保存上传的文件
    private Boolean saveFile(MultipartFile file) {
        // 文件存放服务端的位置
        String rootPath = "H:/TestDir";
        try {
            File dir = new File(rootPath + File.separator + "tmpFiles");
            if (!dir.exists()) {
                dir.mkdirs();
            }
            File serverFile = new File(dir.getAbsolutePath() + File.separator + file.getOriginalFilename());
            file.transferTo(serverFile);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
```

2、客户端页面,注意：enctype="multipart/form-data"  :
```
<%--多文件上传--%>
<form method="post" enctype="multipart/form-data" action="/demo010/user/uploadfile2">
    <input type="file" name="files"/>
    <input type="file" name="files"/>
    <input type="file" name="files"/>
    <input type="submit" value="Submit"/>
</form>
```

五、带额外参数的文件上传：
1、控制器：
```
@RequestMapping(value = "uploadfile3", method = RequestMethod.POST)
    @ResponseBody
    public String loadFile3(String userid, @RequestParam("files") MultipartFile[] files) {
        List<String> list = new ArrayList<String>();
        if (files != null && files.length > 0) {
            //循环获取file数组中得文件
            for (int i = 0; i < files.length; i++) {
                MultipartFile file = files[i];
                if (saveFile(file)) {
                    list.add("ok");
                } else {
                    list.add("error");
                }
            }
        }
        System.out.println("userid=" + userid);
        System.out.println(list);
        return "userid=" + userid + "&&" + list.toString();
    }

    //保存上传的文件
    private Boolean saveFile(MultipartFile file) {
        // 文件存放服务端的位置
        String rootPath = "H:/TestDir";
        try {
            File dir = new File(rootPath + File.separator + "tmpFiles");
            if (!dir.exists()) {
                dir.mkdirs();
            }
            File serverFile = new File(dir.getAbsolutePath() + File.separator + file.getOriginalFilename());
            file.transferTo(serverFile);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
```

2、客户端页面,注意：enctype="multipart/form-data"  :
```
<%--带参数的文件上传--%>
<form method="post" enctype="multipart/form-data" action="/demo010/user/uploadfile3">
    <input type="text" name="userid"/>
    <input type="file" name="files"/>
    <input type="file" name="files"/>
    <input type="file" name="files"/>
    <input type="submit" value="Submit"/>
</form>
```
