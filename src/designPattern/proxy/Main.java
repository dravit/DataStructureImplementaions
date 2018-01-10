package designPattern.proxy;

/**
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		Implementing proxy pattern
		 */
		WizardTowerProxy wizardTowerProxy = new WizardTowerProxy(new IvoryTower());
		wizardTowerProxy.enter(new Wizard("Red Wizard"));
		wizardTowerProxy.enter(new Wizard("Black Wizard"));
		wizardTowerProxy.enter(new Wizard("White Wizard"));
		wizardTowerProxy.enter(new Wizard("Green Wizard"));
		wizardTowerProxy.enter(new Wizard("Blue Wizard"));
		wizardTowerProxy.enter(new Wizard("Grey Wizard"));
	}

}
