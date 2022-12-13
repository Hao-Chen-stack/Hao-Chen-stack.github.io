package model;

import java.util.Random;

public class Prop implements GamePos {   //道具
    public int propX;
    public int propY;

    @Override
    public void ranPos(int mapX, int mapY) {
        Random ran = new Random();
        propX = ran.nextInt(mapX);
        propY = ran.nextInt(mapY);
    }
}
