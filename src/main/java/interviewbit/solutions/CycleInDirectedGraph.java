package interviewbit.solutions;

/*
https://www.interviewbit.com/problems/cycle-in-directed-graph/
 */

import java.util.*;

public class CycleInDirectedGraph {

    public boolean solve(int nodesCount, int[][] edges){
        return new Solution().solve(nodesCount, edges) == 1;
    }

    public static class Solution {
        public int solve(int nodes, int[][] edges) {
            Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
            for (int i=1;i<=nodes;i++){
                adjacencyList.put(i, new LinkedList<>());
            }
            for (int[] edge : edges) {
                adjacencyList.get(edge[0]).add(edge[1]);
            }
            boolean[] visitTracker = new boolean[nodes+1];
            boolean[] trailTracker = new boolean[nodes+1];

            for (int i=1;i<=nodes;i++){
                if (isCycle(adjacencyList, i, visitTracker, trailTracker)){
                    return 1;
                }
            }

            return 0;
        }

        private boolean isCycle(Map<Integer, List<Integer>> adjacencyList, int node, boolean[] visitTracker, boolean[] trail){
            if (trail[node]){
                return true;
            }
            if (visitTracker[node]){
                return false;
            }
            trail[node] = true;
            visitTracker[node] = true;
            for (Integer vertex : adjacencyList.get(node)){
                if (isCycle(adjacencyList, vertex, visitTracker, trail)){
                    return true;
                }
            }
            trail[node] = false;
            return false;
        }

    }

}
