package hackerrank;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class EvenTree {

    static int removableEdge = 0;

    @SuppressWarnings("SameParameterValue")
    static int evenForest(int t_nodes, int t_edges, List<Integer> t_from, List<Integer> t_to) {
        removableEdge = 0;
        Map<Integer, List<Integer>> adjacencyList = new HashMap<>(t_nodes, 1);
        for (int i=0;i<t_edges;i++){
            if(!adjacencyList.containsKey(t_from.get(i))){
                adjacencyList.put(t_from.get(i), new LinkedList<>());
            }
            if(!adjacencyList.containsKey(t_to.get(i))){
                adjacencyList.put(t_to.get(i), new LinkedList<>());
            }
            adjacencyList.get(t_from.get(i)).add(t_to.get(i));
            adjacencyList.get(t_to.get(i)).add(t_from.get(i));
        }
        calculateDepth(1,1,adjacencyList);
        return removableEdge;
    }

    static int calculateDepth(int t_node, int parent, Map<Integer, List<Integer>> adjacencyList){
        int childrenCount = 1;
        for (Integer child: adjacencyList.get(t_node)){
            if (child == parent){
                continue;
            }
            int depth = calculateDepth(child, t_node, adjacencyList);
            if (depth > 0 && depth%2 == 0){
                ++removableEdge;
            }
            childrenCount+=depth;
        }
        return childrenCount;
    }


}
