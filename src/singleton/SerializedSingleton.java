package singleton;

import java.io.Serializable;

/**
 * Created by Dravit on 6/9/2015.
 *
 * This is an implementation done by Bill Pugh's Principle
 *
 * In this we create a private inner class (SerializedSingletonHelper) which creates the object of main class.
 * And a public function which can access the private static variable of the inner class containing object.
 * This method of getting Singleton is also thread safe and there is no need to synchronization in this.
 *
 * To make singleton class serialization safe we need to implement readResolve() method in this class which returns our
 * getInstance method.
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
