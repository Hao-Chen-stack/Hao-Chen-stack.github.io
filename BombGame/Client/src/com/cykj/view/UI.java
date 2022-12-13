package com.cykj.view;

import com.cykj.controller.CliController;
import com.cykj.view.game.ChooseMapFrame;
import com.cykj.view.game.GameFrame;

public class UI {
    public CliController con;
    public static CliLoginFrame loginFrame;
    public static CliLogonFrame logonFrame;
    public static CliGameFrame gameFrame;
    public static CliSendOneFrame sendOneFrame;
    public static CliRecordsFrame recordsFrame;
    public static CliSendOneRecFrame sendOneRecFrame;
    public static CliImgJFrame imgJWindow;
    public static CliPersonalCenterFrame personalCenterFrame;
    public static CliGameRoomFrame gameRoomFrame;
    public static CliGameDesFrame gameDesFrame;
    public static ProgressBar progressBar;
    public static CliWaitRoomFrame chooseMap;
    public static GameFrame hitGameFrame;
    public static ChooseMapFrame chooseMapFrame;
    public UI(CliController con){
        this.con = con;

        loginFrame = new CliLoginFrame(con);
        logonFrame = new CliLogonFrame(con);
        gameFrame = new CliGameFrame(con);
        sendOneFrame = new CliSendOneFrame(con);
        recordsFrame = new CliRecordsFrame(con);
        sendOneRecFrame = new CliSendOneRecFrame(con);
        imgJWindow = new CliImgJFrame(con);
        personalCenterFrame = new CliPersonalCenterFrame(con);
        gameRoomFrame = new CliGameRoomFrame(con);
        gameDesFrame = new CliGameDesFrame(con);
        progressBar = new ProgressBar(con);
        chooseMap = new CliWaitRoomFrame(con);
        hitGameFrame = new GameFrame(con);
        chooseMapFrame = new ChooseMapFrame(con);

    }
}
