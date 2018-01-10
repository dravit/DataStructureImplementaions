package designPattern.proxy;

import java.util.logging.Logger;

/**
 * This is the main object. Call to this object has to be routed through proxies.
 */
public class IvoryTower implements WizardTower {

	public static final Logger LOGGER = Logger.getLogger(IvoryTower.class.getName());
	
	public void enter(Wizard wizard) {
		LOGGER.info(wizard + " enters the tower.");
	}
}
