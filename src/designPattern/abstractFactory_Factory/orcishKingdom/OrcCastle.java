package designPattern.abstractFactory_Factory.orcishKingdom;

import designPattern.abstractFactory_Factory.interfaces.Castle;

/**
 * Created by guptdbh on 27/03/2018.
 */
public class OrcCastle implements Castle {

    private static final String DESCRIPTION = "This is Orcish Castle !";
    @Override
    public String getDescription() {
        return DESCRIPTION;
    }
}
