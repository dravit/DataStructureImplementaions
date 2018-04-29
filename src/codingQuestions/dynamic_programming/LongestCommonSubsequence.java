package codingQuestions.dynamic_programming;

/**
 * Created by dravi on 4/28/2018.
 */
public class LongestCommonSubsequence {

    private int findLengthOfLCS(char[] x, char[] y, int lengthOfX, int lengthOfY) {
        if (lengthOfX == 0 || lengthOfY == 0) {
            return 0;
        } else if (x[lengthOfX - 1] == y[lengthOfY - 1]) {
            return 1 + findLengthOfLCS(x, y, lengthOfX - 1, lengthOfY - 1);
        } else {
            return max(findLengthOfLCS(x, y, lengthOfX, lengthOfY - 1), findLengthOfLCS(x, y, lengthOfX - 1, lengthOfY));
        }
    }

    private int max(int a, int b) {
        return (a > b) ? a : b;
    }

    public static void main(String[] args) {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";
        char[] x = s1.toCharArray();
        char[] y = s2.toCharArray();
        int lengthOfX = x.length;
        int lengthOfY = y.length;
        System.out.println(lcs.findLengthOfLCS(x, y, lengthOfX, lengthOfY));
    }
}
