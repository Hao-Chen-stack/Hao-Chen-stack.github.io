package com.cykj.utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Random;

public class CodeUtils {
    /**
     * 以字符串形式返回生成的验证码，同时输出一个图片
     *
     * @param width
     *            图片的宽度
     * @param height
     *            图片的高度
     * @param imgType
     *            图片的类型
     * @param output
     *            图片的输出流(图片将输出到这个流中)
     * @return 返回所生成的验证码(字符串)
     */
    public static String create(final int width, final int height, final String imgType, OutputStream output) {
        //存储正确的验证码
        StringBuffer sb = new StringBuffer();
        Random random = new Random();

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        //画笔
        Graphics graphic = image.getGraphics();

        graphic.setColor(new Color(253,245,204));
        graphic.fillRect(0, 0, width, height);

        Color[] colors = new Color[] { Color.BLUE, Color.GRAY, Color.GREEN, Color.RED, Color.BLACK, Color.ORANGE,
                Color.CYAN };
        // 在 "画板"上生成干扰线条 ( 50 是线条个数)
        for (int i = 0; i < 50; i++) {
            graphic.setColor(colors[random.nextInt(colors.length)]);
            final int x = random.nextInt(width);
            final int y = random.nextInt(height);
            final int w = random.nextInt(20);
            final int h = random.nextInt(20);
            final int signA = random.nextBoolean() ? 1 : -1;
            final int signB = random.nextBoolean() ? 1 : -1;
            graphic.drawLine(x, y, x + w * signA, y + h * signB);
        }

        // 在 "画板"上绘制字母
        graphic.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        for (int i = 0; i < 4; i++) {
            final int temp = random.nextInt(26) + 97;
            String s = String.valueOf((char) temp);
            sb.append(s);
            graphic.setColor(colors[random.nextInt(colors.length)]);
            graphic.drawString(s, i * (width / 4), height - (height / 3));
        }
        graphic.dispose();
        try {
            ImageIO.write(image, imgType, output);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    /*public static void main(String[] args) throws FileNotFoundException {
        OutputStream outputStream = new FileOutputStream(new File("F:\\个人文件夹\\桌面\\新建文件夹 (2)\\666.jpg"));
        create(200,50,"jpg",outputStream);
    }*/
}
