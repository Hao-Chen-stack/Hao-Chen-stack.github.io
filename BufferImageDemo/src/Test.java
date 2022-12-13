import com.sun.javafx.iio.ImageStorage;
import sun.awt.image.BufferedImageGraphicsConfig;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class Test {
    public static void main(String[] args) {
        String file1 = "C:\\Users\\86182\\Desktop\\弹弹堂素材\\背包底纹头盔.png";
        String file2 = "C:\\Users\\86182\\Desktop\\弹弹堂素材\\背包底纹盔甲.png";

        try {
            InputStream in1 = new FileInputStream(file1);
            BufferedImage image1 = ImageIO.read(in1);
            int width1 = image1.getWidth();
            int height1 = image1.getHeight();

            InputStream in2 = new FileInputStream(file2);
            BufferedImage image2 = ImageIO.read(in1);
            int width2 = image1.getWidth();
            int height2 = image1.getHeight();

            int w = width1;
            int h = height1+height2;
            BufferedImage image = new BufferedImage(w,h, BufferedImage.TYPE_INT_RGB);
            BufferedImageGraphicsConfig config = BufferedImageGraphicsConfig.getConfig(image);
            image = config.createCompatibleImage(w, h, Transparency.TRANSLUCENT);
            Graphics g = image.getGraphics();
            g.drawImage(image1,0,0,null);
            g.drawImage(image2,0,height1,null);
            g.dispose();

            File file = new File("C:\\Users\\86182\\Desktop\\1.png");
            ImageIO.write(image,"PNG",file);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
