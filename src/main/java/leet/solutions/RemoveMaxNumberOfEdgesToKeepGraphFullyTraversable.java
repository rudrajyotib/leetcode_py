/*
https://leetcode.com/problems/remove-max-number-of-edges-to-keep-graph-fully-traversable
 */

package leet.solutions;

public class RemoveMaxNumberOfEdgesToKeepGraphFullyTraversable {


    public int solve(int n, int[][] edges){
        return new Solution().maxNumEdgesToRemove(n, edges);
    }

    static class Solution {

        static class UnionFind{
            private int connectedEdges;
            private final int[] parent;
            private final int[]componentSize;


            UnionFind(int size) {
                this.parent = new int[size+1];
                for (int i=1;i<=size;i++){
                    this.parent[i] = i;
                }
                this.connectedEdges = size;
                this.componentSize = new int[size + 1];
                for (int i=1;i<=size;i++){
                    this.componentSize[i] = 1;
                }
            }

            public int find(int node){
                if (parent[node] == node){
                    return node;
                }
                parent[node] = find(parent[node]);
                return parent[node];
            }

            public boolean connect(int edge1, int edge2){
                if (find(edge1) == find(edge2)){
                    return false;
                }
                if (componentSize[edge1] > componentSize[edge2]) {
                    componentSize[edge1] += componentSize[edge2];
                    parent[edge2] = parent[edge1];
                } else {
                    componentSize[edge2] += componentSize[edge1];
                    parent[edge1] = parent[edge2];
                }

                --connectedEdges;
                return true;
            }

            public boolean isNotAllConnected(){
                return connectedEdges != 1;
            }
        }

        public int maxNumEdgesToRemove(int n, int[][] edges) {

            UnionFind alice = new UnionFind(n);
            UnionFind bob = new UnionFind(n);
            int connectionsNeeded = 0;
            for (int[] edge : edges) {
                if (edge[0] == 3){
                    boolean connectionNeededForAlice = alice.connect(edge[1], edge[2]);
                    boolean connectionNeededForBob = bob.connect(edge[1], edge[2]);
                    if (connectionNeededForAlice || connectionNeededForBob){
                        ++connectionsNeeded;
                    }
                }
            }
            for (int[] edge : edges) {
                if (edge[0] == 1){
                    boolean connectionNeededForAlice = alice.connect(edge[1], edge[2]);
                    if (connectionNeededForAlice){
                        ++connectionsNeeded;
                    }
                }
                if (edge[0] == 2){
                    boolean connectionNeededForBob = bob.connect(edge[1], edge[2]);
                    if (connectionNeededForBob){
                        ++connectionsNeeded;
                    }
                }
            }
            if (alice.isNotAllConnected() || bob.isNotAllConnected()){
                return -1;
            }

            return edges.length - connectionsNeeded;
        }
    }

}
