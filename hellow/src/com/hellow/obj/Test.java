package com.hellow.obj;

public class Test {
	
	public static void doSomething(Animal animal){
//		animal.say();
		if(animal instanceof Dog){
			((Dog) animal).f1();
		}else if(animal instanceof Cat){
			((Cat) animal).f2();
		}
	}
	
	public static void main(String[] args) {
		
		Dog dog = new Dog();
		Cat cat = new Cat();
		Animal animal = new Animal();
		
//		dog.say();
		doSomething(animal);
//		doSomething(dog);
//		doSomething(cat);
		
	}
}
