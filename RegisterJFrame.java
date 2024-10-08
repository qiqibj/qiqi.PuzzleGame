package com.tieling.ui;

import javax.swing.*;

public class RegisterJFrame extends JFrame {
    //跟注册相关的代码
    public RegisterJFrame() {
        //设置界面的宽高
        this.setSize(488, 500);
        //界面标题
        this.setTitle("拼图游戏(单机版) -注册- v1.0");
        //设置界面置顶
        this.setAlwaysOnTop(true);
        //设置界面居中
        this.setLocationRelativeTo(null);
        //设置关闭方式
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //让界面显示出来
        this.setVisible(true);
    }
}
