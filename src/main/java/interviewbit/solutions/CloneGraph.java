package interviewbit.solutions;

/*
https://www.interviewbit.com/problems/clone-graph/
 */

import java.util.*;

public class CloneGraph {


    public UndirectedGraphNode solve(UndirectedGraphNode node){
        return new Solution().cloneGraph(node);
    }


    @SuppressWarnings("InnerClassMayBeStatic")
    class Solution {
        public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {

            if (node == null){
                return null;
            }
            if (node.neighbors.isEmpty()){
                return new UndirectedGraphNode(node.label);
            }
            Queue<UndirectedGraphNode> bfsQueue = new LinkedList<>();
            bfsQueue.add(node);
            Map<Integer, UndirectedGraphNode > originalGraphMap = new HashMap<>();
            while (!bfsQueue.isEmpty()){
                UndirectedGraphNode nodeFromQueue = bfsQueue.poll();
                if (!originalGraphMap.containsKey(nodeFromQueue.label)){
                    originalGraphMap.put(nodeFromQueue.label, nodeFromQueue);
                    bfsQueue.addAll(nodeFromQueue.neighbors);
                }
            }

            Map<Integer, UndirectedGraphNode> clonedGraphMap = new HashMap<>(originalGraphMap.size());

            for (Integer integer : originalGraphMap.keySet()) {
                UndirectedGraphNode clonedNode;
                if (clonedGraphMap.containsKey(integer)){
                     clonedNode= clonedGraphMap.get(integer);
                }else{
                    clonedNode = new UndirectedGraphNode(integer);
                    clonedGraphMap.put(integer, clonedNode);
                }
                for (UndirectedGraphNode neighbor: originalGraphMap.get(integer).neighbors){
                    UndirectedGraphNode neighborNode;
                    if (clonedGraphMap.containsKey(neighbor.label)){
                        neighborNode = clonedGraphMap.get(neighbor.label);
                    }else{
                        neighborNode = new UndirectedGraphNode(neighbor.label);
                        clonedGraphMap.put(neighbor.label, neighborNode);
                    }
                    clonedNode.neighbors.add(neighborNode);
                }
            }
            return clonedGraphMap.get(node.label);
        }
    }


    static class UndirectedGraphNode {
          int label;
          List<UndirectedGraphNode> neighbors;
          UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<>(); }
      }
 
    
}
