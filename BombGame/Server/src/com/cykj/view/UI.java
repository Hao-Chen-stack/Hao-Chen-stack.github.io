package com.cykj.view;

import com.cykj.controller.Controller;
import com.cykj.view.LoginFrame;

public class UI {
    public Controller con;
    public static LoginFrame loginFrame;
    public UI(Controller con){
        this.con = con;

        loginFrame = new LoginFrame(con);
    }
}
