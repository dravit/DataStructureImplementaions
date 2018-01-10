package designPattern.proxy;

import java.util.logging.Logger;

/**
 * This class is a proxy for all the calls that goes to @{@link IvoryTower}
 * This implements the common interface @{@link WizardTower} so that function of main and
 * proxy object should remain same.
 */
public class WizardTowerProxy implements WizardTower {
	
	public static final Logger LOGGER = Logger.getLogger(WizardTowerProxy.class.getName());
	
	public static final int NUM_WIZARDS_ALLOWED = 3;
	
	private int numOfWizardsEntered;
	
	private final WizardTower wizardTower;
	
	public WizardTowerProxy(WizardTower wizardTower) {
		this.wizardTower = wizardTower;
	}

	@Override
	public void enter(Wizard wizard) {
		if(numOfWizardsEntered < NUM_WIZARDS_ALLOWED) {
			wizardTower.enter(wizard);
			numOfWizardsEntered++;
		} else {
			LOGGER.info(wizard + " is not allowed to enter as maximum allowed wizard is reached.");
		}
	}
}
