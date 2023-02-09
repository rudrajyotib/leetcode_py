package gfg;

/*
https://practice.geeksforgeeks.org/problems/9a88fe7ada1c49c2b3da7a67b43875e4a76aface/1
 */

/*
Reference : https://www.geeksforgeeks.org/maximum-bipartite-matching/?ref=lbp
 */

import java.util.Arrays;

public class MaximumBipartiteMatching {


    public int solve(int[][] graph){
        return new Solution().maximumMatch(graph);
    }

    static class Solution
    {
        private int[] match;
        public int maximumMatch(int[][] graph)
        {
            // Code here
            int applicants = graph.length;
            int jobs = graph[0].length;
            match = new int[jobs];
            Arrays.fill(match, -1);
            int max = 0;
            for(int i=0;i<applicants;i++){
                if (recursiveBipartite(graph, jobs, new boolean[jobs], i)){
                    ++max;
                }
            }
            return max;
        }

        private boolean recursiveBipartite(int[][] graph, int jobs, boolean[] visited, int applicantIndex){
            for (int i=0;i<jobs;i++){
                if (graph[applicantIndex][i] == 1 && !visited[i]){
                    visited[i] = true;
                    if (match[i] == -1 || recursiveBipartite(graph, jobs, visited, match[i])){
                        match[i] = applicantIndex;
                        return true;
                    }
                }
            }
            return false;
        }
    }
}
