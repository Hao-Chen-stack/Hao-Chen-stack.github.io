package com.cykj.controller;

import com.cykj.Thread.FileServerSocketThread;

public class Controller {
    FileServerSocketThread fileServerSocketThread;
    public Controller(){
        fileServerSocketThread = new FileServerSocketThread();
        fileServerSocketThread.start();
    }
}
