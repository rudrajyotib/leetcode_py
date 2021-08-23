package leet.solutions;

/*
https://leetcode.com/problems/word-search-ii/
Leetcode#212
 */


import java.util.*;

public class WordSearch2 {

    static class TrieNode {
        private final Map<Character, TrieNode> nextLevelMap;
        private boolean endOfWord = false;

        TrieNode() {
            this.nextLevelMap = new HashMap<>();
        }

        public boolean isNextNode(char nextChar) {
            return nextLevelMap.containsKey(nextChar);
        }

        public TrieNode getNextNode(char nextChar) {
            return nextLevelMap.get(nextChar);
        }

        public TrieNode addNode(char nextChar) {
            if (nextLevelMap.containsKey(nextChar)) {
                return nextLevelMap.get(nextChar);
            }
            TrieNode nextNode = new TrieNode();
            nextLevelMap.put(nextChar, nextNode);
            return nextNode;
        }

        public void markEndOfWord() {
            this.endOfWord = true;
        }

        public boolean isEndOfWord() {
            return this.endOfWord;
        }
    }

    static class Dictionary {
        private final Map<Character, TrieNode> startLevelMap = new HashMap<>();

        public void addWord(String word) {
            if (!this.startLevelMap.containsKey(word.charAt(0))) {
                startLevelMap.put(word.charAt(0), new TrieNode());
            }
            TrieNode charNode = startLevelMap.get(word.charAt(0));
            for (int i = 1; i < word.length(); i++) {
                charNode = charNode.addNode(word.charAt(i));
            }
            charNode.markEndOfWord();
        }

        public boolean isNodeSet(char nextChar) {
            return startLevelMap.containsKey(nextChar);
        }

        public TrieNode getNode(char firstChar) {
            return startLevelMap.get(firstChar);
        }

        public boolean isWordPresent(String word) {
            TrieNode charNode = startLevelMap.get(word.charAt(0));
            if (charNode == null) {
                return false;
            }
            for (int i = 1; i < word.length(); i++) {
                charNode = charNode.getNextNode(word.charAt(i));
                if (charNode == null) {
                    return false;
                }
            }
            return charNode.isEndOfWord();
        }

    }


    @SuppressWarnings("InnerClassMayBeStatic")
    class Solution {

        private boolean[][] visited;
        private int columnCount;
        private int rowCount;
        private char[][] dataGrid;
        private Set<String> target;

        public List<String> findWords(char[][] board, String[] words) {

            this.rowCount = board.length;
            this.columnCount = board[0].length;
            this.visited = new boolean[rowCount][columnCount];
            this.dataGrid = board;
            this.target = new HashSet<>();

            Dictionary dictionary = new Dictionary();
            for (String word : words) {
                dictionary.addWord(word);
                target.add(word);
            }

            Set<String> wordsFound = new HashSet<>();

            for (int i = 0; i < rowCount; i++) {
                for (int j = 0; j < columnCount; j++) {
                    if (dictionary.isNodeSet(dataGrid[i][j])) {
                        searchRecursive(new int[]{i, j}, dictionary.getNode(dataGrid[i][j]), "", wordsFound);
                    }
                }
            }

            return new ArrayList<>() {
                {
                    addAll(wordsFound);
                }
            };
        }

        private void searchRecursive(int[] boardPosition,
                                     TrieNode node,
                                     String wordInMaking,
                                     Set<String> wordsFound) {
            if (!inRange(boardPosition)) {
                return;
            }
            if (visited[boardPosition[0]][boardPosition[1]]) {
                return;
            }
            char currentChar = dataGrid[boardPosition[0]][boardPosition[1]];
            String wordFormed = wordInMaking + currentChar;
            if (node.isEndOfWord()) {
                if (target.contains(wordFormed)) {
                    wordsFound.add(wordFormed);
                }
            }
            visited[boardPosition[0]][boardPosition[1]] = true;
            int[] north = new int[]{boardPosition[0] - 1, boardPosition[1]};
            int[] south = new int[]{boardPosition[0] + 1, boardPosition[1]};
            int[] east = new int[]{boardPosition[0], boardPosition[1] - 1};
            int[] west = new int[]{boardPosition[0], boardPosition[1] + 1};
            if (inRange(north) && node.isNextNode(dataGrid[north[0]][north[1]])) {
                searchRecursive(north, node.getNextNode(dataGrid[north[0]][north[1]]), wordFormed, wordsFound);
            }
            if (inRange(south) && node.isNextNode(dataGrid[south[0]][south[1]])) {
                searchRecursive(south, node.getNextNode(dataGrid[south[0]][south[1]]), wordFormed, wordsFound);
            }
            if (inRange(east) && node.isNextNode(dataGrid[east[0]][east[1]])) {
                searchRecursive(east, node.getNextNode(dataGrid[east[0]][east[1]]), wordFormed, wordsFound);
            }
            if (inRange(west) && node.isNextNode(dataGrid[west[0]][west[1]])) {
                searchRecursive(west, node.getNextNode(dataGrid[west[0]][west[1]]), wordFormed, wordsFound);
            }
            visited[boardPosition[0]][boardPosition[1]] = false;
        }

        private boolean inRange(int[] position) {
            return ((position[0] >= 0) && (position[0] <= rowCount - 1) && (position[1] >= 0) && (position[1] <= columnCount - 1));
        }

    }


    public List<String> solve(char[][] board, String[] words) {
        Solution solution = new Solution();
        return solution.findWords(board, words);
    }
}



