package com.cykj.main;

import com.cykj.controller.CliController;
import com.cykj.view.UI;

public class CliMain {
    public static void main(String[] args) {
        CliController con = new CliController();
        UI myUI = new UI(con);
    }


}
