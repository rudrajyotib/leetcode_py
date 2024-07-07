/*
https://leetcode.com/problems/min-cost-to-connect-all-points
 */

package leet.solutions;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MinCostToConnectAllPoints {

    public int solve(int[][] points){
        return new Solution().minCostConnectPoints(points);
    }

    static class Solution {
        public int minCostConnectPoints(int[][] points) {
            boolean[] connected = new boolean[points.length];
            PriorityQueue<Integer[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
            for (int i=0;i<points.length;i++){
                for (int j=i+1;j<points.length;j++){
                    int dist = Math.abs(points[i][0]-points[j][0])+
                            Math.abs(points[i][1]-points[j][1]);
                    priorityQueue.offer(new Integer[]{i,j,dist});
                }
            }
            int cost = 0;
            while (!priorityQueue.isEmpty()){
                Integer[] pointDist = priorityQueue.poll();
                if (connected[pointDist[0]] && connected[pointDist[1]]){
                    continue;
                }
                cost += pointDist[2];
                connected[pointDist[0]] = true;
                connected[pointDist[1]] = true;
            }
            return cost;
        }
    }

}
