package com.cykj.view;

import com.cykj.controller.CliController;
import com.cykj.controller.CliSendOneActLis;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class CliSendOneRecPanel extends JPanel {
    public CliController con;
    public Font font = new Font("宋体", Font.PLAIN, 25);
    public JTable recTable = new JTable();
    private DefaultTableModel recTm = new DefaultTableModel();
    private JScrollPane scrollPane = new JScrollPane();
    private JButton upBtn = new JButton("上一页");
    private JLabel pageLabel;
    private JLabel pageTotalLabel;
    private JButton downBtn = new JButton("下一页");
    public int nowPage = 1;//当前页数
    public int pageTotal = 0;//总页数

    public DefaultTableModel getRecTm() {
        return recTm;
    }

    public void setRecTm(DefaultTableModel recTm) {
        this.recTm = recTm;
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public void setScrollPane(JScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }

    public JButton getUpBtn() {
        return upBtn;
    }

    public void setUpBtn(JButton upBtn) {
        this.upBtn = upBtn;
    }

    public JLabel getPageLabel() {
        return pageLabel;
    }

    public void setPageLabel(JLabel pageLabel) {
        this.pageLabel = pageLabel;
    }

    public JLabel getPageTotalLabel() {
        return pageTotalLabel;
    }

    public void setPageTotalLabel(JLabel pageTotalLabel) {
        this.pageTotalLabel = pageTotalLabel;
    }

    public JButton getDownBtn() {
        return downBtn;
    }

    public void setDownBtn(JButton downBtn) {
        this.downBtn = downBtn;
    }

    public CliSendOneRecPanel(CliController con){
        this.con = con;
        setBackground(new Color(0, 0, 0));//背景颜色
        setLayout(null);//自由布局

        //按钮
        add(upBtn);
        upBtn.setBounds(10,200,150,40);
        add(downBtn);
        downBtn.setBounds(420,200,150,40);

        //监听的注册和安装
        CliSendOneActLis sendOneActLis = new CliSendOneActLis(con);
        upBtn.addActionListener(sendOneActLis);
        upBtn.setActionCommand("up");
        downBtn.addActionListener(sendOneActLis);
        downBtn.setActionCommand("down");

        //分页
        pageLabel = new JLabel("当前页数："+nowPage);
        pageTotalLabel = new JLabel("总页数：");
        add(pageLabel);
        add(pageTotalLabel);
        pageLabel.setForeground(new Color(0,255,0));
        pageLabel.setBounds(200,200,100,40);
        pageTotalLabel.setForeground(new Color(0,255,0));
        pageTotalLabel.setBounds(300,200,100,40);
        initTable();
    }

    public void initTable(){
        String[] header = {"发送者","接收者","消息内容","消息时间"};
        recTm.setColumnIdentifiers(header);
        recTable.setModel(recTm);
        recTable.getTableHeader().setReorderingAllowed(false);
        scrollPane.setViewportView(recTable);
        scrollPane.setBounds(0,0,600,200);
        this.add(scrollPane);
    }
}
