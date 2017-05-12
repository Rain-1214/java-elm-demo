package Type;

public class Demo2 <T>{
	private T ob;

	public T getOb() {
		return ob;
	}

	public void setOb(T ob) {
		this.ob = ob;
	}

	public Demo2(T ob) {
		super();
		this.ob = ob;
	}
	
	public void print(){
		System.out.println("¿‡–Õ£∫" + this.ob.getClass().getName());
	}
	
}
