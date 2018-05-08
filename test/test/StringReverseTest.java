package test;

import codingQuestions.StringReverse;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringReverseTest {

    private StringReverse stringReverse;
    String str = "Sony is going to introduce Internet TV soon";

    @Before
    public void setUp() throws Exception {
        stringReverse = new StringReverse();
    }

    @Test
    public void reverse() {
        assertEquals("noos VT tenretnI ecudortni ot gniog si ynoS", stringReverse.reverse(str));
    }

    @Test
    public void reverseRecursively() {
        assertEquals("noos VT tenretnI ecudortni ot gniog si ynoS", stringReverse.reverseRecursively(str));
    }

    @Test
    public void reverseVowels() {
        assertEquals("Sony os geeng tI entrudoci ontirnot TV sion", stringReverse.reverseVowels(str));
    }

    @Test
    public void reverseWordsInString() {
        assertEquals("soon TV Internet introduce to going is Sony", stringReverse.reverseWordsInString(str));
    }
}