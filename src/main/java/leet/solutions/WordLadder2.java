package leet.solutions;

/*
https://leetcode.com/problems/word-ladder-ii/
TLE
 */

import java.util.*;

public class WordLadder2 {


    public List<List<String>> solve(String beginWord, String endWord, List<String> wordList){
        return new Solution().findLadders(beginWord, endWord, wordList);
    }

    class Solution {
        public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

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
                return Collections.emptyList();
            }
            if (!adjacencyMatrix.containsKey(endWord)) {
                return Collections.emptyList();
            }

            if (adjacencyMatrix.get(beginWord).size() == 0) {
                return Collections.emptyList();
            }
            if (!adjacencyMatrix.containsKey(endWord)) {
                return Collections.emptyList();
            }


            Queue<Path> bfsQueue = new LinkedList<>();
            Path beginPath = new Path(beginWord);
            beginPath.addWordToChain(beginWord);

            bfsQueue.add(beginPath);
            List<List<String>> result = new LinkedList<>();
            boolean endWordReached = false;

            while ( !bfsQueue.isEmpty()){
                if (endWordReached){
                    return result;
                }
                int queueDepth = bfsQueue.size();
                for (int i=0;i<queueDepth;i++){
                    Path nextWord = bfsQueue.poll();
                    assert nextWord != null;
                    for (String connection : adjacencyMatrix.get(nextWord.getWord())){
                        if (nextWord.inPath(connection)){
                            continue;
                        }
                        Path connectionPath = nextWord.copyToWord(connection);
                        if (connection.equals(endWord)){
                            endWordReached = true;
                            result.add(connectionPath.getChain());
                        }else{

                            if (!endWordReached){
                                bfsQueue.add(connectionPath);
                            }
                        }
                    }
                }
            }


            return result;
        }
    }

    class Path{
        private final String word;
        private List<String> chain;
        private Set<String> tracker;
        Path(String word) {
            this.word = word;
            this.chain = new LinkedList<>();
            this.tracker = new HashSet<>();
        }

        public String getWord(){return this.word;}

        public List<String> getChain(){return this.chain;}

        public void addWordToChain(String anotherWord){
            this.chain.add(anotherWord);
        }

        public Path copyToWord(String nextWord){
            Path clonedPath = new Path(nextWord);
            clonedPath.chain.addAll(this.chain);
            clonedPath.chain.add(nextWord);
            clonedPath.tracker.addAll(this.tracker);
            clonedPath.tracker.add(nextWord);
            return clonedPath;
        }

        public boolean inPath(String anyWord){
            return this.tracker.contains(anyWord);
        }
    }

}
