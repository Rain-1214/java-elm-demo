package Type;

public class Test {
	
	public static void main(String[] args) {
		Demo<Dog> dog = new Demo<Dog>(new Dog());
		dog.print();
		
		Demo<Cat> cat = new Demo<Cat>(new Cat());
		cat.print();
		cat.getOb().print();
		
		
	}
	
}
