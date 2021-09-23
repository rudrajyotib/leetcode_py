package leet.solutions;

/*
https://leetcode.com/problems/implement-trie-prefix-tree/
Leetcode#208
 */

public class Trie {

    static class TrieNode
    {
        private final TrieNode[] children;
        private boolean endOfWord;

        TrieNode()
        {
            this.children = new TrieNode[26];
        }

        public boolean hasChildren(char index)
        {
            return children[index-97] != null;
        }

        public TrieNode getChild(char index)
        {
            return children[index-97];
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
            if (this.children[input-97] != null)
            {
                return this.children[input-97];
            }
            TrieNode trieNode = new TrieNode();
            this.children[input-97] =  trieNode;
            return trieNode;
        }

    }


    private final TrieNode[] children;

    /** Initialize your data structure here. */
    public Trie() {
        this.children = new TrieNode[26];
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        char[] letters = word.toCharArray();
        TrieNode lastChild;
        if (this.children[letters[0]-97] != null) {
            lastChild = this.children[letters[0]-97];
        }else {
            lastChild = new TrieNode();
            this.children[letters[0]-97] =  lastChild;
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
        if (this.children[letters[0]-97] == null)
        {
            return false;
        }
        TrieNode lastNode = this.children[letters[0]-97];
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
        if (this.children[letters[0]-97] == null)
        {
            return false;
        }
        TrieNode lastNode = this.children[letters[0]-97];
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



