package singleton;

import java.io.Serializable;

/**
 * Created by Dravit on 6/9/2015.
 */
public class SerializedSingleton implements Serializable {
    public static final long serialVersionUID =  -7604766932017737115L;
    private SerializedSingleton() {

    }
    private static class SerializedSingletonHelper {
        private static final SerializedSingleton _instance = new SerializedSingleton();
    }
    public static SerializedSingleton getInstance() {
        return SerializedSingletonHelper._instance;
    }
    protected Object readResolve() {
        return getInstance();
    }
}
