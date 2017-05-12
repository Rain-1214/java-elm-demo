package com.firstWork;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;

public class SnakeApp {
	
	public void init() {
		
		Grid grid = new Grid(20,30);
		
        //创建游戏窗体
        JFrame window = new JFrame("game");
        
        
        GameView gameView = new GameView(grid);
        GameController gameController = new GameController(grid,gameView);
        window.addKeyListener(gameController);
        Container contentPane = window.getContentPane();
        
        // 基于Grid初始化gamaView
        
        gameView.init();
        
        // 设置gameView中JPanel的大小
        gameView.getCanvas().setPreferredSize(new Dimension(500,500));   
        // 将gameView中JPanel加入到窗口中
        contentPane.add(gameView.getCanvas(), BorderLayout.CENTER);
        // 画出棋盘和贪吃蛇
        

        window.pack();
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
        new Thread(gameController).start();
    }

	
    public static void main(String[] args) {
        SnakeApp snakeApp = new SnakeApp();
        snakeApp.init();
    }
    
    
}
