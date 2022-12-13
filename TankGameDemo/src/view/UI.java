package view;

import controller.Controller;
import view.game.GameCustomFrame;
import view.game.GameFrame;
import view.game.GameLeaderFrame;
import view.game.GameOverFrame;
import view.login.LoginFrame;
import view.welcome.WelcomeFrame;

public class UI {
    public static WelcomeFrame welcomeFrame;
    public static LoginFrame loginFrame;
    public static GameFrame gameFrame;
    public static GameLeaderFrame gameLeaderFrame;
    public static GameCustomFrame gameCustomFrame;
    public static GameOverFrame gameOverFrame;
    public Controller con;
    public UI(Controller con){
        this.con = con;
        welcomeFrame = new WelcomeFrame(con);
        loginFrame = new LoginFrame(con);
        gameFrame = new GameFrame(con);
        gameLeaderFrame = new GameLeaderFrame(con);
        gameCustomFrame = new GameCustomFrame(con);
        gameOverFrame = new GameOverFrame(con);

    }
}
