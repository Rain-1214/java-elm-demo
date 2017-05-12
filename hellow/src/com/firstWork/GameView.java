package com.firstWork;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GameView {
	private final Grid grid;

    public GameView(Grid grid) {
        this.grid = grid;
    }

    public void draw(Graphics graphics) {
        drawGridBackground(graphics);
        drawSnake(graphics, grid.getSnake());
        drawFood(graphics, grid.getFood());
    }
    private JPanel canvas;

    public void init() {
        canvas = new JPanel() {
            @Override
            public void paintComponent(Graphics graphics) {
                drawGridBackground(graphics);
                drawSnake(graphics, grid.getSnake());
                drawFood(graphics, grid.getFood());
            }
        };
    }

    public void draw() {
        canvas.repaint();
    }
    
    public JPanel getCanvas() {
        return canvas;
    }

    public void drawSnake(Graphics graphics, Snake snake) {
    	for(Node node:snake.getBody()){
    		drawSquare(graphics,node,new Color(0,0,0));
    	}
    	
    }

    public void drawFood(Graphics graphics, Node squareArea) {
    	drawCircle(graphics,this.grid.getFood(),new Color(200,100,33));
    }

    public void drawGridBackground(Graphics graphics) {
    	graphics.setColor(new Color(200,200,200));
    	graphics.fillRect(0,0,500,500);
    }
    
    private void drawSquare(Graphics graphics, Node squareArea, Color color) {
        graphics.setColor(color);
        int size = 10;
        graphics.fillRect(squareArea.getX() * size, squareArea.getY() * size, size - 1, size - 1);
    }


    private void drawCircle(Graphics graphics, Node squareArea, Color color) {
        graphics.setColor(color);
        int size = 10;
        graphics.fillOval(squareArea.getX() * size, squareArea.getY() * size, size, size);
    }
    
    public void showGameOverMessage() {
        JOptionPane.showMessageDialog(null, "游戏结束", "游戏结束", JOptionPane.INFORMATION_MESSAGE);
    }
}
