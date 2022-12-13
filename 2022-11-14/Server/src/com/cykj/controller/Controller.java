package com.cykj.controller;


import com.cykj.Thread.ServerReadFileThread;
import com.cykj.Thread.SeverThread;

public class Controller {
    SeverThread severThread;
//    ServerReadFileThread serverReadFileThread;
    public Controller() {
        severThread = new SeverThread();
        severThread.start();

//        serverReadFileThread = new ServerReadFileThread();
//        serverReadFileThread.start();
    }
}
