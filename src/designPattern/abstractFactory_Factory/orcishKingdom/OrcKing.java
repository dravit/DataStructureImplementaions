package designPattern.abstractFactory_Factory.orcishKingdom;

import designPattern.abstractFactory_Factory.interfaces.King;

/**
 * Created by guptdbh on 27/03/2018.
 */
public class OrcKing implements King {

    private static final String DESCRIPTION = "This is Orcish King !";
    @Override
    public String getDescription() {
        return DESCRIPTION;
    }
}
