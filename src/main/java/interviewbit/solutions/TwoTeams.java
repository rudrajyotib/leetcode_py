package interviewbit.solutions;

/*
https://www.interviewbit.com/problems/two-teams/
 */

import java.util.*;

public class TwoTeams {

    public boolean possible(int nodes, int[][] edges){
        return new Solution().solve(nodes, edges) == 1;
    }

    public static class Solution {
        public int solve(int A, int[][] B) {



            Map<Integer, List<Integer>> adjacencyList = new HashMap<>(A);
            @SuppressWarnings("unchecked") Set<Integer>[] teams = new Set[2];
            teams[0] = new HashSet<>();
            teams[1] = new HashSet<>();

            for (int i=1;i<=A;i++){
                adjacencyList.put(i, new LinkedList<>());
            }

            for (int[] ints : B) {
                adjacencyList.get(ints[0]).add(ints[1]);
                adjacencyList.get(ints[1]).add(ints[0]);
            }

            boolean[] visitTracker = new boolean[A+1];

            for (Integer node : adjacencyList.keySet()){
                if (!visitTracker[node]){
                    if (canMakeTeam(node, 0, teams, adjacencyList, visitTracker)){
                        return 0;
                    }
                }
            }

//            for (Integer node : adjacencyList.keySet()){
//                if (!visitTracker[node]){
//                    if (isCycleInUndirectedGraph(node, visitTracker, adjacencyList, -1)){
//                        return 0;
//                    }
//                }
//            }

            return 1;
        }


        private boolean canMakeTeam(int nodeId, int teamId, Set<Integer>[] teams, Map<Integer, List<Integer>> adjacencyList, boolean[] visitTracker){

            if (visitTracker[nodeId]){
                return !teams[teamId].contains(nodeId);
            }else{
                visitTracker[nodeId] = true;
                teams[teamId].add(nodeId);
                for (Integer neighbor : adjacencyList.get(nodeId)){
                    if (canMakeTeam(neighbor, (teamId + 1) % 2, teams, adjacencyList, visitTracker)){
                        return true;
                    }
                }
            }
            return false;
        }

//        private boolean isCycleInUndirectedGraph( int nodeId, boolean[] visitTracker, Map<Integer, List<Integer>> adjacencyList, int parent){
//            visitTracker[nodeId] = true;
//            for (Integer neighbor : adjacencyList.get(nodeId)){
//                if (!visitTracker[neighbor]){
//                    if (isCycleInUndirectedGraph(neighbor, visitTracker, adjacencyList, nodeId)){
//                        return true;
//                    }
//                }else{
//                    if (parent != neighbor){
//                        return true;
//                    }
//                }
//            }
//            return false;
//        }



    }


}
