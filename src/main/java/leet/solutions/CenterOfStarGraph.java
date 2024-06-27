package leet.solutions;

public class CenterOfStarGraph {

    public int solve(int[][] edges){
        return new Solution().findCenter(edges);
    }

    static class Solution {
        public int findCenter(int[][] edges) {
            if (edges[0][0] == edges[1][0]){
                return edges[0][0];
            }else if (edges[0][0] == edges[1][1]){
                return edges[0][0];
            }else {
                return edges[0][1];
            }
        }
    }
}
