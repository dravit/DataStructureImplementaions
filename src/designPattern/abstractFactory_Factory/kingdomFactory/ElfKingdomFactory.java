package designPattern.abstractFactory_Factory.kingdomFactory;

import designPattern.abstractFactory_Factory.elevenKingdom.ElfArmy;
import designPattern.abstractFactory_Factory.elevenKingdom.ElfCastle;
import designPattern.abstractFactory_Factory.elevenKingdom.ElfKing;
import designPattern.abstractFactory_Factory.interfaces.Army;
import designPattern.abstractFactory_Factory.interfaces.Castle;
import designPattern.abstractFactory_Factory.interfaces.King;
import designPattern.abstractFactory_Factory.interfaces.KingdomFactory;

/**
 * Created by guptdbh on 27/03/2018.
 */
public class ElfKingdomFactory implements KingdomFactory {
    public Castle createCastle() {
        return new ElfCastle();
    }

    public King createKing() {
        return new ElfKing();
    }

    public Army createArmy() {
        return new ElfArmy();
    }
}
