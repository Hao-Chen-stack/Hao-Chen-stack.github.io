package controller;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class GameWinLis implements WindowListener {
    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
//        System.out.println("ing");
        int ans = JOptionPane.showConfirmDialog(null,
                "请问是否关闭", "信息提示", JOptionPane.YES_NO_OPTION);
        System.out.println(ans);//JOptionPanel 有返回值 就是int型  可以决定   到底点了什么
        if (ans == 0){
            System.exit(0);
        }
    }

    @Override
    public void windowClosed(WindowEvent e) {
        System.out.println("ed");
    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
