package designPattern.singleton;

import java.io.*;

/**
 * Created by Dravit on 6/9/2015.
 * This class shows how we can break Singleton using Serialization.
 * To see breaking of pattern correctly comment readResolve method.
 */
public class BreakBySerialization {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FoolProofSingleton foolProofSingleton = FoolProofSingleton.getInstance();
        ObjectOutput objectOutput = new ObjectOutputStream(new FileOutputStream("foolProofSingleton.ser"));
        objectOutput.writeObject(foolProofSingleton);
        objectOutput.close();
        ObjectInput objectInput = new ObjectInputStream(new FileInputStream("foolProofSingleton.ser"));
        FoolProofSingleton foolProofSingleton1 = (FoolProofSingleton)objectInput.readObject();
        objectInput.close();
        System.out.println("instance one hashcode"+ foolProofSingleton.toString());
        System.out.println("instance two hashcode"+ foolProofSingleton1.toString());
    }
}
