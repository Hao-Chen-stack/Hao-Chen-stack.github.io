package controller;

import model.Tank_Enemy;
import view.UI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GameCustomActLis implements ActionListener {
    public Controller con;
    public GameCustomActLis(Controller con) {
        this.con = con;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JComboBox){
            JComboBox jComboBox = (JComboBox) e.getSource();//强转下拉框组件
            System.out.println();
            switch (jComboBox.getActionCommand()){
                case "comboBoxNextLevel":
                    String strN = jComboBox.getSelectedItem().toString().trim();
                    int intN = Integer.parseInt(strN);
                    System.out.println(intN);
                    con.levels = intN-1;
                    break;
            }
        }

        }
    }
