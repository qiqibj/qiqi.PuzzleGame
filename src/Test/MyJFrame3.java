package Test;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyJFrame3 extends JFrame implements KeyListener {


    public MyJFrame3() {

        initJFrame();

        addKeyListener(this);


        setVisible(true);
    }

    private void initJFrame() {
        setSize(500, 600);
        setTitle("拼图");
        setAlwaysOnTop(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("按下不送");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == 65) {
            System.out.println("现在按的是A");
        } else if (e.getKeyCode() == 66) {
            System.out.println("现在按的是B");
        }
    }
}
