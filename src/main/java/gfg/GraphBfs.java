package gfg;

import java.util.*;

public class GraphBfs {
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0;i<V;i++){
            map.put(i, new LinkedList<>());
        }
        for(int i=0;i<adj.size();i++){
            ArrayList<Integer> neighbours = adj.get(i);
            for (Integer neighbour: neighbours){
                map.get(i).add(neighbour);
            }
        }
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>(V);

            queue.add(0);
            while (!queue.isEmpty()){
                Integer node = queue.poll();
                if (visited[node]){
                    continue;
                }
                result.add(node);
                visited[node] = true;
                for (Integer connect: map.get(node)){
                    if (!visited[connect]){
                        queue.add(connect);
                    }
                }
            }

        return result;
    }
}
