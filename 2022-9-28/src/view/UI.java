package view;

import controller.Controller;

public class UI {
    public static LogonFrame logonFrame;
    public static LoginFrame loginFrame;
    public static GameFrame gameFrame;
    public Controller con;
    public UI(Controller con){
        this.con = con;//UI内可以不写

        loginFrame = new LoginFrame(con);
        logonFrame = new LogonFrame(con);
        gameFrame = new GameFrame(con);
    }
}
