/*
https://leetcode.com/problems/critical-connections-in-a-network
 */

package leet.solutions;

import java.util.*;

public class CriticalConnectionsInNetwork {

    public List<List<Integer>> solve(int n, List<List<Integer>> connections) {
        return new Solution().criticalConnections(n, connections);
    }


    static class Solution {
        public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

            Map<Integer, Set<Integer>> adjacencyList = new HashMap<>();
            connections.forEach(integers -> {
                if (!adjacencyList.containsKey(integers.get(0))) {
                    adjacencyList.put(integers.get(0), new HashSet<>());
                }
                adjacencyList.get(integers.get(0)).add(integers.get(1));
                if (!adjacencyList.containsKey(integers.get(1))) {
                    adjacencyList.put(integers.get(1), new HashSet<>());
                }
                adjacencyList.get(integers.get(1)).add(integers.get(0));
            });

            int[] rankingTable = new int[n];
            Arrays.fill(rankingTable, -2);
            List<Integer[]> discardedConnections = new LinkedList<>();
            dfsWithCycleDetection(0, 0, rankingTable, n, adjacencyList, discardedConnections);
            for (Integer[] discardedConnection : discardedConnections) {
                adjacencyList.get(discardedConnection[0]).remove(discardedConnection[1]);
                adjacencyList.get(discardedConnection[1]).remove(discardedConnection[0]);
            }
            List<List<Integer>> result = new LinkedList<>();
            adjacencyList.keySet().forEach(integer -> {
                for (Integer i : adjacencyList.get(integer)) {
                    result.add(List.of(integer, i));
                    adjacencyList.get(i).remove(integer);
                }
            });
            return result;
        }

        private int dfsWithCycleDetection(int node, int depth, int[] ranks, int serversCount, Map<Integer, Set<Integer>> adjacencyList, List<Integer[]> discardedConnections) {
            if (ranks[node] >= 0) {
                return ranks[node];
            }
            ranks[node] = depth;
            int minDepth = serversCount;
            for (Integer neighbor : adjacencyList.get(node)) {
                if (ranks[neighbor] == depth - 1) {
                    continue;
                }
                int neighbourMinDepth = dfsWithCycleDetection(neighbor, depth + 1, ranks, serversCount, adjacencyList, discardedConnections);
                if (neighbourMinDepth <= depth) {
                    if (node < neighbor) {
                        discardedConnections.add(new Integer[]{node, neighbor});
                    } else {
                        discardedConnections.add(new Integer[]{neighbor, node});
                    }
                }
                minDepth = Math.min(minDepth, neighbourMinDepth);
            }
            return minDepth;
        }
    }
}
