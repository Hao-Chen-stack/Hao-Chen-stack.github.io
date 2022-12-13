package com.cykj.view;

import com.cykj.controller.Controller;

public class UI {
    public Controller con;
    public static LoginUserFrame loginUserFrame;
    public UI(Controller con){
        this.con = con;

        loginUserFrame = new LoginUserFrame(con);
    }
}
