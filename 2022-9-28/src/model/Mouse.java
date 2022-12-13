package model;

import java.awt.*;
import java.util.Random;

public class Mouse {
    public int mouseX;
    public int mouseY;

        public Point holePoints[] = {
            new Point(125,320),
            new Point(300,320),
            new Point(480,320),

            new Point(125,430),
            new Point(300,430),
            new Point(480,430),

            new Point(125,560),
            new Point(300,560),
            new Point(485,560),
    };
    public boolean isHit = false;
    //random position 随机坐标
    public void ranPos(){ //在controller中调用
        Random ran = new Random();
        int ranNum = ran.nextInt(holePoints.length);
        mouseX = holePoints[ranNum].x;
        mouseY = holePoints[ranNum].y;

    }

}
