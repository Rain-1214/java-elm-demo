package Type;

public class Test {
	
	public static <T> void b(T a){
		System.out.println(a.getClass().getName());
		
	}
	
	public static void main(String[] args) {
		Demo<Dog> dog = new Demo<Dog>(new Dog());
		dog.print();
		
		Demo<Cat> cat = new Demo<Cat>(new Cat());
		cat.print();
		cat.getOb().print();
		
		Demo2<Cat> cat2 = new Demo2<Cat>(new Cat());
		cat2.print();
		
		
		Demo2<Integer> i = new Demo2<Integer>(1);
		i.print();
		
		b("");
	}
	
}
