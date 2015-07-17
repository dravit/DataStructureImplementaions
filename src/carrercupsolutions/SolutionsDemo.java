package carrercupsolutions;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by Dravit on 6/13/2015.
 */
public class SolutionsDemo {
    public static void main(String[] args) {
        Solutions solutions = new Solutions();
        String test = "Hello this is dravit";
        System.out.println("Is all unique characters in string=="+solutions.isUniqueCharacters(test));
        System.out.println("\n\nRemove Duplicates from this string == "+ Arrays.toString(solutions.removeDuplicates(test.toCharArray())));
        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");
        linkedList.add("a");
        linkedList.add("a");
        linkedList.add("b");
        solutions.removeDuplicatesFromListUsingBuffer(linkedList);
        System.out.println("\n\nList after removing duplicates == "+linkedList);
    }
}
