package interviewbit.solutions;

/*
https://www.interviewbit.com/problems/cycle-in-undirected-graph/
 */

public class CycleInUndirectedGraph {

    public boolean solve(int nodes, int[][] edges){
        return new Solution().solve(nodes, edges) == 1;
    }

    public static class Solution {
        public int solve(int nodes, int[][] edges) {

            Graph graph = new Graph(nodes);
            for (int[] edge: edges){
                if (!graph.addEdge(edge[0], edge[1])){
                    return 1;
                }
            }

            return 0;
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
            final Subset[] parent;

            public Graph(int nodes) {
                this.nodes = nodes;
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
    }


}
