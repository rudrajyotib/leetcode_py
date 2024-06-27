/*
https://www.hackerrank.com/challenges/find-the-nearest-clone/problem
 */

package hackerrank;

import java.util.*;

public class FindNearestClone {

    @SuppressWarnings({"SameParameterValue", "unused"})
    static int findShortest(int graphNodes, int[] graphFrom, int[] graphTo, long[] ids, int val) {
        // solve here
        Map<Long, Set<Integer>> colorCodedNodes = new HashMap<>();
        for (int i=0;i<ids.length;i++){
            if (!colorCodedNodes.containsKey(ids[i])){
                colorCodedNodes.put(ids[i], new HashSet<>());
            }
            colorCodedNodes.get(ids[i]).add(i+1);
        }
        if (!colorCodedNodes.containsKey((long)val) || colorCodedNodes.get((long)val).size() < 2){
            return -1;
        }

        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
        for (int i=0;i<graphFrom.length;i++){
            if (!adjacencyList.containsKey(graphFrom[i])){
                adjacencyList.put(graphFrom[i], new LinkedList<>());
            }
            if (!adjacencyList.containsKey(graphTo[i])){
                adjacencyList.put(graphTo[i], new LinkedList<>());
            }
            adjacencyList.get(graphFrom[i]).add(graphTo[i]);
            adjacencyList.get(graphTo[i]).add(graphFrom[i]);
        }

        int minDistance = Integer.MAX_VALUE;
        Queue<Integer> bfsQueue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        for (Integer node: colorCodedNodes.get((long)val)){
            bfsQueue.clear();
            bfsQueue.add(node);
            int depth = 0;
            visited.clear();
            boolean colorFound = false;
            visited.add(node);
            while (!bfsQueue.isEmpty() && !colorFound){
                int currentWidth = bfsQueue.size();
                ++depth;
                for (int i=0;i<currentWidth;i++){
                    Integer polledNode = bfsQueue.poll();
                    visited.add(polledNode);
                    if (adjacencyList.containsKey(polledNode)){
                        for (Integer neighbor: adjacencyList.get(polledNode)){
                            if (visited.contains(neighbor)){
                                continue;
                            }
                            if (colorCodedNodes.get((long)val).contains(neighbor)){
                                colorFound = true;
                            }
                            bfsQueue.add(neighbor);
                        }
                    }
                }
            }
            minDistance = Math.min(minDistance, depth);
        }

        return minDistance;
    }







}
