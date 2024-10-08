package Test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MyJFrame extends JFrame implements ActionListener {
    JButton jBt1 = new JButton("点我啊");
    JButton jBt2 = new JButton("点我");

    public MyJFrame() {
        initJFrame();

        

        jBt1.setBounds(0, 0, 100, 50);
        jBt2.setBounds(100, 0, 100, 50);
        jBt1.addActionListener(this);
        jBt2.addActionListener(this);
        this.getContentPane().add(jBt1);
        this.getContentPane().add(jBt2);


        this.setVisible(true);
    }
    


    @Override
    public void actionPerformed(ActionEvent e) {
        if (jBt1 == e.getSource()) {
            jBt1.setBounds(0, 0, 200, 200);
        } else if (jBt2 == e.getSource()) {
            Random rand = new Random();
            jBt2.setLocation(rand.nextInt(500), rand.nextInt(500));
        }
    }

    private void initJFrame() {
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

        //取消默认的居中放置
        setLayout(null);
    }
}
