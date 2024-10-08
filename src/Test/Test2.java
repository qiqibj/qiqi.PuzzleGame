package Test;

import javax.swing.*;

public class Test2 {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
            //设置界面的宽高
        frame.setSize(603, 680);
            //界面标题
        frame.setTitle("拼图游戏(单机版) v1.0");
            //设置界面置顶
        frame.setAlwaysOnTop(true);
            //设置界面居中
        frame.setLocationRelativeTo(null);
            //设置关闭方式
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

            //取消默认的居中放置
        frame.setLayout(null);

        JButton jtb = new JButton("点我啊");

        jtb.setBounds(0, 0, 100, 50);
        jtb.addActionListener(e -> System.out.println("被点了"));
        frame.getContentPane().add(jtb);

        frame.setVisible(true);
    }
}
