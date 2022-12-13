package com.cykj.view;

import com.cykj.controller.CliController;

public class UI {
    public CliController con;
    public static CliLoginUserFrame loginUserFrame;
    public static CliLogonFrame logonFrame;
    public static CliChatFrame chatFrame;
    public static CliRecordsFrame cliRecordsFrame;
    public UI(CliController con){
        this.con = con;

        loginUserFrame = new CliLoginUserFrame(con);
        logonFrame = new CliLogonFrame(con);
        chatFrame = new CliChatFrame(con);
        cliRecordsFrame = new CliRecordsFrame(con);
    }
}
