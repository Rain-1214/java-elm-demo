package com.hellow;
//import java.util.*;

import hellow.Post;
import java.time.*;
import java.time.temporal.ChronoUnit;


public class hellow {
	public static void main(String[] args){
		//System.out.println("Hellow world");
		Post post = new Post();
		post.title = "标题";
		post.content = "内容";
//		post.print();
		int[] myArray = {100,200,300,400,500};
//		System.out.println(myArray[2]);
		byte a = 100;
//		System.out.println(a);
//		System.out.println("int类型的最大值：Integer.MAX_VALUE=" + Integer.MAX_VALUE); 
		
		String s = "a=";
		short aa = 100;
//		System.out.println(aa);
		
//		Scanner scan = new Scanner(System.in);
//        int number = scan.nextInt();
//        System.out.println(number);
//        scan.close();
        
//        int b = 0;
//        int sum = 0;
//        while (b <= 10){
//        	sum += b;
//        	b++;
////        	System.out.println(sum);
//        }
        
//        String[] myString = {"a","b","c"};
//        
//        for(int i = 0;i < myString.length;i++){
////        	System.out.println(myString[i]);
//        };
//        
//        String[] sentences = {"hello", "thank u", "thank u very much"};
//        for (String sentence : sentences) {
//            System.out.println(sentence);
//        }
//        
//        for (String myStrings : myString){
//        	System.out.println(myStrings);
//        }
//        
//        int[] myArray2 = {1,2,3,4,5};
//        for (int v : myArray2){
//        	System.out.println(v);
//        }
        
		int sum = 0;
		for(int i = 0; i <= 100; i++){
			if(i % 2 == 0){
				sum += i;
			}
		}
		
//		System.out.println(sum);
		
		int sum1 = 0;
		
		for(int x = 0;x <= 100;x++){
			int result = x % 2;
			switch(result){
			case 0:
				sum1 += x;
				break;
			case 1:
				continue;
			}
		}
		
//		System.out.println(sum1);
		
		add addmethod = new add();
		
//		addmethod.addn(2,2);
		
//		twoconstructor obj = new twoconstructor(1);
//		twoconstructor obj2 = new twoconstructor(1,2);
		
		Car aodi = new Car(233,80);
		
//		aodi.run(200);
		
		Engine big = new Engine(33.33);
		
		Car ben = new Car();
		
//		System.out.println(ben.color);
		
		String str1 = new String("abc");
		String str2 = new String("abc");

//		System.out.println(str1 == str2);
//		System.out.println(str1.equals(str2));
//		System.out.println(str1 == str1);
		
		String s1 = "aaa";
		String s2 = "aaa";
//		System.out.println(s1 == s2);
//		System.out.println(s1.equals(s2));
		
//		System.out.println(s1.lastIndexOf("a"));
		
		String s3 = s1.substring(0,1);
//		System.out.println(s3.length());
		
		StringBuffer s4 = new StringBuffer();
		s4.append("aaaa");
		s4.append("bbb");
		int[] s4arr = {1,2,3};
		s4.insert(2,"ccc");
		s4.insert(6, s4arr[0]);
//		System.out.println(s4);
		s4.delete(0, 2);
//		s4.reverse();
//		System.out.println(s4);
		
		Clock clock = Clock.systemDefaultZone();
		long millis = clock.millis();
//		System.out.println(millis);
		
		ZoneId zone1 = ZoneId.of("Europe/Berlin");
		ZoneId zone2 = ZoneId.of("Brazil/East");
		LocalTime now1 = LocalTime.now(zone1);
		LocalTime now2 = LocalTime.now(zone2);
//		System.out.println(now1.getHour());
//		System.out.println(now2.getHour());
//		System.out.println(now1.isBefore(now2));  // false
		long hoursBetween = ChronoUnit.HOURS.between(now1, now2);
		long minutesBetween = ChronoUnit.MINUTES.between(now1, now2);
//		System.out.println(hoursBetween);
//		System.out.println(minutesBetween);
		
		
		
		
	}
}
