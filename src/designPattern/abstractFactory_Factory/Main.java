package designPattern.abstractFactory_Factory;

import designPattern.abstractFactory_Factory.abstractFactory.FactoryMaker;

/**
 * Created by guptdbh on 27/03/2018.
 */
public class Main {

    public static void main(String[] args) {

        System.out.println(FactoryMaker.makeFactory(FactoryMaker.KingdomType.ELF).createKing().getDescription());
        System.out.println(FactoryMaker.makeFactory(FactoryMaker.KingdomType.ORC).createKing().getDescription());
    }


}
