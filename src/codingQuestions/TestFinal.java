package codingQuestions;

class PersonalLoan {
    public final String getName() {
        return "personal loan";
    }
}

class CheapPersonalLoan extends PersonalLoan {
    /*@Override
    public final String getName(){
        return "cheap personal loan"; //compilation error: overridden method is final
    }*/
}

public class TestFinal {
    public static void main(String[] args) {
        PersonalLoan personalLoan = new CheapPersonalLoan();
        System.out.println(personalLoan.getName());

        CheapPersonalLoan cheapPersonalLoan = new CheapPersonalLoan();
        //This can be called using child object as Final Methods cannot be overridden
        // but they are visible from child class
        System.out.println(cheapPersonalLoan.getName());
    }
}