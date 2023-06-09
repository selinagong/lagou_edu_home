package com.lagou.controller;

import com.lagou.domain.ResponseResult;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/upload")
public class fileUploadController {

    @RequestMapping("/fileUpload")
    public ResponseResult fileUpload(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {
        //1.判断文件是否为空
        if (file.isEmpty()){
            throw new  RuntimeException();
        }
        //2.获取项目部署路径
        String realPath = request.getServletContext().getRealPath("/");
        String ssmWeb = realPath.substring(0, realPath.indexOf("ssm_web"));

        //3.获取原文件名
        String filename = file.getOriginalFilename();

        //4.生成新文件名
        assert filename != null;
        String newFilename = System.currentTimeMillis() + filename.substring(filename.lastIndexOf("."));


        //5.文件上传
        String uploadPath = ssmWeb + "/upload";
        File filePath = new File(uploadPath, newFilename);

        // 如果目录不存在就创建目录
        if(!filePath.getParentFile().exists()){
            filePath.getParentFile().mkdirs();
            System.out.println("创建目录：" + filePath);
        }

        // 图片就进行了真正的上传
        file.transferTo(filePath);

        // 6. 将文件名和文件路径返回，进行响应
        Map<String,String> map = new HashMap<>();
        map.put("fileName",newFilename);
        map.put("filePath","http://localhost:8080/upload/"+newFilename);

        return new ResponseResult(true, 200, "图片上传成功", map);
    }
}
