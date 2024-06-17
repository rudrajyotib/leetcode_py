/*
https://leetcode.com/problems/loud-and-rich/description/
 */

package leet.solutions;

import java.util.LinkedList;

public class LoudAndRich {

    public int[] solve(int[][] richer, int[] quiet) {
        return new Solution().loudAndRich(richer, quiet);
    }


    static class Solution {
        public int[] loudAndRich(int[][] richer, int[] quiet) {

            if (quiet.length == 1) {
                return new int[]{0};
            }

            @SuppressWarnings("unchecked") LinkedList<Integer>[] adjacencyList = new LinkedList[quiet.length];

            for (int i = 0; i < adjacencyList.length; i++) {
                adjacencyList[i] = new LinkedList<>();
            }

            for (int[] rich : richer) {
                adjacencyList[rich[1]].add(rich[0]);
            }

            boolean[] visited = new boolean[quiet.length];
            int[] result = new int[quiet.length];
            for (int i = 0; i < quiet.length; i++) {
                richAndQuietRecursive(adjacencyList, i, visited, result, quiet);
            }

            return result;
        }

        public void richAndQuietRecursive(LinkedList<Integer>[] adjacencyList, int node, boolean[] visited, int[] result, int[] quiet) {
            if (visited[node]) {
                return;
            }
            if (adjacencyList[node].isEmpty()) {
                result[node] = node;
                visited[node] = true;
                return;
            }
            LinkedList<Integer> neighbours = adjacencyList[node];
            visited[node] = true;
            for (Integer neighbour : neighbours) {
                richAndQuietRecursive(adjacencyList, neighbour, visited, result, quiet);
            }
            int quietLevel = node;
            for (Integer neighbour : neighbours) {
                if (quiet[result[neighbour]] < quiet[quietLevel]) {
                    quietLevel = result[neighbour];
                }
            }
            result[node] = quietLevel;
        }
    }
}



