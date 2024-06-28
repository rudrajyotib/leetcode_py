/*
https://www.hackerrank.com/challenges/matrix
 */

package hackerrank;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MatrixCityAttack {

    private static int result = 0;

    public static int minTime(List<List<Integer>> roads, List<Integer> machines) {
        result = 0;
        // Write your code here
        Map<Integer, List<Integer[]>> adjacencyList = new HashMap<>();

        for (List<Integer> road : roads) {
            if (!adjacencyList.containsKey(road.get(0))) {
                adjacencyList.put(road.get(0), new LinkedList<>());
            }
            if (!adjacencyList.containsKey(road.get(1))) {
                adjacencyList.put(road.get(1), new LinkedList<>());
            }
            adjacencyList.get(road.get(0)).add(new Integer[]{road.get(1), road.get(2)});
            adjacencyList.get(road.get(1)).add(new Integer[]{road.get(0), road.get(2)});
        }
        recursiveDfs(0, -1, adjacencyList, machines);
        return result;
    }

    private static int recursiveDfs(int node, int parent, Map<Integer, List<Integer[]>> adjacencyList, List<Integer> machines) {
        List<Integer> weights = new LinkedList<>();
        for (Integer[] weightedNeighbor : adjacencyList.get(node)) {
            if (weightedNeighbor[0] == parent) {
                continue;
            }
            int dist = recursiveDfs(weightedNeighbor[0], node, adjacencyList, machines);
            if (dist == 0) {
                if (machines.contains(weightedNeighbor[0])) {
                    weights.add(weightedNeighbor[1]);
                }
            } else {
                weights.add(Math.min(weightedNeighbor[1], dist));
            }
        }
        if (machines.contains(node)) {
            int sum = 0;
            for (Integer weight : weights) {
                sum += weight;
            }
            result += sum;
            return 0;
        } else {
            if (weights.isEmpty()) {
                return 0;
            }
            if (weights.size() == 1) {
                return weights.get(0);
            }
            int sum = 0;
            int localMax = 0;
            for (Integer weight : weights) {
                if (weight >= localMax) {
                    sum += localMax;
                    localMax = weight;
                } else {
                    sum += weight;
                }
            }
            result += sum;
            return localMax;
        }
    }


}
