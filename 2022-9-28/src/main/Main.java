package main;

import controller.Controller;
import controller.MouseGameTimer;
import view.UI;

public class Main {
    public static void main(String[] args) {
//        BigMouse bMouse = new BigMouse("子类参数");
//        bMouse.showInfo();

//        bMouse.ranPos();
//        System.out.println(bMouse.mouseX+""+bMouse.mouseY);

//        Scanner sc = new Scanner(System.in);
        Controller con = new Controller();
        UI myUI = new UI(con);


//        while (true){
//            System.out.println("欢迎来到打地鼠游戏，输入1代表注册，输入2代表登录，输入其他无效");
//            int check = sc.nextInt();
//            if (check ==1){
//                con.enroll();
//            }else if (check ==2){
//                if (con.login()){
//                    break;
//                }
//
////                 boolean b1 = con.login();
////                if (b1 ==true){
////                    break;
////                }
//            }
//        }
//
//
//        con.initMapSize();
//        while (true){
//            con.initMap();
//            con.putMouse();
//            con.putProp();
//            con.drawMap();
//            con.hitMouse();
//            con.checkAns();
//            if (con.nowPlayer.playerBlood <= 0) {
//                System.out.println("血量为0,是否重新开始，否输入s，是输入其他");
//                String gameEnd = sc.next();
//                System.out.println(gameEnd);
//                if (gameEnd.equals("s")){
//                    System.out.println("游戏结束");
//                    break;
//                }else{
//                    System.out.println("游戏继续");
//                    con.nowPlayer.playerBlood=3;//恢复到初始的3点血量
//                    con.nowPlayer.playPoint =0 ;//积分重置
//                    con.initMapSize();
//                    System.out.println("加油 再来一次");
//                }
//            }
//        }

    }
}
