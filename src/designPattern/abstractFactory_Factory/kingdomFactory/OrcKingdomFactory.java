package designPattern.abstractFactory_Factory.kingdomFactory;

import designPattern.abstractFactory_Factory.interfaces.Army;
import designPattern.abstractFactory_Factory.interfaces.Castle;
import designPattern.abstractFactory_Factory.interfaces.King;
import designPattern.abstractFactory_Factory.interfaces.KingdomFactory;
import designPattern.abstractFactory_Factory.orcishKingdom.OrcArmy;
import designPattern.abstractFactory_Factory.orcishKingdom.OrcCastle;
import designPattern.abstractFactory_Factory.orcishKingdom.OrcKing;

/**
 * Created by guptdbh on 27/03/2018.
 */
public class OrcKingdomFactory implements KingdomFactory {

    public Castle createCastle() {
        return new OrcCastle();
    }
    public King createKing() {
        return new OrcKing();
    }
    public Army createArmy() {
        return new OrcArmy();
    }
}
