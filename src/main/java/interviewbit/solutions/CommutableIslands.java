package interviewbit.solutions;

/*
https://www.interviewbit.com/problems/commutable-islands/
Minimum Spanning Tree
Find-Union with rank compression.
 */

import java.util.Arrays;
import java.util.Comparator;

public class CommutableIslands {

    public int solve(int islands, int[][] bridges){
        return new Solution().solve(islands, bridges);
    }

    public static class Solution {
        public int solve(int A, int[][] B) {
            for (int i= 0;i<B.length;i++){
                if (B[i][0] > B[i][1]){
                    int temp = B[i][0];
                    B[i][0] = B[i][1];
                    B[i][1] = temp;
                }
            }
            Arrays.sort(B, Comparator.comparingInt(o -> o[2]));
            Graph graph = new Graph(A, B);
            MinHeap minHeap = new MinHeap(B);
            int connectedNodesCount = 0;
            int totalCost = 0;
            while (connectedNodesCount < A-1){
                int[] edge  = minHeap.getMinCostEdge();
                if (graph.addEdge(edge[0], edge[1])){
                    ++connectedNodesCount;
                    totalCost += edge[2];
                }
                minHeap.replace();
            }
            return totalCost;
        }

        private static class Subset{
            private int parent;
            private int rank;

            public Subset(int parent){
                this.parent = parent;
                this.rank = 0;
            }

            public void updateParent(int parent){
                this.parent = parent;
            }

            public void incrementRank(){
                ++this.rank;
            }
        }

        private static class Graph{
            final int nodes;
            final int[][] edges;
            final Subset[] parent;

            public Graph(int nodes, int[][] edges) {
                this.nodes = nodes;
                this.edges = edges;
                this.parent = new Subset[nodes+1];
                for (int i=0;i<parent.length;i++){
                    this.parent[i] = new Subset(i);
                }
            }

            public boolean addEdge(int nodeStart, int nodeDestination){
                int subsetParentOfStartNode = find(nodeStart);
                int subsetParentOfDestinationNode = find(nodeDestination);
                if (subsetParentOfDestinationNode == subsetParentOfStartNode){
                    return false;
                }
                union(subsetParentOfStartNode, subsetParentOfDestinationNode);
                return true;
            }

            private int find(int index){
                if (this.parent[index].parent != index){
                    this.parent[index].updateParent(  find(this.parent[index].parent) );
                }
                return this.parent[index].parent;
            }

            private void union(int source, int destination){
                int parentOfSource = find(source);
                int parentOfDestination = find(destination);
                if (this.parent[parentOfSource].rank < this.parent[parentOfDestination].rank){
                    this.parent[parentOfSource].updateParent(parentOfDestination);
                }else if (this.parent[parentOfDestination].rank < this.parent[parentOfSource].rank){
                    this.parent[parentOfDestination].updateParent(parentOfSource);
                }else{
                    this.parent[parentOfSource].updateParent(parentOfDestination);
                    this.parent[parentOfDestination].incrementRank();
                }
            }
        }

        private static class MinHeap{
            private final int[][] edges;

            private MinHeap(int[][] edges) {
                this.edges = edges;
                heapify();
            }


            public int[] getMinCostEdge(){
                return edges[0];
            }

            public void replace(){
                edges[0][2] = Integer.MAX_VALUE;
                heapify();
            }

            private void heapify(){
                int lastParentIndex = (edges.length - 2) / 2;
                for (int i=lastParentIndex;i>=0;i--){
                    minHeapify(i);
                }
            }

            private void minHeapify(int index){
                int leftIndex = index*2 + 1;
                int rightIndex = index * 2 + 2;
                if (leftIndex >= edges.length){
                    return;
                }
                if (rightIndex >= edges.length){
                    if (edges[leftIndex][2] < edges[index][2]){
                        swap(index, leftIndex);
                        minHeapify(leftIndex);
                    }
                }else{
                    int swapIndex = edges[leftIndex][2] < edges[rightIndex][2] ? leftIndex : rightIndex;
                    if (edges[swapIndex][2] < edges[index][2]){
                        swap(index, swapIndex);
                        minHeapify(swapIndex);
                    }
                }
            }

            private void swap(int fromIndex, int toIndex){
                int[] temp = edges[fromIndex];
                edges[fromIndex] = edges[toIndex];
                edges[toIndex] = temp;
            }
        }
    }

}
