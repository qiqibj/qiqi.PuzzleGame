package Test;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyJFrame2 extends JFrame implements MouseListener {

    JButton jbt = new JButton("点我啊");

    public MyJFrame2() {
        //设置界面的宽高
        this.setSize(603, 680);
        //界面标题
        this.setTitle("拼图游戏(单机版) v1.0");
        //设置界面置顶
        this.setAlwaysOnTop(true);
        //设置界面居中
        this.setLocationRelativeTo(null);
        //设置关闭方式
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(null);
        jbt.setBounds(0, 0, 100, 50);
        jbt.addMouseListener(this);
        this.getContentPane().add(jbt);

        this.setVisible(true);

        //取消默认的居中放置
        setLayout(null);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("单击");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("按下不松");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("松开");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("划入");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("划出");
    }
}
