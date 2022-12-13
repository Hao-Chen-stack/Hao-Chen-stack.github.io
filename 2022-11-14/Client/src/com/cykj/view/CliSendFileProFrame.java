package com.cykj.view;

import javax.swing.*;

public class CliSendFileProFrame extends JFrame {
    private JProgressBar sendFilePro;

    public JProgressBar getSendFilePro() {
        return sendFilePro;
    }

    public void setSendFilePro(JProgressBar sendFilePro) {
        this.sendFilePro = sendFilePro;
    }

    public CliSendFileProFrame(int max){
        sendFilePro = new JProgressBar(0,max);//最大值为传输文件的大小
        setTitle("文件传输进度");
        setSize(600,100);
        setResizable(false);//不可更改大小
        setLocationRelativeTo(null);//居中
        setLayout(null);//自由布局

        sendFilePro.setBounds(0,0,600,100);
        add(sendFilePro);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);//点叉只关窗口
        setVisible(true);
    }
}
