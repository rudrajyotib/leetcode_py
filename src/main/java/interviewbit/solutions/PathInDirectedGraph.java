package interviewbit.solutions;

import java.util.*;

public class PathInDirectedGraph {

    public boolean solve(int nodes, int[][] edges){
        return new Solution().solve(nodes, edges) == 1;
    }

    public static class Solution {
        public int solve(int A, int[][] B) {
            Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
            for (int i=1;i<=A;i++){
                adjacencyList.put(i, new LinkedList<>());
            }
            for (int[] edge: B){
                adjacencyList.get(edge[0]).add(edge[1]);
            }
            Queue<Integer> queue = new LinkedList<>();
            boolean[] visitTracker = new boolean[A+1];
            queue.add(1);
            visitTracker[1] = true;
            while (!queue.isEmpty()){
                int node = queue.poll();
                if (node == A){
                    return 1;
                }
                for (int neighbor : adjacencyList.get(node)){
                    if (!visitTracker[neighbor]){
                        queue.add(neighbor);
                        visitTracker[neighbor] = true;
                    }
                }

            }
            return 0;
        }
    }


}
