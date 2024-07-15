/*
https://www.geeksforgeeks.org/problems/bridge-edge-in-graph
 */

package gfg;

import java.util.*;

@SuppressWarnings("SameParameterValue")
public class BridgeEdgeInGap {

    static int isBridge(int V, ArrayList<ArrayList<Integer>> adj, int c, int d)
    {
        // code here
        Map<Integer, Set<Integer>> connections = new HashMap<>(V, 1);
        for (int i=0;i<V;i++){
            connections.put(i, new HashSet<>());
        }
        boolean[] visited = new boolean[V];
        for (int i=0;i<adj.size();i++){
            for (Integer n: adj.get(i)){
                connections.get(i).add(n);
                connections.get(n).add(i);
            }
        }
        connections.get(c).remove(d);
        connections.get(d).remove(c);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(c);
        while (!queue.isEmpty()){
            Integer vertex = queue.poll();
            if (visited[vertex]){
                continue;
            }
            visited[vertex] = true;
            for (Integer n : connections.get(vertex)){
                if (!visited[n]){
                    queue.add(n);
                }
            }
        }
        return visited[d]?0:1;
    }

}
