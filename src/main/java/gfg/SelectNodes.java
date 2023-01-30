package gfg;

/*
https://practice.geeksforgeeks.org/problems/f7bfa137576243795abb0595962d61b632bbad21/1
 */

import java.util.LinkedList;
import java.util.List;

public class SelectNodes {

    public int solve(int nodes, int[][] edges){
        return new Solution().countVertex(nodes, edges);
    }

    static class Solution{
        public int countVertex(int nodes, int[][] edges){
            // code here
            @SuppressWarnings("unchecked") List<Integer>[] adjacencyList = new LinkedList[nodes+1];
            for (int i=0;i<nodes+1;i++){
                adjacencyList[i] = new LinkedList<>();
            }
            for (int[] edge : edges) {
                adjacencyList[edge[0]].add(edge[1]);
                adjacencyList[edge[1]].add(edge[0]);
            }
            int[][] dp = new int[nodes+1][2];
            for (int[] ints : dp) {
                ints[0]=-1;
                ints[1] = -1;
            }
            return Math.min(countVertexRec(1, 1, -1, dp, adjacencyList)+1,
                    countVertexRec(1, 0, -1, dp, adjacencyList));
        }

        private int countVertexRec(int node, int isLightUp, int parent, int[][] dp, List<Integer>[] adjacencyList){
            int answer = 0;
            if (dp[node][isLightUp] != -1){
                return dp[node][isLightUp];
            }
            for (Integer neighbour : adjacencyList[node]){
                if (parent != neighbour){
                    if (isLightUp == 1){
                        int neighbourOff = countVertexRec(neighbour, 0, node, dp, adjacencyList);
                        int neighbourOn = countVertexRec(neighbour, 1, node, dp, adjacencyList);
                        answer += Math.min(neighbourOff, neighbourOn+1);
                    }else{
                        answer += (countVertexRec(neighbour, 1, node, dp, adjacencyList)+1);
                    }
                }
            }
            dp[node][isLightUp] = answer;
            return answer;
        }

    }

}
