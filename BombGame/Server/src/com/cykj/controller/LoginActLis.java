package com.cykj.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginActLis implements ActionListener {
    public Controller con;

    public LoginActLis(Controller con) {
        this.con = con;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "login":

                break;
            case "quit":
                System.exit(0);
                break;
        }
    }
}
