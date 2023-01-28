package gfg;

public class MaximumWeightNode {

    public int solve(int nodes, int[] edges){
        return new Solution().maxWeightCell(nodes, edges);
    }


    static class Solution{
        public int maxWeightCell(int nodes, int[] edge){

            int[] weights = new int[nodes];
            for (int i=0;i<nodes;i++){
                if (edge[i] == -1){
                    continue;
                }
                weights[edge[i]] += i;
            }
            int maxWeight=-1;
            int maxWeightNode=0;
            for (int i=0;i<nodes;i++){
                if (weights[i]>=maxWeight){
                    maxWeightNode=i;
                    maxWeight=weights[i];
                }
            }
            return maxWeightNode;
        }


    }
}
