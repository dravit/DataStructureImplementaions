package designPattern.proxy;

import java.util.logging.Logger;

public class IvoryTower implements WizardTower {

	public static final Logger LOGGER = Logger.getLogger(IvoryTower.class.getName());
	
	public void enter(Wizard wizard) {
		LOGGER.info(wizard + " enters the tower.");
	}
}
