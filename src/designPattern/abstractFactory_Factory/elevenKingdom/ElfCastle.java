package designPattern.abstractFactory_Factory.elevenKingdom;

import designPattern.abstractFactory_Factory.interfaces.Castle;

/**
 * Created by guptdbh on 27/03/2018.
 */
public class ElfCastle implements Castle {

    private static final String DESCRIPTION = "This is Elven Castle !";
    @Override
    public String getDescription() {
        return DESCRIPTION;
    }
}
