package trie;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
        private boolean endOfWord;
        private Map<Character, TrieNode> children;

        public TrieNode() {
            this.children = new HashMap<>();
            this.endOfWord = false;
        }

        public boolean isEndOfWord() {
            return endOfWord;
        }

        public void setEndOfWord(boolean endOfWord) {
            this.endOfWord = endOfWord;
        }

        public Map<Character, TrieNode> getChildren() {
            return children;
        }

        public void setChildren(Map<Character, TrieNode> children) {
            this.children = children;
        }

        @Override
        public String toString() {
            return "TrieNode{" +
                    "endOfWord=" + endOfWord +
                    ", children=" + children +
                    '}';
        }
    }