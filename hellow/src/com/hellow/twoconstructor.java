package com.hellow;

public class twoconstructor {
	private int title;
	private int content;
	public twoconstructor(int title){
		this.title = title;
		System.out.println("第一个");
	}
	
	public twoconstructor(int title,int content){
		this(title);
		this.content = content;
		System.out.println("第二个");
	}
}
