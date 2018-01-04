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
public class FoolProofSingleton implements Serializable, Cloneable {
    public static final long serialVersionUID =  -7604766932017737115L;

    private FoolProofSingleton() {
        /**
         * This piece of code will save creation of object using reflection
         */
        if(FoolProofSingleton.getInstance() != null) {
            throw new InstantiationError("Creating of this Singleton Class object is not allowed");
        }
    }

    private static class SerializedSingletonHelper {
        private static final FoolProofSingleton _instance = new FoolProofSingleton();
    }

    public static FoolProofSingleton getInstance() {
        return SerializedSingletonHelper._instance;
    }

    /**
     * To prevent new creation while deserialization process implement readResolve method in it.
     * @return
     */
    protected Object readResolve() {
        return getInstance();
    }

    /**
     * To prevent breaking of singleton pattern throw clone not supported exception.
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        //return super.clone();     //This is basically what default implementation of clone method
        throw new CloneNotSupportedException("Creation of new Object using cloning is not supported");
    }
}
