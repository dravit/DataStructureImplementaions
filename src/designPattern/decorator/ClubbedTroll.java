package designPattern.decorator;

import java.util.logging.Logger;

/**
 * This class serves as a decorator for Troll objects.
 * Suppose a Troll object needs additional capabilities like attach power or a weapon,
 * that can be added to that object from this class.
 */
public class ClubbedTroll implements Troll {

    private static final Logger LOGGER = Logger.getLogger(ClubbedTroll.class.getName());

    private Troll decorated;

    public ClubbedTroll(Troll decorated) {
        this.decorated = decorated;
    }

    /**
     * This is the way how we are adding additional responsibility to troll object
     */
    @Override
    public void attack() {
        decorated.attack();
        LOGGER.info("Troll swings at you with a club!");
    }

    @Override
    public int getAttackPower() {
        return decorated.getAttackPower() + 10;
    }

    @Override
    public void fleeBattle() {
        decorated.fleeBattle();
    }
}
