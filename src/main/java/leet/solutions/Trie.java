package leet.solutions;

/*
https://leetcode.com/problems/implement-trie-prefix-tree/
Leetcode#208
 */

import java.util.HashMap;
import java.util.Map;

public class Trie {

    static class TrieNode
    {
        private final Map<Character, TrieNode> children;
        private boolean endOfWord;

        TrieNode()
        {
            this.children = new HashMap<>(27, 1);
        }

        public boolean hasChildren(char index)
        {
            return children.containsKey(index);
        }

        public TrieNode getChild(char index)
        {
            return children.get(index);
        }

        public void markEndOfWord()
        {
            this.endOfWord = true;
        }

        public boolean isEndOfWord()
        {
            return this.endOfWord;
        }

        public TrieNode createNode(char input)
        {
            if (this.children.containsKey(input))
            {
                return this.children.get(input);
            }
            TrieNode trieNode = new TrieNode();
            this.children.put(input, trieNode);
            return trieNode;
        }

    }


    private final Map<Character, TrieNode> children = new HashMap<>(27, 1);

    /** Initialize your data structure here. */
    public Trie() {

    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        char[] letters = word.toCharArray();
        TrieNode lastChild;
        if (this.children.containsKey(letters[0])) {
            lastChild = children.get(letters[0]);
        }else {
            lastChild = new TrieNode();
            this.children.put(letters[0], lastChild);
        }

        for (int i=1;i<word.length();i++) {

            if (lastChild.hasChildren(letters[i]))
            {
                lastChild = lastChild.getChild(letters[i]);
            }else
            {
                lastChild = lastChild.createNode(letters[i]);
            }
        }
        lastChild.markEndOfWord();
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        char[] letters = word.toCharArray();
        if (!this.children.containsKey(letters[0]))
        {
            return false;
        }
        TrieNode lastNode = this.children.get(letters[0]);
        for (int i=1;i<letters.length;i++)
        {
            if (!lastNode.hasChildren(letters[i]))
            {
                return false;
            }
            lastNode = lastNode.getChild(letters[i]);
        }
        return lastNode.isEndOfWord();
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        char[] letters = prefix.toCharArray();
        if (!this.children.containsKey(letters[0]))
        {
            return false;
        }
        TrieNode lastNode = this.children.get(letters[0]);
        for (int i=1;i<letters.length;i++)
        {
            if (!lastNode.hasChildren(letters[i]))
            {
                return false;
            }
            lastNode = lastNode.getChild(letters[i]);
        }
        return true;
    }
}



