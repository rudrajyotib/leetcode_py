package leet.solutions;

import java.util.*;

public class WordLadder {


    public int solve(String beginWord, String endWord, List<String> wordList) {
        return new Solution().ladderLength(beginWord, endWord, wordList);
    }

    @SuppressWarnings("InnerClassMayBeStatic")
    class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {

            Set<String> dictionary = new HashSet<>(wordList);
            Map<String, List<String>> adjacencyMatrix = new HashMap<>();
            for (String s : wordList) {
                adjacencyMatrix.put(s, new LinkedList<>());
                char[] word = s.toCharArray();
                for (int j = 0; j < word.length; j++) {
                    char currentChar = word[j];
                    for (int k = 0; k < 26; k++) {
                        if (('a' + k) != currentChar) {
                            word[j] = (char) ('a' + k);
                            String mutatedString = new String(word);
                            if (dictionary.contains(mutatedString)) {
                                adjacencyMatrix.get(s).add(mutatedString);
                            }
                        }
                    }
                    word[j] = currentChar;
                }
            }

            if (!adjacencyMatrix.containsKey(beginWord)) {
                char[] word = beginWord.toCharArray();
                List<String> adjacentWords = new LinkedList<>();
                for (int j = 0; j < word.length; j++) {
                    char currentChar = word[j];
                    for (int k=0;k<26;k++){
                        if (('a'+k)!= currentChar){
                            word[j] = (char) ('a'+k);
                            String mutatedString = new String(word);
                            if (dictionary.contains(mutatedString)){
                                adjacentWords.add(mutatedString);
                            }
                        }
                    }
                    word[j] = currentChar;
                }
                adjacencyMatrix.put(beginWord, adjacentWords);
            }

            if (adjacencyMatrix.get(beginWord).size() == 0) {
                return 0;
            }
            if (!adjacencyMatrix.containsKey(endWord)) {
                return 0;
            }

            if (adjacencyMatrix.get(beginWord).size() == 0) {
                return 0;
            }
            if (!adjacencyMatrix.containsKey(endWord)) {
                return 0;
            }

            Map<String, Integer> depthMatrix = new HashMap<>(adjacencyMatrix.size());
            for (String word : adjacencyMatrix.keySet()) {
                depthMatrix.put(word, 0);
            }


            Queue<String> bfsQueue = new LinkedList<>();

            for (String word : adjacencyMatrix.get(beginWord)) {
                bfsQueue.add(word);
                depthMatrix.put(word, 2);
            }

            while (!bfsQueue.isEmpty()) {
                String word = bfsQueue.poll();
                if (endWord.equals(word)){
                    return depthMatrix.get(endWord);
                }
                if (!word.equals(beginWord)) {
                    int currentWordDepth = depthMatrix.get(word);
                    for (String nextWord : adjacencyMatrix.get(word)) {
                        if ((depthMatrix.get(nextWord)==0) || (1 + currentWordDepth) < depthMatrix.get(nextWord)) {
                            bfsQueue.add(nextWord);
                            depthMatrix.put(nextWord, 1 + currentWordDepth);
                        }
                    }
                }
            }

            return depthMatrix.get(endWord);

        }


    }

}
