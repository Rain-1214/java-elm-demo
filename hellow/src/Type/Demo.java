package Type;

public class Demo <T extends Animal>{
	private T ob;

	public T getOb() {
		return ob;
	}

	public void setOb(T ob) {
		this.ob = ob;
	}

	public Demo(T ob) {
		super();
		this.ob = ob;
	}
	
	public void print(){
		System.out.println("���ͣ�" + this.ob.getClass().getName());
	}
	
}
