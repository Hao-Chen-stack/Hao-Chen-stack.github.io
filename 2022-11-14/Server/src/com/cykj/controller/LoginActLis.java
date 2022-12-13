package com.cykj.controller;

import com.cykj.view.UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;

public class LoginActLis implements ActionListener {
    public Controller con;
    public LoginActLis(Controller con){
        this.con = con;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "login":
                String user = UI.loginUserFrame.loginPanel.getUserTxt().getText();
                String psw = new String(UI.loginUserFrame.loginPanel.getUserPsw().getPassword());
                try {
                    Socket socket = new Socket("localhost",10086);//IP和端口
                    //字节流
                    InputStream inputStream = socket.getInputStream();
                    OutputStream outputStream = socket.getOutputStream();
                    //字节流转化成字符流
                    InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
                    //字符流转化成封装流
                    BufferedReader bufReader = new BufferedReader(inputStreamReader);
                    PrintWriter priWriter = new PrintWriter(outputStreamWriter);
                    //为服务端发送账号和密码
                     String data = "login\t" + "&&" +user +"\t"+"&&" +psw;
                    System.out.println("发送"+data);
                    priWriter.println(data);
                    priWriter.flush();//刷新
                    //接受来自服务端的信息
                    String line = bufReader.readLine();
                    System.out.println("接受"+line);
                    //关闭流和socket
                    priWriter.close();
                    bufReader.close();
                    socket.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                break;
            case "toLogon":
                break;
            case "quit":
                System.exit(0);
                break;
        }
    }
}
