package controller;

import view.UI;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

//这里改成继承mouse抽象类
public class ToLoginLis extends MouseAdapter {
    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
        System.out.println(1);
        UI.logonFrame.setVisible(false);//注册
        UI.loginFrame.setVisible(true);//登录
    }
}
