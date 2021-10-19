package com.Jingyalin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;


@Controller
public class FileUploadController {

    @RequestMapping("/tiao")
    public String upload(){
        return "upload";
    }

    @ResponseBody
    @PostMapping("/upload")
    public String upload(MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        fileName= UUID.randomUUID().toString().replace("-","")+fileName.substring(fileName.lastIndexOf("."));

        System.out.println(fileName);
        File f=new File("E:\\aaa");
        if(!f.exists()){
            f.mkdirs();
        }
        file.transferTo(new File(f,fileName));
        return null;
    }
}
