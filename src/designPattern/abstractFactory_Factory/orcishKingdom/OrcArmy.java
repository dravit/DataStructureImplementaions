package designPattern.abstractFactory_Factory.orcishKingdom;

import designPattern.abstractFactory_Factory.interfaces.Army;

/**
 * Created by guptdbh on 27/03/2018.
 */
public class OrcArmy implements Army {

    private static final String DESCRIPTION = "This is Orcish Army !";
    @Override
    public String getDescription() {
        return DESCRIPTION;
    }
}
