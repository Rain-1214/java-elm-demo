package com.firstWork;

import java.util.Arrays;
import java.util.Random;

public class Grid {
	
	private final int width;
	private final int height;
	public final boolean status[][];
	
	private Snake snake;
	private Node food;
	private boolean gameState = true;

	private Direction snakeDirection = Direction.RIGHT;
	
	
	
	public Snake getSnake() {
		return snake;
	}
	
	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public Node getFood() {
		return food;
	}

	public Grid(int height, int width) {

	   this.width = width;
	   this.height = height;

	   status = new boolean[height][width];

	   this.snake = initSnake();
	   this.food = createFood();
	   
	}
	
	public void changeDirection(Direction direction){
		if((direction.getDirectionCode() != this.snakeDirection.getDirectionCode()) && (Math.abs(direction.getDirectionCode() - this.snakeDirection.getDirectionCode()) != 2)){
			this.snakeDirection = direction;
			
		}
		
	}
	
	private Snake initSnake(){
		
		Snake snake = new Snake();
		
		int initY = this.height/2;
		int initX = this.width/2;
		
		for(int i = 0; i < initX ; i++){
			
			this.status[initY][i] = true;
			Node node = new Node(i,initY);
			snake.getBody().addFirst(node);
			
		}
		
		return snake;
		
	}
	
	public boolean isSet(int y,int x){
		return this.status[y][x];
	}
	
	public Node createFood() {
		Random r = new Random();
	    int x, y;
	    x = r.nextInt(this.width - 1);
	    y = r.nextInt(this.height - 1);
	    
	    if (isSet(y,x)){
	    	createFood();
	    }else{
		    this.food = new Node(x, y);
	    }
	    this.status[food.getY()][food.getX()] = true;
		return this.food;
	}
	
	public boolean nextRound() {
		
		Node oldTail = this.snake.move(this.snakeDirection);
		
		int newHeadX = this.snake.getHead().getX();
		int newHeadY = this.snake.getHead().getY();
		
		if((newHeadX >=0 && newHeadX <= this.width) && (newHeadY >=0 && newHeadY <= this.height)){
			
			this.status[oldTail.getY()][oldTail.getX()] = false;
			//System.out.println(oldTail.getX() + "," + oldTail.getY());
			if(newHeadX == this.food.getX() && newHeadY == this.food.getY()){
				this.snake.eat(this.food, this.snakeDirection);
				this.snake.getBody().addLast(oldTail);
				
				for(Node node:this.snake.getBody()){
					System.out.println(node.getX() + "," + node.getY());
					this.status[node.getY()][node.getX()] = true;
				}
				
				createFood();
				//System.out.println(food.getX() + "," + food.getY());
				this.status[this.food.getY()][this.food.getX()] = true;
				
			}else{
				//System.out.println(food.getX() + "," + food.getY());
				for(Node node:this.snake.getBody()){
					//System.out.println(node.getX() + "," + node.getY());
					this.status[node.getY()][node.getX()] = true;
				}	
				
			}
			
			return true;
		}else{
			return false;
		}
	}	
}
