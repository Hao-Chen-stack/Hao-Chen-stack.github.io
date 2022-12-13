package controller;

import view.game.GameLeftPanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameKeyLis implements KeyListener {
    public Controller con;
    public GameLeftPanel gameLeftPanel;
    public GameMusic gameMusic;

    public GameKeyLis(Controller con, GameLeftPanel gameLeftPanel) {
        this.con = con;
        this.gameLeftPanel = gameLeftPanel;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                System.out.println("W");
                con.tankP1.isUp = true;
                gameMusic = new GameMusic("music/MOVE.WAV");
                gameMusic.play();
                break;
            case KeyEvent.VK_S:
                System.out.println("S");
                con.tankP1.isDown = true;
                gameMusic = new GameMusic("music/MOVE.WAV");
                gameMusic.play();
                break;
            case KeyEvent.VK_A:
                System.out.println("A");
                con.tankP1.isLeft = true;
                gameMusic = new GameMusic("music/MOVE.WAV");
                gameMusic.play();
                break;
            case KeyEvent.VK_D:
                System.out.println("D");
                con.tankP1.isRight = true;
                gameMusic = new GameMusic("music/MOVE.WAV");
                gameMusic.play();
                break;
            case KeyEvent.VK_J:
                System.out.println("J");
                if (con.tankP1.fileTime >= 10) {
                    con.tankP1.playerShoot();
                    con.tankP1.fileTime = 0;
                    gameMusic = new GameMusic("music/Explode.wav");
                    gameMusic.play();
                }
                System.out.println("目前子弹总数为" + con.bullets.size());
                break;
            case KeyEvent.VK_P:
                System.out.println("P");
                con.tankGameTimer.myTimer.stop();
                break;
            case KeyEvent.VK_C:
                System.out.println("C");
                con.tankGameTimer.myTimer.start();
                break;
            //玩家2
            case KeyEvent.VK_UP:
                if (con.oneA_two) {
                    System.out.println("上");
                    con.tankP2.isUpP2 = true;
                }
                break;
            case KeyEvent.VK_DOWN:
                if (con.oneA_two) {
                    System.out.println("下");
                    con.tankP2.isDownP2 = true;
                }
                break;
            case KeyEvent.VK_LEFT:
                if (con.oneA_two) {
                    System.out.println("左");
                    con.tankP2.isLeftP2 = true;
                }
                break;
            case KeyEvent.VK_RIGHT:
                if (con.oneA_two) {
                    System.out.println("右");
                    con.tankP2.isRightP2 = true;
                }
                break;
            case KeyEvent.VK_NUMPAD1:
                if (con.oneA_two) {
                    if (con.tankP2.fileTime >= 10) {
                        con.tankP2.playerShoot();
                        con.tankP2.fileTime = 0;
                    }
                }
                System.out.println("目前子弹总数为" + con.bullets.size());
                break;


        }

    }


    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                con.tankP1.isUp = false;
                break;
            case KeyEvent.VK_S:
                con.tankP1.isDown = false;
                break;
            case KeyEvent.VK_A:
                con.tankP1.isLeft = false;
                break;
            case KeyEvent.VK_D:
                con.tankP1.isRight = false;
                break;
            case KeyEvent.VK_UP:
                System.out.println("上");
                con.tankP2.isUpP2 = false;
                break;
            case KeyEvent.VK_DOWN:
                System.out.println("下");
                con.tankP2.isDownP2 = false;
                break;
            case KeyEvent.VK_LEFT:
                System.out.println("左");
                con.tankP2.isLeftP2 = false;
                break;
            case KeyEvent.VK_RIGHT:
                System.out.println("右");
                con.tankP2.isRightP2 = false;
                break;
        }


    }
}
