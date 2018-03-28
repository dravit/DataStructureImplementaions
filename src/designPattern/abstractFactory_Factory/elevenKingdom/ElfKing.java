package designPattern.abstractFactory_Factory.elevenKingdom;

import designPattern.abstractFactory_Factory.interfaces.King;

/**
 * Created by guptdbh on 27/03/2018.
 */
public class ElfKing implements King {

    private static final String DESCRIPTION = "This is Elven King !";
    @Override
    public String getDescription() {
        return DESCRIPTION;
    }
}
