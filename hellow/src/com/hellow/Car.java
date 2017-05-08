package com.hellow;

public class Car {
	public int color;
	public int speed;
	public Engine engine;
	
	{
		color = 12345;
		speed = 200;
		
	}
	
	
	public Car(){};
	
	public Car(int color,int speed){
//		this.color = color;
		this.speed = speed;
	}
	
	public Car(int color,int speed,Engine engine){
		this.color = color;
		this.speed = speed;
		this.engine = engine;
	}
	
	public void startup(){
		System.out.println("启动");
	}
	
	public void run(int speed){
		this.speed = speed;
		System.out.println("跑了，速度为：" + speed);
	}
	
}
