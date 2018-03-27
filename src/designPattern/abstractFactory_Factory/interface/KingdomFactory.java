package designPattern.abstractFactory_Factory.interfaces;

/**
 * Created by guptdbh on 27/03/2018.
 */
public interface KingdomFactory {
    Castle createCastle();
    King createKing();
    Army createArmy();
}
