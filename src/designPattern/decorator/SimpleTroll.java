package designPattern.decorator;

import java.util.logging.Logger;

public class SimpleTroll implements Troll {

    private static final Logger LOGGER = Logger.getLogger(SimpleTroll.class.getName());

    @Override
    public void attack() {
        LOGGER.info("Troll tries to attack you!");
    }

    @Override
    public int getAttackPower() {
        return 10;
    }

    @Override
    public void fleeBattle() {
        LOGGER.info("Troll shrieks in horror and run away!");
    }
}
