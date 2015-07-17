package singleton;

import java.io.*;

/**
 * Created by Dravit on 6/9/2015.
 */
public class SerializedSingletonTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        SerializedSingleton serializedSingleton = SerializedSingleton.getInstance();
        ObjectOutput objectOutput = new ObjectOutputStream(new FileOutputStream("serializedSingleton.ser"));
        objectOutput.writeObject(serializedSingleton);
        objectOutput.close();
        ObjectInput objectInput = new ObjectInputStream(new FileInputStream("serializedSingleton.ser"));
        SerializedSingleton serializedSingleton1 = (SerializedSingleton)objectInput.readObject();
        objectInput.close();
        System.out.println("instance one hashcode"+serializedSingleton.toString());
        System.out.println("instance two hashcode"+serializedSingleton1.toString());
    }
}
