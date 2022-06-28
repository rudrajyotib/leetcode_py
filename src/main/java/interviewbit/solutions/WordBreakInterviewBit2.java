package interviewbit.solutions;

/*
https://www.interviewbit.com/problems/word-break-ii/
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class WordBreakInterviewBit2 {
    public ArrayList<String> solve(String s, ArrayList<String> wordDict) {
        return new Solution().wordBreak(s, wordDict);
    }

    class Solution {

        TrieNode dictionary = new TrieNode();


        public ArrayList<String> wordBreak(String s, ArrayList<String> wordDict) {

            for (String word : wordDict) {
                addToDictionary(word);
            }

            Set<String> resultSet = new HashSet<>();
            recursiveLetterSearch(s, new StringBuilder(), dictionary, resultSet, 0);
            if (resultSet.isEmpty()) {
                return new ArrayList<>();
            }

            ArrayList<String> result = new ArrayList<>();
            resultSet.stream().sorted().forEach(result::add);

            return result;
        }


        private void recursiveLetterSearch(String input, StringBuilder stringBuilder, TrieNode trieNode, Set<String> result, int index) {
            if (index >= input.length()) {
                if (trieNode.isWord()) {
                    result.add(stringBuilder.toString());
                }
            } else {
                TrieNode nextNode = trieNode.getCharacter(input.charAt(index));
                if (nextNode != null) {
                    stringBuilder.append(input.charAt(index));
                    recursiveLetterSearch(input, new StringBuilder(stringBuilder.toString()), nextNode, result, index + 1);
                    if (nextNode.isWord()) {
                        stringBuilder.append(" ");
                        recursiveLetterSearch(input, stringBuilder, dictionary, result, index + 1);
                    }
                }
            }
        }

        private void addToDictionary(String word) {
            dictionary.addWord(word);
        }


    }

    @SuppressWarnings("InnerClassMayBeStatic")
    class TrieNode {
        private final TrieNode[] children = new TrieNode[26];
        private boolean word = false;

        public TrieNode getCharacter(char queryChar) {
            if (this.children[queryChar - 'a'] != null) {
                return this.children[queryChar - 'a'];
            }
            return null;
        }

        @SuppressWarnings("unused")
        public boolean hasCharacter(char queryChar) {
            return this.children[queryChar - 'a'] != null;
        }

        public TrieNode addCharacter(char queryChar) {
            if (this.children[queryChar - 'a'] == null) {
                this.children[queryChar - 'a'] = new TrieNode();
            }
            return this.children[queryChar - 'a'];
        }

        public void markEndOfWord() {
            this.word = true;
        }

        public boolean isWord() {
            return this.word;
        }

        public void addWord(String word) {
            TrieNode head = addCharacter(word.charAt(0));
            for (int i = 1; i < word.length(); i++) {
                head = head.addCharacter(word.charAt(i));
            }
            head.markEndOfWord();
        }

    }


}
