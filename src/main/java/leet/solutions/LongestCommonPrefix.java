package leet.solutions;

/*
https://leetcode.com/problems/longest-common-prefix/
 */


import java.util.ArrayList;

public class LongestCommonPrefix {


    public String solve(ArrayList<String> input){
        return new Solution().longestCommonPrefix(input.toArray(new String[1]));
    }

    public class Solution{

        TrieNode dictionary = new TrieNode();

        public String longestCommonPrefix(String[] input){

            for (String word : input) {
                TrieNode node = dictionary;
                for (int i=0;i<word.length();i++){
                    node = node.addLetter(word.charAt(i));
                }
                node.markEndOfWord();
            }

            StringBuilder stringBuilder = new StringBuilder();
            boolean prefixFound = false;
            TrieNode node = dictionary;
            while (!prefixFound && node!=null){
                if (node.isWord()){
                    node = null;
                }else {
                    for (int i = 0; i < 26; i++) {
                        if (node.letters[i] != null && node.letters[i].footPrint != input.length) {
                            prefixFound = true;
                            break;
                        } else if (node.letters[i] != null && node.letters[i].footPrint == input.length) {
                            stringBuilder.append((char) ('a'+i));
                            node = node.letters[i];
                            break;
                        }
                    }
                }
            }


            return stringBuilder.toString();
        }

    }

    @SuppressWarnings("InnerClassMayBeStatic")
    class TrieNode{
        TrieNode[] letters = new TrieNode[26];
        boolean word = false;
        int footPrint = 0;

        boolean isWord(){
            return word;
        }

        void markEndOfWord(){
            this.word = true;
        }

        TrieNode addLetter(char nextChar){
            TrieNode nextNode;
            if (letters[nextChar-'a'] == null){
                nextNode = new TrieNode();
                letters[nextChar-'a'] = nextNode;
            }else{
                nextNode = letters[nextChar - 'a'];
            }
            ++nextNode.footPrint;
            return nextNode;
        }


    }

}
