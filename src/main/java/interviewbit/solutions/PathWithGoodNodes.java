package interviewbit.solutions;

/*
https://www.interviewbit.com/problems/path-with-good-nodes/
 */

import java.util.*;

public class PathWithGoodNodes {

    public int solve(int[] nodes, int[][] edges, int maxGoodNode){
        return new Solution().solve(nodes, edges, maxGoodNode);
    }

    public static class Solution {
        public int solve(int[] A, int[][] B, int C) {
            Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
            for (int i=1;i<=A.length;i++){
                adjacencyList.put(i, new LinkedList<>());
            }
            for (int[] edge: B){
                adjacencyList.get(edge[0]).add(edge[1]);
                adjacencyList.get(edge[1]).add(edge[0]);
            }
            int countTillLeafNode = 0;
            boolean[] visitTracker = new boolean[A.length+1];
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{1, 0});
            while (!queue.isEmpty()){
                int[] node = queue.poll();
                int goodNodesTillNode = node[1] + (A[node[0]-1] == 1 ? 1 : 0);
                visitTracker[node[0]] = true;
                List<Integer> unvisitedNeighbours = new LinkedList<>();
                for (Integer neighbour : adjacencyList.get(node[0])){
                    if (!visitTracker[neighbour]){
                        unvisitedNeighbours.add(neighbour);
                    }
                }
                if (unvisitedNeighbours.isEmpty()){
                    if (goodNodesTillNode <= C){
                        ++countTillLeafNode;
                    }
                }else{
                    if (goodNodesTillNode<=C) {
                        for (int neighbour : unvisitedNeighbours) {
                            queue.add(new int[]{neighbour, goodNodesTillNode});
                        }
                    }
                }
            }
            return countTillLeafNode;
        }
    }

}
