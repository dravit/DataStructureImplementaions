package carrercupsolutions;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by Dravit on 6/13/2015.
 */
public class Solutions {
    /**
     * <b>Implement an algorithm to determine if a string has all unique characters</br>
     * What if you can not use additional data structures?</b></br>
     * <i><br></br>For simplicity, assume char set is ASCII (if not, we need to increase the storage size</br>
     * The rest of the logic would be the same)  NOTE: This is a great thing to point out to your interviewer!
     * The time and space complexity of this solution is O(n)</i>
     */
    public boolean isUniqueCharacters(String s) {
        boolean[] charSet = new boolean[256];
        for(int i=0; i < s.length(); i++) {
            int val = s.charAt(i);
            if(charSet[val]) {
                return false;
            }
            charSet[val] = true;
        }
        return true;
    }
    /**
     * <b>Design an algorithm and write code to remove the duplicate characters in a string without using any
     * additional buffer  NOTE: One or two additional variables are fine
     * An extra copy of the array is not </b>
     */
    public char[] removeDuplicates(char str[]) {
        if(str == null) return str;
        int len = str.length;
        if(len < 2) {
            return str;
        }
        boolean charset[] = new boolean[256];
        for(int i = 0; i < charset.length; i++) {
            charset[i] = false;
        }
        charset[str[0]] = true;
        int tail = 1;
        for(int i=1; i < str.length; i++) {
            if(!charset[str[i]]) {
                str[tail] = str[i];
                tail++;
                charset[str[i]] = true;
            }
        }
        for(int i = tail; i < str.length; i++) {
            str[i] = 0;
        }
        return str;
    }
    /**
     * <b>Assume you have a method isSubstring which checks if one word is a substring of another
     * Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only one
     * call to isSubstring (i e , “waterbottle” is a rotation of “erbottlewat”)</b>
     * <i>Just do the following checks
     * 1.  Check if length(s1) == length(s2)   If not, return false
     * 2.  Else, concatenate s1 with itself and see whether s2 is substring of the result
     * input: s1 = apple, s2 = pleap  ==> apple is a substring of pleappleap
     * input: s1 = apple, s2 = ppale ==> apple is not a substring of ppaleppale</i>
     */
    public boolean isSubstringInRotation(String inputString, String rotatedString) {
        if(inputString.length() != rotatedString.length()) {
            return false;
        } else if(inputString.length() > 0) {
            String concatenatedRotatedString = rotatedString + rotatedString;
            if(concatenatedRotatedString.indexOf(inputString) != -1) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
    /**
     * <b>Write code to remove duplicates from an unsorted linked list.</b>
     * <i>This implementation is by using buffer</i>
     */
    public void removeDuplicatesFromListUsingBuffer(LinkedList<String> inputList) {
        Hashtable<String, String> buffer = new Hashtable<String, String>();
        Iterator<String> listIterator = inputList.listIterator();
        while(listIterator.hasNext()) {
            String listElement = listIterator.next();
            if(buffer.containsKey(listElement)) {
                listIterator.remove();
                //inputList.remove(listElement);
            } else {
                buffer.put(listElement, "");
            }
        }
    }
}
