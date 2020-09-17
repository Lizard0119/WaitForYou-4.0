package com.qy.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@CrossOrigin
@RestController
@RequestMapping("/ensure")
public class MyController {

        //上传文件
        @PostMapping("/uploadwork")
        public String uploadWork(HttpServletRequest request, @RequestParam(value = "file", required = false) MultipartFile file) throws IOException {


            request.setCharacterEncoding("UTF-8");
            String user = request.getParameter("user");

            if(!file.isEmpty()) {
                String fileName = file.getOriginalFilename();

                String type = fileName.indexOf(".") != -1 ? fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length()) : null;
                if (type != null) {
                    if ("DOCX".equals(type.toUpperCase())||"DOC".equals(type.toUpperCase())||"PDF".equals(type.toUpperCase())||"JPD".equals(type.toUpperCase())) {
                        // 项目在容器中实际发布运行的根路径
                        String realPath = request.getSession().getServletContext().getRealPath("/");
                        // 自定义的文件名称
                        String trueFileName = user + "_" + fileName;

                        System.out.println(trueFileName);
                        // 设置存放图片文件的路径
                        String path = "F:\\111" + trueFileName;
                        System.out.println(path);
                        System.out.println(12);
                        File dest = new File(path);
                        System.out.println(dest.toString());
                        //判断文件父目录是否存在
                        if (!dest.getParentFile().exists()) {
                            dest.getParentFile().mkdir();
                        }

                        file.transferTo(dest);

                        return trueFileName;
                    }else {
                        return " ";
                    }
                }else {
                    return "error";
                }
            }else {
                return "error";
            }
        }

    }

