package gfg;

import java.util.*;

public class Dijkstra {
    static int[] dijkstra(@SuppressWarnings("SameParameterValue") int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, @SuppressWarnings("SameParameterValue") int S)
    {
        // Write your code here

        Map<Integer, List<Integer[]>> weightedDist = new HashMap<>();


        for (int i=0;i<V;i++){
            weightedDist.put(i, new LinkedList<>());
        }

        for (int i=0;i<adj.size();i++){
            ArrayList<ArrayList<Integer>> n = adj.get(i);
            for (ArrayList<Integer> integers : n) {
                weightedDist.get(i).add(new Integer[]{integers.get(0), integers.get(1)});
            }
        }

        int[] dists = new int[V];

        for (int i=0;i<V;i++){
            if (S != i){
                dists[i] = Integer.MAX_VALUE;
            }else{
                dists[S] = 0;
            }
        }

        PriorityQueue<Integer[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));

        for (int i=0;i<weightedDist.get(S).size();i++){
            Integer[] connections = weightedDist.get(S).get(i);
            dists[connections[0]] = connections[1];
            priorityQueue.offer(new Integer[]{connections[0], connections[1]});
        }

        while (!priorityQueue.isEmpty()){
            Integer[] connection = priorityQueue.poll();
            for (int i=0;i<weightedDist.get(connection[0]).size();i++){
                Integer[] next = weightedDist.get(connection[0]).get(i);
                int dist = connection[1] + next[1];
                if (dists[next[0]] > dist){
                    dists[next[0]] = dist;
                    priorityQueue.offer(new Integer[]{next[0], dist});
                }
            }
        }
        return dists;

    }


}
