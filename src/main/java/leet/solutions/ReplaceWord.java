/*
https://leetcode.com/problems/replace-words/description/
 */


package leet.solutions;

import java.util.LinkedList;
import java.util.List;

public class ReplaceWord {

    public String solve(List<String> dict, String sentence) {
        return new Solution().replaceWords(dict, sentence);
    }


    static class Solution {
        public String replaceWords(List<String> dictionary, String sentence) {

            String[] words = sentence.split(" ");
            List<String> replacedWords = new LinkedList<>();
            Trie trie = new Trie();
            for (String dictWord : dictionary) {
                char[] chars = dictWord.toCharArray();
                Trie tempTrie = trie;
                for (char aChar : chars) {
                    tempTrie = tempTrie.addChar(aChar);
                }
                tempTrie.markEndOfWord();
            }
            for (String word : words) {
                char[] chars = word.toCharArray();
                Trie tempTrie = trie;
                boolean matchFound = false;
                for (int i = 0; i < chars.length; i++) {
                    tempTrie = tempTrie.getNode(chars[i]);
                    if (tempTrie == null) {
                        break;
                    }
                    if (tempTrie.isEndOfWord()) {
                        matchFound = true;
                        replacedWords.add(word.substring(0, i + 1));
                        break;
                    }
                }
                if (!matchFound) {
                    replacedWords.add(word);
                }
            }
            return String.join(" ", replacedWords);
        }


        static class Trie {
            private final Trie[] chars = new Trie[26];
            private boolean endOfWord = false;

            void markEndOfWord() {
                this.endOfWord = true;
            }

            Trie getNode(char c) {
                if (isLetterPresent(c)) {
                    return chars[c - 'a'];
                }
                return null;
            }

            boolean isLetterPresent(char c) {
                return chars[c - 'a'] != null;
            }

            public boolean isEndOfWord() {
                return endOfWord;
            }

            Trie addChar(char c) {
                if (chars[c - 'a'] == null) {
                    chars[c - 'a'] = new Trie();
                }
                return chars[c - 'a'];
            }
        }
    }

}
