package com.firstWork;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.EventListener;

public class GameController implements KeyListener,Runnable{
	
	private Grid grid;
	private GameView gameView;
	
	private boolean running;
	
	GameController(Grid grid,GameView gameView){
		this.grid = grid;
		this.gameView = gameView;
		this.running = true;
	}
	
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
	
		
		if(e.getKeyCode() == e.VK_UP){
			grid.changeDirection(Direction.UP);
		}else if(e.getKeyCode() == e.VK_LEFT){
			grid.changeDirection(Direction.LEFT);
		}else if(e.getKeyCode() == e.VK_RIGHT){
			grid.changeDirection(Direction.RIGHT);
		}else if(e.getKeyCode() == e.VK_DOWN){
			grid.changeDirection(Direction.DOWN);
		}
		
		
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (running) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                break;
            }
            // ������Ϸ��һ��
            // ������������˳���Ϸ
            // ���������������µ���Ϸҳ��
            running = this.grid.nextRound();
            gameView.getCanvas().repaint();
            
        }
		gameView.showGameOverMessage();
        running = false;
	}
	
}
