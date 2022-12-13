package main;

import controller.Controller;
import view.UI;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Controller con = new Controller();
        UI myUI = new UI(con);

    }
}
