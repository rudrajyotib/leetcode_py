package interviewbit.solutions;

/*
https://www.interviewbit.com/problems/connected-components/
 */

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ConnectedComponents {

    public int solve(int nodes, int[][] edges){
        return new Solution().solve(nodes, edges);
    }

    public static class Solution {
        public int solve(int A, int[][] B) {

            Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
            for (int i=1;i<=A;i++){
                adjacencyList.put(i, new LinkedList<>());
            }
            for (int[] edge: B){
                adjacencyList.get(edge[0]).add(edge[1]);
                adjacencyList.get(edge[1]).add(edge[0]);
            }
            boolean[] visitTracker = new boolean[A+1];
            int connectedComponents = 0;
            for (int i=1;i<=A;i++){
                if (!visitTracker[i]){
                    ++connectedComponents;
                    dfs(i, visitTracker, adjacencyList);
                }
            }

            return connectedComponents;
        }

        private void dfs(int node, boolean[] visitTracker, Map<Integer, List<Integer>> adjacencyList){
            if (visitTracker[node]){
                return;
            }
            visitTracker[node] = true;
            for (Integer neighbor: adjacencyList.get(node)){
                dfs(neighbor, visitTracker, adjacencyList);
            }
        }
    }

}
