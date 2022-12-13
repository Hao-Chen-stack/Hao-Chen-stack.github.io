package com.cykj.controller;

import com.cykj.Thread.ServerSocketThread;

public class Controller {
    ServerSocketThread serverSocketThread;
    public Controller(){
        serverSocketThread = new ServerSocketThread();
        serverSocketThread.start();
    }
}
