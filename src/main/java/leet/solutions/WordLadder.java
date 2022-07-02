package leet.solutions;

import java.util.*;

public class WordLadder {


    public int solve(String beginWord, String endWord, List<String> wordList) {
        return new Solution().ladderLength(beginWord, endWord, wordList);
    }

    @SuppressWarnings("InnerClassMayBeStatic")
    class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {

            Map<String, List<String>> adjacencyMatrix = new HashMap<>();
            for (int i = 0; i < wordList.size(); i++) {
                adjacencyMatrix.put(wordList.get(i), new LinkedList<>());
                for (int j = 0; j < wordList.size(); j++) {
                    if (i != j) {
                        if (isReplaceable(wordList.get(i), wordList.get(j))) {
                            adjacencyMatrix.get(wordList.get(i)).add(wordList.get(j));
                        }
                    }
                }
            }

            if (!adjacencyMatrix.containsKey(beginWord)) {
                List<String> adjacentWords = new LinkedList<>();
                for (String word : wordList) {
                    if (isReplaceable(beginWord, word)) {
                        adjacentWords.add(word);
                    }
                }
                adjacencyMatrix.put(beginWord, adjacentWords);
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

        private boolean isReplaceable(String start, String end) {
            int differenceOfLetters = 0;
            for (int i = 0; i < start.length(); i++) {
                if (start.charAt(i) != end.charAt(i)) {
                    differenceOfLetters += 1;
                }
            }
            return differenceOfLetters == 1;
        }
    }

}
