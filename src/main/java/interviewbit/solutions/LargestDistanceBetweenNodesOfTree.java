package interviewbit.solutions;

/*
https://www.interviewbit.com/problems/largest-distance-between-nodes-of-a-tree/
 */

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LargestDistanceBetweenNodesOfTree {

    public int solve(int[] tree){
        return new Solution().solve(tree);
    }

    @SuppressWarnings("InnerClassMayBeStatic")
    public class Solution {
        public int solve(int[] tree) {
            if (tree.length == 1){
                return 0;
            }
            if (tree.length==2){
                return 1;
            }
            Map<Integer, List<Integer>> adjacencyList = new HashMap<>(tree.length);
            boolean[] visitTracker = new boolean[tree.length];
            int[] distanceTracker = new int[tree.length];
            int rootNode = -1;
            for (int i=0;i<tree.length;i++){
                if (tree[i] == -1){
                    rootNode = i;
                }
                if (!adjacencyList.containsKey(i)){
                    adjacencyList.put(i, new LinkedList<>());
                }
                if (tree[i] != -1){
                    if (!adjacencyList.containsKey(tree[i])){
                        adjacencyList.put(tree[i], new LinkedList<>());
                    }
                    adjacencyList.get(i).add(tree[i]);
                    adjacencyList.get(tree[i]).add(i);
                }
            }
            dfs(rootNode, 0, distanceTracker, visitTracker, adjacencyList);
            int maxDistance = -1;
            int maxDistanceAtNode = -1;
            for (int i=0;i<distanceTracker.length;i++){
                if (distanceTracker[i]> maxDistance){
                    maxDistance = distanceTracker[i];
                    maxDistanceAtNode = i;
                }
                distanceTracker[i] = 0;
                visitTracker[i] = false;
            }

            dfs(maxDistanceAtNode, 0, distanceTracker, visitTracker, adjacencyList);
            maxDistance = -1;
            for (int j : distanceTracker) {
                if (j > maxDistance) {
                    maxDistance = j;
                }
            }
            return maxDistance;
        }

        private void dfs(int startNode, int distance, int[] distanceTracker, boolean[] visitTracker, Map<Integer, List<Integer>> adjacencyList){
            if (visitTracker[startNode]){
                return;
            }
            distanceTracker[startNode] = distance;
            visitTracker[startNode] = true;
            for (Integer child : adjacencyList.get(startNode)){
                dfs(child, distance+1, distanceTracker, visitTracker, adjacencyList);
            }
        }

    }


}
