/*
https://leetcode.com/problems/all-ancestors-of-a-node-in-a-directed-acyclic-graph
 */

package leet.solutions;

import java.util.*;

public class AllAncestorsOfNodeInDirectedAcyclicGraph {

    public List<List<Integer>> solve(int n, int[][] edges){
        return new Solution().getAncestors(n, edges);
    }

    static class Solution {
        public List<List<Integer>> getAncestors(int n, int[][] edges) {
            Map<Integer, List<Integer>> ancestryList = new HashMap<>();
            for (int i=0;i<n;i++){
                ancestryList.put(i, new LinkedList<>());
            }
            for (int[] edge : edges) {
                ancestryList.get(edge[1]).add(edge[0]);
            }
            Map<Integer, Set<Integer>> memo = new HashMap<>();

            for (int i=0;i<n;i++){
                memoisedRecursion(ancestryList, memo, i);
            }

            List<List<Integer>> result = new ArrayList<>(n);

            for (int i=0;i<n;i++){
                if (memo.get(i).isEmpty()){
                    result.add(new LinkedList<>());
                }else{
                    List<Integer> ancestors = new LinkedList<>(memo.get(i));
                    ancestors.sort(Comparator.comparingInt(o -> o));
                    result.add(ancestors);
                }
            }

            return result;
        }

        private void memoisedRecursion(Map<Integer, List<Integer>> ancestryList, Map<Integer, Set<Integer>> memo, int startNode){
            if (memo.containsKey(startNode)){
                return;
            }
            if (ancestryList.get(startNode).isEmpty()){
                memo.put(startNode, new HashSet<>());
                return;
            }
            Set<Integer> ancestralLine = new HashSet<>();
            for (Integer parent: ancestryList.get(startNode)){
                if (!memo.containsKey(parent)){
                    memoisedRecursion(ancestryList, memo, parent);
                }
                ancestralLine.add(parent);
                ancestralLine.addAll(memo.get(parent));
            }
            memo.put(startNode, ancestralLine);

        }

    }

}
