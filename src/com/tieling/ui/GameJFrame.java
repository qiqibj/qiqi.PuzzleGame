package com.tieling.ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GameJFrame extends JFrame implements KeyListener, ActionListener {

    //定义打乱数据, 加载图片的时候, 会根据二维数组中的数据进行加载
    int[][] data = new int[4][4];
    //定义正确的数组顺序
    int[][] win  = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 0}};
    //记录空白方块在二维数组中的位置
    int x = 0, y = 0;
    //定义变量管理步数
    int step = 0;

    //定义变量记录当前展示图片的路径
    String path = "E:\\java\\代码\\day17_code\\PuzzleGame\\image\\animal\\animal3\\";

    //定义常量
    private final int LEFT = 37;
    private final int UP = 38;
    private final int RIGHT = 39;
    private final int DOWN = 40;
    private final int W = 87;
    private final int A = 65;
    private final int S = 83;
    private final int D = 68;
    private final int Q = 81;
    private final int E = 69;


    //创建选项下面的条目
    JMenuItem replayItem = new JMenuItem("重新游戏");
    JMenuItem reLoginItem = new JMenuItem("重新登录");
    JMenuItem closeItem = new JMenuItem("关闭游戏");

    JMenuItem accountItem = new JMenuItem("公众号");
    
    //跟游戏相关的代码
    public GameJFrame() {

        //初始化界面
        initJFrame();
        //初始化菜单
        initJFrameBar();

        //初始化数据(打乱)
        initData();

        //初始化图片(打乱)
        initImage();

        //让界面显示出来
        this.setVisible(true);
    }



        /**
         * 初始化数据的方法，将一个整数数组随机打乱后填充到一个二维数组中。
         */
    private void initData() {
        // 创建一个临时数组并初始化为0到15的整数
        int[] tempArr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        // 创建一个Random对象用于生成随机数
        Random rand = new Random();
        // 遍历临时数组，将其元素随机交换位置
        for (int i = 0; i < tempArr.length; i++) {
            int temp1 = tempArr[i];
            int temp2 = rand.nextInt(tempArr.length);
            tempArr[i] = tempArr[temp2];
            tempArr[temp2] = temp1;
        }
        // 将打乱后的临时数组的元素填充到二维数组Data中
        for (int i = 0; i < tempArr.length; i++) {
            if (tempArr[i] == 0) {
                x = i / 4;
                y = i % 4;
            }
            data[i / 4][i % 4] = tempArr[i];
        }
    }


    //初始化图片
    private void initImage() {
        //清空已经有的图片
        this.getContentPane().removeAll();

        if (victory()) {
            JLabel win = new JLabel(new ImageIcon("E:\\java\\代码\\day17_code\\PuzzleGame\\image\\win.png"));
            win.setBounds(203, 283, 197, 73);
            this.getContentPane().add(win);
        }

        JLabel stepCount = new JLabel("步数 : " + step);
        stepCount.setBounds(50, 30, 100, 20);
        this.getContentPane().add(stepCount);

        //先加载的图片在上面
        //外循环 --- 把内循环重复执行4次
        for (int i = 0; i < 4; i++) {
            //内循环 --- 表示在一行我要添加4张图片
            for (int j = 0; j < 4; j++) {
                int number = data[i][j];
                //创建一个图片ImageIcon的对象
                //创建一个JLabel的对象(管理容器)
                JLabel jLabel = new JLabel(new ImageIcon(path + number + ".jpg"));
                //指定图片的位置
                jLabel.setBounds(105 * j + 83, 105 * i + 134, 105, 105);
                //给图片添加边框
                jLabel.setBorder(new BevelBorder(BevelBorder.LOWERED));
                //把管理容器添加到界面中
                this.getContentPane().add(jLabel);
            }
        }
        //添加背景图片
        JLabel background = new JLabel(new ImageIcon("E:\\java\\代码\\day17_code\\PuzzleGame\\image\\background.png"));
        background.setBounds(40, 40, 508, 560);
        this.getContentPane().add(background);
        //刷新界面
        this.getContentPane().repaint();
    }


    private void initJFrameBar() {
        //初始化菜单
        //创建菜单对象
        JMenuBar jMenuBar = new JMenuBar();

        //创建菜单上面的两个选项的对象
        JMenu functionJMenu = new JMenu("功能");
        JMenu aboutJMenu = new JMenu("关于我们");


        //将每一个选项下面的条目放到选项下面
        functionJMenu.add(replayItem);
        functionJMenu.add(reLoginItem);
        functionJMenu.add(closeItem);

        aboutJMenu.add(accountItem);

        //给条目绑定事件
        replayItem.addActionListener(this);
        reLoginItem.addActionListener(this);
        closeItem.addActionListener(this);
        accountItem.addActionListener(this);

        //将菜单里面两个选项添加到菜单
        jMenuBar.add(functionJMenu);
        jMenuBar.add(aboutJMenu);

        //给整个菜单放到界面里
        this.setJMenuBar(jMenuBar);
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
        this.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == Q) {
            //把页面中的所有图片删除
            this.getContentPane().removeAll();
            //加载完整图片
            JLabel all = new JLabel(new ImageIcon(path + "all.jpg"));
            all.setBounds(83, 134, 420, 420);
            this.getContentPane().add(all);
            //添加背景图片
            JLabel background = new JLabel(new ImageIcon("E:\\java\\代码\\day17_code\\PuzzleGame\\image\\background.png"));
            background.setBounds(40, 40, 508, 560);
            this.getContentPane().add(background);
            //刷新界面
            this.getContentPane().repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //判断游戏是否胜利，如果胜利，此方法需要直接结束，不能再执行下面的代码
        if (victory()) {
            //结束方法
            return ;
        }
        //对上, 下, 左, 右进行判断
        //左: 37, 上: 38, 右: 39, 下: 40
        int code = e.getKeyCode();
        System.out.println(code);
        switch (code) {
            case RIGHT, D -> {
                if (y == 0) {
                    break;
                }
                System.out.println("向右移动");
                //交换空白图片
                data[x][y] = data[x][y - 1];
                data[x][y - 1] = 0;
                y--;
                //计数器
                step++;
                this.initImage();
            }
            case LEFT, A -> {
                if (y == 3) {
                    break;
                }
                System.out.println("向左移动");
                //交换空白图片
                data[x][y] = data[x][y + 1];
                data[x][y + 1] = 0;
                y++;
                //计数器
                step++;
                this.initImage();
            }
            case UP, W -> {
                if (x == 3) {
                    break;
                }
                System.out.println("向上移动");
                //交换空白图片
                data[x][y] = data[x + 1][y];
                data[x + 1][y] = 0;
                x++;
                //计数器
                step++;
                this.initImage();
            }
            case DOWN, S -> {
                if (x == 0) {
                    break;
                }
                System.out.println("向下移动");
                //交换空白图片
                data[x][y] = data[x - 1][y];
                data[x - 1][y] = 0;
                x--;
                //计数器
                step++;
                this.initImage();
            }
            case Q -> initImage();
            case E -> {
                data = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 0}};
                initImage();
            }
        }
    }


    //判断data是否和win相同
    //相同返回true, 不同返回false
    public boolean victory() {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if (data[i][j] != win[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //获取当前被点击的条目对象
        if (e.getSource() == replayItem) { //重新游戏
            //计步器清零
            step = 0;
            //再次打乱图片
            initData();
            //重新加载图片
            initImage();

        } else if (e.getSource() == reLoginItem) { //重新登录
            //关闭当前界面
            this.setVisible(false);
            //打开登录界面
            new LoginJFrame();
        } else if (e.getSource() == closeItem) { //关闭游戏
            //直接关闭虚拟机
            System.exit(0);
        } else if (e.getSource() == accountItem) { //公众号

        }
    }
}
