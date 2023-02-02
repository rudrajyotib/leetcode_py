package gfg;

/*
https://practice.geeksforgeeks.org/problems/51afa710a708c0681748445b509696dd588d5c40/1
 */

public class LargestSumCycle {

    public long solve(int nodes, int[] edges){
        return new Solution().largesSumCycle(nodes, edges);
    }

    static class Solution{

        long cycleLength = -1L;

        public long largesSumCycle(int nodes, int[] edges){

            boolean[] visited = new boolean[nodes];
            boolean[] trail = new boolean[nodes];
            for (int i=0;i<nodes;i++){
                dfs(visited, trail, edges, i);
            }
            return cycleLength;
        }

        private void dfs(boolean[] visitedArray, boolean[] trail, int[] edges, int node){
            if (node == -1){
                return;
            }
            if (trail[node]){
                cycleLength = Math.max(detectCycleLength(edges, node), cycleLength);
                return;
            }
            if (visitedArray[node]){
                return;
            }
            visitedArray[node] = true;
            trail[node] = true;
            dfs(visitedArray, trail, edges, edges[node]);
            trail[node] = false;
        }

        private long detectCycleLength(int[] edges,  int nodeInCycle){
            long cycleLength = nodeInCycle;
            int nextNode = edges[nodeInCycle];
            while (nextNode != nodeInCycle){
                cycleLength+=nextNode;
                nextNode = edges[nextNode];
            }
            return cycleLength;
        }
    }
}
