package com.jk.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.InternalResourceView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("user")
public class UserWeb {

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

    /**
     * 多文件上传
     *
     * @param files
     * @return
     */
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

    /**
     * 带额外参数的文件上传
     *
     * @param userid
     * @param files
     * @return
     */
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
}
