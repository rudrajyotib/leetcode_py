package interviewbit.solutions;

/*
https://www.interviewbit.com/problems/file-search/
 */

import java.util.*;

public class FileSearch {

    public int solve(int fileCount, int[][] parentMapping){
        return new Solution().breakRecords(fileCount, parentMapping);
    }

    public static class Solution {
        public int breakRecords(int A, int[][] B) {

            Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
            for (int i=1;i<=A;i++){
                adjacencyList.put(i, new LinkedList<>());
            }
            for (int[] mapping: B){
                adjacencyList.get(mapping[0]).add(mapping[1]);
                adjacencyList.get(mapping[1]).add(mapping[0]);
            }

            Set<Integer> visitTracker = new HashSet<>();
            int setCount = 0;


            for (int i=1;i<=A;i++){
                if (!visitTracker.contains(i)){
                    ++setCount;
                }
                dfs(i, visitTracker, adjacencyList);
            }

            return setCount;
        }

        private void dfs(int startNode, Set<Integer> visitTracker, Map<Integer, List<Integer>> adjacencyList){
            if (visitTracker.contains(startNode)){
                return;
            }
            visitTracker.add(startNode);
            for (int neighbor : adjacencyList.get(startNode)){
                dfs(neighbor, visitTracker, adjacencyList);
            }
        }
    }

}
