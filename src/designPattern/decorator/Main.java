package designPattern.decorator;

import java.util.logging.Logger;

public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {

        Troll simpleTroll = new SimpleTroll();
        simpleTroll.attack();
        simpleTroll.fleeBattle();
        LOGGER.info("Simple troll Power is : "+ simpleTroll.getAttackPower());

        LOGGER.info("Adding additional power to the simple Troll.");
        Troll decoratedTroll = new ClubbedTroll(simpleTroll);
        decoratedTroll.attack();
        decoratedTroll.fleeBattle();
        LOGGER.info("Clubbed troll Power is : "+ decoratedTroll.getAttackPower());
    }
}
