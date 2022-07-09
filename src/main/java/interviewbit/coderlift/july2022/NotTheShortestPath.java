package interviewbit.coderlift.july2022;

import java.util.*;

public class NotTheShortestPath {


    public int[] solve(int nodesCount, int[][] nodesRelation, int[][] queries){
        return new Solution().answerQueries(nodesCount, nodesRelation, queries);
    }

    public class Solution {
        public int[] answerQueries(int nodesCount, int[][] nodesRelation, int[][] queries) {

            Map<Integer, Set<Integer>> adjacencyMatrix = new HashMap<>(nodesCount);

            for (int[] nodeRelation : nodesRelation) {
                if (adjacencyMatrix.containsKey(nodeRelation[0])){
                    adjacencyMatrix.get(nodeRelation[0]).add(nodeRelation[1]);
                }else{
                    adjacencyMatrix.put(nodeRelation[0], new HashSet<>());
                    adjacencyMatrix.get(nodeRelation[0]).add(nodeRelation[1]);
                }

                if (adjacencyMatrix.containsKey(nodeRelation[1])){
                    adjacencyMatrix.get(nodeRelation[1]).add(nodeRelation[0]);
                }else{
                    adjacencyMatrix.put(nodeRelation[1], new HashSet<>());
                    adjacencyMatrix.get(nodeRelation[1]).add(nodeRelation[0]);
                }
            }

            Set<Integer> visitTracker = new HashSet<>();
            Set<Integer> path = new HashSet<>();
            Stack<Integer> stack = new Stack<>();
            int[] result = new int[queries.length];
            int queryCounter = 0;


            for (int[] query : queries) {
                path.clear();
                visitTracker.clear();
                path.add(query[0]);
                findPath(query[0], query[1], visitTracker, path, adjacencyMatrix);
                if (path.contains(query[2])){
                    result[queryCounter] = query[2];
                    ++queryCounter;
                    continue;
                }
                visitTracker.clear();
                stack.clear();
                stack.add(query[2]);
                boolean pathFound = false;
                while (!pathFound && !stack.isEmpty()){
                    int breadh = stack.size();

                    for (int i=0;i<breadh;i++){
                        int node = stack.pop();
                        visitTracker.add(node);
                        if (path.contains(node)){
                            result[queryCounter] = node;
                            pathFound = true;
                            break;
                        }else{
                            for(int neighbour : adjacencyMatrix.get(node)){
                                if (!visitTracker.contains(neighbour)){
                                    stack.push(neighbour);
                                }
                            }
                        }
                    }
                }
                ++queryCounter;
            }


            return result;
        }

        private void findPath(int startNode, int endNode, Set<Integer> visitTracker, Set<Integer> path, Map<Integer, Set<Integer>> adjacencyMatrix){

            visitTracker.add(startNode);

            for (Integer neighbour : adjacencyMatrix.get(startNode)){
                if (neighbour == endNode){
                    path.add(endNode);
                    return;
                }
                if (visitTracker.contains(neighbour)){
                    continue;
                }
                path.add(neighbour);
                findPath(neighbour, endNode, visitTracker, path, adjacencyMatrix);
                if (!path.contains(endNode)){
                    path.remove(neighbour);
                }else{
                    return;
                }
            }

        }




    }



}
