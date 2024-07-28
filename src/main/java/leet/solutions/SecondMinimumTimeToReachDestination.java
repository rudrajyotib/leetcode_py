/*
https://leetcode.com/problems/second-minimum-time-to-reach-destination
 */

package leet.solutions;

import java.util.*;

public class SecondMinimumTimeToReachDestination {

    public int solve(int n, int[][] edges, int time, int change){
        return new Solution().secondMinimum(n, edges, time, change);
    }

    static class Solution {
        public int secondMinimum(int n, int[][] edges, int time, int change) {
            Map<Integer, List<Integer>> g = new HashMap<>();
            for(int[] e : edges) {
                int u  = e[0], v = e[1];
                g.computeIfAbsent(u, x -> new ArrayList<>()).add(v);
                g.computeIfAbsent(v, x -> new ArrayList<>()).add(u);
            }
            PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
            priorityQueue.offer(new int[]{1, 0});
            int[] uniqueVisit = new int[n+1];
            int[] timeToNode = new int[n+1];
            Arrays.fill(timeToNode, -1);
            while(!priorityQueue.isEmpty()) {
                int[] nodeEntry = priorityQueue.poll();
                int node = nodeEntry[0];
                int timeOfEntry = nodeEntry[1];
                if(timeToNode[node] == timeOfEntry || uniqueVisit[node] >= 2) {
                    continue;
                }
                uniqueVisit[node]++;
                timeToNode[node] = timeOfEntry;
                if(node == n && uniqueVisit[node] == 2) {
                    return timeToNode[node];
                }
                if((timeOfEntry / change) % 2 != 0) {
                    timeOfEntry = (timeOfEntry/change + 1) * change;
                    for(int neighbor : g.getOrDefault(node, new ArrayList<>())) {
                        priorityQueue.offer(new int[]{neighbor, timeOfEntry + time});
                    }
                } else {
                    for(int neighbor : g.getOrDefault(node, new ArrayList<>())) {
                        priorityQueue.offer(new int[]{neighbor, timeOfEntry + time});
                    }
                }
            }
            return -1;
        }
    }
}
