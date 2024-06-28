/*
https://leetcode.com/problems/maximum-total-importance-of-roads
 */

package leet.solutions;

import java.util.PriorityQueue;

public class MaximumTotalImportanceOfRoads {


    public long solve(int n, int[][] roads){
        return new Solution().maximumImportance(n, roads);
    }

    static class Solution {
        public long maximumImportance(int n, int[][] roads) {

            int[] roadCounts = new int[n];
            for (int[] road : roads) {
                ++roadCounts[road[0]];
                ++roadCounts[road[1]];
            }
            PriorityQueue<CityWithRoadCount> priorityQueue = new PriorityQueue<>();
            for (int i=0;i<n;i++){
                priorityQueue.offer(new CityWithRoadCount(i, roadCounts[i]));
            }
            CityWithRoadCount[] indexedCity = new CityWithRoadCount[n];
            for (int i=n;i>0;i--){
                CityWithRoadCount city = priorityQueue.poll();
                assert city != null;
                city.weight = i;
                indexedCity[city.cityIndex] = city;
            }
            long result = 0L;
            for (int[] road : roads) {
                result += indexedCity[road[0]].weight;
                result += indexedCity[road[1]].weight;
            }

            return result;
        }

        @SuppressWarnings("rawtypes")
        static class CityWithRoadCount implements Comparable{
            int cityIndex;
            int roadCount;
            int weight=0;

            public CityWithRoadCount(int cityIndex, int roadCount) {
                this.cityIndex = cityIndex;
                this.roadCount = roadCount;
            }

            @Override
            public int compareTo(Object o) {
                return Integer.compare( ((CityWithRoadCount)o).roadCount, this.roadCount);
            }
        }
    }

}
