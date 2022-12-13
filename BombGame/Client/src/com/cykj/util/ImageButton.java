package com.cykj.util;

import javax.swing.*;
import java.awt.*;

//带图标的按钮
public class ImageButton extends JButton {
        public ImageButton(ImageIcon icon){
        this.setDoubleBuffered(true);
        setIcon(icon);//设置图标
        setMargin(new Insets(0,0,0,0));//设置空白边距
        setIconTextGap(0);//设置文本与图标之间的间距
//        setBorderPainted(false);//指定是否绘制边框
        setBorder(null);//设置边框
        setText(null);//设置文本
        setSize(icon.getImage().getWidth(null), icon.getImage().getHeight(null));
    }
}
