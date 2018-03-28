package designPattern.abstractFactory_Factory.abstractFactory;

import designPattern.abstractFactory_Factory.interfaces.KingdomFactory;
import designPattern.abstractFactory_Factory.kingdomFactory.ElfKingdomFactory;
import designPattern.abstractFactory_Factory.kingdomFactory.OrcKingdomFactory;

/**
 * Created by guptdbh on 27/03/2018.
 */
public class FactoryMaker {
    public enum KingdomType {
        ELF, ORC
    }

    public static KingdomFactory makeFactory(KingdomType type) {
        switch (type) {
            case ELF:
                return new ElfKingdomFactory();
            case ORC:
                return new OrcKingdomFactory();
            default:
                throw new IllegalArgumentException("KingdomType not supported.");
        }
    }
}
