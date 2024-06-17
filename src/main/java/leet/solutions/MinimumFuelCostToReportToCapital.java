/*
https://leetcode.com/problems/minimum-fuel-cost-to-report-to-the-capital/description/
 */

package leet.solutions;

import java.util.LinkedList;
import java.util.List;

public class MinimumFuelCostToReportToCapital {

    public long solve(int[][] roads, int seats) {
        return new Solution().minimumFuelCost(roads, seats);
    }

    static class Solution {
        public long minimumFuelCost(int[][] roads, int seats) {

            int maxIndex = 0;
            for (int[] road : roads) {
                if (road.length == 2) {
                    maxIndex = Math.max(maxIndex, Math.max(road[0], road[1]));
                }
            }
            if (maxIndex == 0) {
                return 0;
            }
            ++maxIndex;

            @SuppressWarnings("unchecked") List<Integer>[] cityConnects = new LinkedList[maxIndex];

            for(int i=0;i<maxIndex;i++){
                cityConnects[i] = new LinkedList<>();
            }

            for (int[] road : roads) {
                cityConnects[road[0]].add(road[1]);
                cityConnects[road[1]].add(road[0]);
            }

            boolean[] visited = new boolean[maxIndex];
            visited[0] = true;

            long totalFuel = 0;

            List<Integer> connectFromCenter = cityConnects[0];

            for (Integer connect : connectFromCenter) {
                totalFuel += calculateFuelRecursive(cityConnects, connect, visited, seats)[0];
            }

            return totalFuel;
        }

        private long[] calculateFuelRecursive(List<Integer>[] cityConnects, int node, boolean[] visited, int seat) {
            long[] result = new long[2];
            visited[node] = true;
            List<Integer> connects = cityConnects[node];
            for (Integer connect : connects) {
                if (!visited[connect]){
                    long[] fromConnect = calculateFuelRecursive(cityConnects, connect, visited, seat);
                    result[0] += fromConnect[0];
                    result[1] += fromConnect[1];
                }
            }
            ++result[1];
            result[0] += ( (result[1]/seat) + (result[1]%seat==0?0:1));

            return result;
        }

    }

}
