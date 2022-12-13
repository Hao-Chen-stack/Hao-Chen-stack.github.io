package view;

import controller.Controller;
import controller.HitMouseLis;
import model.Data;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    public Controller con;
    public RightGamePanel rightGamePanel = new RightGamePanel();
    public GamePanel(Controller con){
        setLayout(new BorderLayout());

        add(rightGamePanel,BorderLayout.EAST);
        this.con = con;

        //给界面安装鼠标监听
        HitMouseLis hitMouseLis = new HitMouseLis(con);
        addMouseListener(hitMouseLis);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
//        Image bgImg = new ImageIcon("images/map.png").getImage();

        //         图片本身，起始x坐标,起始y坐标，宽，高，null
        g.drawImage(Data.BGIMG,0,0,800,710,null);
//        g.drawImage(Data.MOUSEING,con.mouse1.mouseX,con.mouse1.mouseY,110,102,null);
        if (con.mouse1.isHit){
            g.drawImage(Data.HITMOUSEING,con.mouse1.mouseX,con.mouse1.mouseY,110,102,null);
        }else {
            g.drawImage(Data.MOUSEING,con.mouse1.mouseX,con.mouse1.mouseY,110,102,null);
        }

    }
}
