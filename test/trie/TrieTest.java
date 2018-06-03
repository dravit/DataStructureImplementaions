package trie;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TrieTest {
    Trie trie;

    @Before
    public void setUp() {
        trie = new Trie();
    }

    @Test
    public void insertTest() {
        trie.insert("dravit");
        trie.insert("avit");
        System.out.println(trie);
        Assert.assertTrue(trie.find("avit"));
    }
}