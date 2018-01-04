package singleton;

import java.lang.reflect.Constructor;

/**
 * This class shows how we can break singleton pattern using reflection
 * To run this properly remove exception throwing code from Constructor of {@link FoolProofSingleton}
 */
public class BreakByReflection {
    public static void main(String[] args) {
        FoolProofSingleton foolProofSingleton1 = FoolProofSingleton.getInstance();
        FoolProofSingleton foolProofSingleton2 = null;

        try {
            Constructor<FoolProofSingleton> declaredConstructor = FoolProofSingleton.class.getDeclaredConstructor(new Class[]{});
            declaredConstructor.setAccessible(true);
            foolProofSingleton2 = declaredConstructor.newInstance(new Object[] {});
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("foolProofSingleton1 == " + foolProofSingleton1.hashCode());
        System.out.println("foolProofSingleton2 == " + foolProofSingleton2.hashCode());
    }
}
