package codingQuestions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;


public class StringReverse {

    private static List<String> vowelList = Arrays.asList("a","A","e","E","i","I","o","O","u","U");

    public String reverse(String str) {
        StringBuilder strBuilder = new StringBuilder();
        char[] strChars = str.toCharArray();

        for (int i = strChars.length - 1; i >= 0; i--) {
            strBuilder.append(strChars[i]);
        }

        return strBuilder.toString();
    }

    public String reverseRecursively(String str) {

        //base case to handle one char string and empty string
        if (str.length() < 2) {
            return str;
        }

        return reverseRecursively(str.substring(1)) + str.charAt(0);

    }

    /**
     * This function reverse vowels present in a string.<br />
     * <b>Idea : </b> <li>Iterate over the array using while, pick one pointer from start and another from end</li>
     * <li>if start pointer is not a vowel increment it and continue</li>
     * <li>if end pointer is not a vowel decrement it and continue</li>
     * <li>swap both the pointer values, as they will be vowels at this point</li>
     * <li>increment start and decrement end pointer values</li>
     * @param input Input string for which vowels has to be reversed
     * @return String with reversed vowels
     */
    public String reverseVowels(String input) {
        String [] str = input.split("");
        int i = 0;
        int j = str.length - 1;
        while (i < j) {
            if(!vowelList.contains(str[i])) {
                i++;
                continue;
            }
            if(!vowelList.contains(str[j])) {
                j--;
                continue;
            }
            Solutions.swap(str, i, j);
            i++;
            j--;
        }
        StringBuilder returnString = new StringBuilder();
        for(String s : str) {
            returnString.append(s);
        }
        return returnString.toString();
    }

    /**
     * This function reverse words present in a string.<br />
     * <b>Idea : </b>
     * <li>Iterate over the array using while, pick one pointer from start and another from end</li>
     * <li>swap both the pointer values</li>
     * <li>increment start and decrement end pointer values</li>
     * @param input Input string for which words has to be reversed
     * @return String with reversed words
     */
    public String reverseWordsInString(String input) {
        String [] str = input.split(" ");
        int i = 0;
        int j = str.length - 1;

        while(i < j) {
            Solutions.swap(str, i, j);

            i++;
            j--;
        }

        StringBuilder returnString = new StringBuilder();
        for(String s : str) {
            returnString.append(s + " ");
        }
        return returnString.toString().trim();
    }
}