package singleton;

/**
 * This class shows how we can break Singleton using Cloning
 * To see breaking result first change implementation of clone method to default in {@link FoolProofSingleton}
 */
public class BreakByCloning {

    public static void main(String[] args) throws CloneNotSupportedException {
        FoolProofSingleton foolProofSingleton1 = FoolProofSingleton.getInstance();
        FoolProofSingleton foolProofSingleton2 = (FoolProofSingleton) foolProofSingleton1.clone();

        System.out.println("foolProofSingleton1 == " + foolProofSingleton1.hashCode());
        System.out.println("foolProofSingleton2 == " + foolProofSingleton2.hashCode());
    }
}
