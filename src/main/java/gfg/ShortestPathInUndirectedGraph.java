/*
https://www.geeksforgeeks.org/problems/shortest-path-in-undirected-graph-having-unit-distance/1
 */

package gfg;

import java.util.*;

public class ShortestPathInUndirectedGraph {

    public int[] shortestPath(int[][] edges, int n, int src) {
        // Code here
        int[] distances = new int[n];
        Arrays.fill(distances, -1);
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adjList.put(i, new LinkedList<>());
        }
        for (int[] edge : edges) {
            if (edge[0] < n && edge[1] < n) {
                adjList.get(edge[0]).add(edge[1]);
                adjList.get(edge[1]).add(edge[0]);
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        distances[src] = 0;
        queue.add(src);
        while (!queue.isEmpty()) {
            Integer node = queue.remove();
            for (Integer connect : adjList.get(node)) {
                if (distances[connect] == -1) {
                    distances[connect] = distances[node] + 1;
                    queue.add(connect);
                } else {
                    if (distances[node] + 1 < distances[connect]) {
                        distances[connect] = distances[node] + 1;
                        queue.add(connect);
                    }
                }
            }
        }
        return distances;
    }
}
