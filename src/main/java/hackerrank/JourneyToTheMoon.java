/*
https://www.hackerrank.com/challenges/journey-to-the-moon
 */

package hackerrank;

import java.util.*;

public class JourneyToTheMoon {

    public static int journeyToMoon(int n, List<List<Integer>> astronaut) {
        // Write your code here
        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
        for (List<Integer> pair : astronaut) {
            if (!adjacencyList.containsKey(pair.get(0))){
                adjacencyList.put(pair.get(0), new LinkedList<>());
            }
            if (!adjacencyList.containsKey(pair.get(1))){
                adjacencyList.put(pair.get(1), new LinkedList<>());
            }
            adjacencyList.get(pair.get(0)).add(pair.get(1));
            adjacencyList.get(pair.get(1)).add(pair.get(0));
        }
        Set<Integer> visited = new HashSet<>();
        List<Integer> clusterSizes = new LinkedList<>();
        for (Integer node : adjacencyList.keySet()) {
            if (!visited.contains(node)){
                clusterSizes.add(clusterSize(adjacencyList, visited, node));
            }
        }
        if (clusterSizes.size() == 1){
            Integer nodeSize = clusterSizes.get(0);
            return nodeSize * (nodeSize-1)/2;
        }

        int total = n * (n-1) / 2;
        for (Integer clusterSize : clusterSizes) {
            total -= (clusterSize * (clusterSize-1)/2);
        }

        return total;
    }

    private static int clusterSize(Map<Integer, List<Integer>> adjacencyList, Set<Integer> visitedList, Integer node){
        if (visitedList.contains(node)){
            return 0;
        }
        int clusterCount = 1;
        visitedList.add(node);
        for (Integer child: adjacencyList.get(node)){
            clusterCount += clusterSize(adjacencyList, visitedList, child);
        }
        return clusterCount;
    }

}
