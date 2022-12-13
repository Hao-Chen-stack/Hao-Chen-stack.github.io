package model;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Player {
    public int playerX;
    public int playerY;
    public int playerBlood = 3;//血量
    public int playPoint;//积分
    public int playerCombo;//连击

    public String playerAcc;//账号
    public String playerPwd;//密码

    public Player(String acc,String pwd){
        this.playerAcc = acc;
        this.playerPwd = pwd;
    }

    public Player() {
        this.playPoint = 0;
        this.playerCombo = 0;
    }


    //玩家的打老鼠方法
    public void hitMouse(int mapX,int mapY){
        System.out.println("请按顺序输入X 和Y坐标打老鼠");
        try {
            Scanner sc = new Scanner(System.in);
            playerX = sc.nextInt();
            playerY = sc.nextInt();
        }catch (InputMismatchException e){
            System.out.println("输入的不是数字，请输入数字");
            hitMouse(mapX,mapY);
            return;
        }catch (Exception e){
            System.out.println("程序错误，请联系程序管理员");
            hitMouse(mapX,mapY);
            return;
        }
        if(playerX<0 || playerY<0 ||playerX>=mapX || playerY>=mapY){
            System.out.println("您输入的数字，超出范围");
            hitMouse(mapX,mapY);
            return;
        }
        //1.输入的不是数字
        //2.输入的数字超出范围
    }

}
