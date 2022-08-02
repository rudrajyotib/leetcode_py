package interviewbit.solutions;
/*
https://www.interviewbit.com/problems/mother-vertex/
 */

import java.util.*;

public class MotherVertex {

    public boolean solve(int vertices, int[][] edges){
        return new Solution().motherVertex(vertices, edges) == 1;
    }

    public static class Solution {
        public int motherVertex(int vertices, int[][] edges) {
            Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
            for (int i=1;i<=vertices;i++){
                adjacencyList.put(i, new LinkedList<>());
            }
            for (int[] edge: edges){
                adjacencyList.get(edge[0]).add(edge[1]);
            }
            boolean[] visitTracker = new boolean[vertices+1];
            int probableMotherVertex = -1;
            for (int i=1;i<=vertices;i++){
                if (!visitTracker[i]){
                    dfs(i, visitTracker, adjacencyList);
                    probableMotherVertex = i;
                }
            }
            Arrays.fill(visitTracker, false);
            dfs(probableMotherVertex, visitTracker, adjacencyList);
            for (int i=1;i<=vertices;i++){
                if (!visitTracker[i]){
                    return 0;
                }
            }


            return 1;
        }

        private void dfs(int vertex, boolean[] visitTracker, Map<Integer, List<Integer>> adjacencyList){
            if (visitTracker[vertex]){
                return;
            }
            visitTracker[vertex] = true;
            for (int neighbor : adjacencyList.get(vertex)){
                dfs(neighbor, visitTracker, adjacencyList);
            }
        }
    }



}
