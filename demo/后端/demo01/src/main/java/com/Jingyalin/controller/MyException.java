package com.Jingyalin.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@ControllerAdvice
@Component
public class MyException {
    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public void firstException(MaxUploadSizeExceededException max, HttpServletResponse res) throws IOException {
     res.setContentType("text/html;charset=utf-8");
        PrintWriter out = res.getWriter();
        out.write("上传文件大小超出限制!");
        out.flush();
        out.close();
    }
}
