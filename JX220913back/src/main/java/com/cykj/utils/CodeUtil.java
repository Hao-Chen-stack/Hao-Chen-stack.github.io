package com.cykj.utils;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@Controller
public class CodeUtil {

    @RequestMapping({"authCode"})
    public void getAuthCode(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        //图片宽高
        int width = 92;
        int height = 47;
        Random random = new Random();
        //设置response头信息
        //禁止缓存
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        //生成缓冲区image类
        BufferedImage image = new BufferedImage(width,height,1);
        //产生image类的Graphics用于绘制操作
        Graphics g = image.getGraphics();
        //Graphics类的样式
        g.setColor(this.getRandColor(200, 250));
        g.setFont(new Font("Times New Roman",0,28));
        g.fillRect(0,0,width,height);
        //绘制干扰线
        for (int i = 0; i < 40 ; i++) {
            g.setColor(this.getRandColor(130,200));
            //拿到宽高
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            //开始写干扰线的x,y
            int x1 = random.nextInt(12);
            int y1 = random.nextInt(12);
            g.drawLine(x,y,x+x1,y+y1);
        }

        //绘制字符
        String strCode = "";
        for (int i = 0; i < 4 ; i++) {
            String rand = String.valueOf(random.nextInt(10));
            strCode = strCode +rand;
            g.setColor(new Color(20+random.nextInt(110),20+random.nextInt(110),20+random.nextInt(110)));
            g.drawString(rand,13*i+6,28);
        }

        //将字符保存到session中用于前端的验证
        session.setAttribute("strCode", strCode);
        g.dispose();

        //利用IO流发送给前端
        ImageIO.write(image, "JPEG", response.getOutputStream());
        response.getOutputStream().flush();

    }

    /**
     * @description:生成颜色的方法
     * @author: chenhao
     * @date: 2022/12/28 12:58
     * @param: [i, i1]
     * @return: java.awt.Color
     **/
    private Color getRandColor(int fc, int bc) {
        Random random = new Random();
        if (fc>255){
            fc = 255;
        }
        if (bc>255){
            bc = 255;
        }
        int r = fc + random.nextInt(bc-fc);
        int g = fc + random.nextInt(bc-fc);
        int b = fc + random.nextInt(bc-fc);
        return new Color(r,g,b);
    }
}
