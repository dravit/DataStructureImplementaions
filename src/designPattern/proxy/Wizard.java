package designPattern.proxy;

public class Wizard {

	public final String name;
	
	public Wizard(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
