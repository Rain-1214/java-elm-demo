package com.thread;

public class Thread1 extends Thread{
	
	private int baoZi;
	private String ThreadName;
	public Thread1(int baoZi, String threadName) {
		super();
		this.baoZi = baoZi;
		ThreadName = threadName;
	}
	@Override
	public void run() {
		while(baoZi < 10){
			try {
				Thread.sleep(100);
				System.out.println(this.ThreadName + "吃第" + this.baoZi);
				this.baoZi++;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		Thread1 a = new Thread1(0,"张三");
		Thread1 b = new Thread1(0,"李四");
		
		a.start();
		b.start();
	}
	
	
}
