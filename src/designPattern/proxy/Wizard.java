package designPattern.proxy;

/**
 * This is the object which want to use @{@link IvoryTower}
 */
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
