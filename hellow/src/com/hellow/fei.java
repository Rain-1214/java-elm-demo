package com.hellow;

public class fei {
	
	public int add(int n){
		
		if (n <= 1){
			return 1;
		}
		
		return add(n-1) + add(n-2);
		
	}
	
	public static void main(String[] args) {
		
		fei a = new fei();
		
		int b = a.add(5);
		System.out.println(b);
	}
	
}
//1 1 2 3 5 8 13