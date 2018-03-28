package designPattern.abstractFactory_Factory.elevenKingdom;

import designPattern.abstractFactory_Factory.interfaces.Army;

/**
 * Created by guptdbh on 27/03/2018.
 */
public class ElfArmy implements Army {

    private static final String DESCRIPTION = "This is Elven Army !";
    @Override
    public String getDescription() {
        return DESCRIPTION;
    }
}
