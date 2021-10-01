package leet.solutions;

/*
https://leetcode.com/problems/redundant-connection/
Leetcode#684
 */

import java.util.*;

public class RedundantConnection {

    public int[] solve(int[][] edges) {
        Solution solution = new Solution();
        return solution.findRedundantConnection(edges);
    }


    @SuppressWarnings("InnerClassMayBeStatic")
    class Solution {
        public int[] findRedundantConnection(int[][] edges) {

            Map<Integer, Set<Integer>> adjacencyList = new HashMap<>();
            for (int[] edge : edges) {
                if (adjacencyList.containsKey(edge[0])) {
                    adjacencyList.get(edge[0]).add(edge[1]);
                } else {
                    adjacencyList.put(edge[0], new HashSet<>() {
                        {
                            add(edge[1]);
                        }
                    });
                }

                if (adjacencyList.containsKey(edge[1])) {
                    adjacencyList.get(edge[1]).add(edge[0]);
                } else {
                    adjacencyList.put(edge[1], new HashSet<>() {
                        {
                            add(edge[0]);
                        }
                    });
                }

            }

            LinkedList<Integer> evaluatorQueue = new LinkedList<>();
            for (Map.Entry<Integer, Set<Integer>> node : adjacencyList.entrySet()) {
                if (node.getValue().size() == 1) {
                    evaluatorQueue.addLast(node.getKey());
                }
            }

            while (evaluatorQueue.size() != 0) {
                Integer node = evaluatorQueue.pollFirst();
                Integer linkedNode = adjacencyList.get(node).stream().findFirst().orElse(-1);
                adjacencyList.get(linkedNode).remove(node);
                adjacencyList.remove(node);
                if (adjacencyList.get(linkedNode).size() == 1) {
                    evaluatorQueue.addLast(linkedNode);
                }
            }

            for (int i=edges.length-1; i >=0; i--)
            {
                if (adjacencyList.containsKey(edges[i][0]) && adjacencyList.containsKey(edges[i][1]))
                {
                    return edges[i];
                }
            }

            return new int[]{0,0};

        }
    }

}
