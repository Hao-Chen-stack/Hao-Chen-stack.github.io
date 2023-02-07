package com.cykj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;

@Controller
public class UploadController {
    //图片上传接口
    @RequestMapping(value = "/uploads",method = {RequestMethod.POST})
    @ResponseBody
    public String fileUploads(@RequestParam("myFile") CommonsMultipartFile file , HttpServletRequest request, Model model) throws IOException {
        //获取文件名:file.getOriginalFilename();
        String uploadFileName = file.getOriginalFilename();
        String data = null;
        //如果文件名为空，直接回到首页
        if ("".equals(uploadFileName)){
            data="";
            //封装数据
            return data;
        }
        System.out.println("上传文件名："+uploadFileName);

        //上传路径保存设置
        String path = request.getSession().getServletContext().getRealPath("/WEB-INF/uploads");
        //如果路径不存在，创建一个
        File realPath = new File(path);
        if (!realPath.exists()){
            realPath.mkdir();
        }
        System.out.println("上传文件保存地址："+realPath);
//        InputStream is = file.getInputStream();//文件输入流
//        OutputStream os = new FileOutputStream(new File(realPath,uploadFileName));//文件输出流
//
//        //读取写出
//        int len = 0;
//        byte[] buffer = new byte[1024];
//        while ((len=is.read(buffer))!=-1){
//            os.write(buffer,0,len);
//            os.flush();
//        }
//        os.close();
//        is.close();
        file.transferTo(new File(realPath+"/"+uploadFileName));
        System.out.println(realPath+"/"+uploadFileName);
        //返回给前端图片名
        data=uploadFileName;
        //封装数据
        return "uploads/"+data;
    }
}
