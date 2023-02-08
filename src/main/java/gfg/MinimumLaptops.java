package gfg;

/*
https://practice.geeksforgeeks.org/problems/af49b143a4ead583e943ca6176fbd7ea55b121ae/1
 */


import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumLaptops {

    public int solve(int[] start, int[] end){
        return new Solution().minLaptops(start.length, start, end);
    }


    static class Solution {
        public int minLaptops(int n, int[] start, int[] end) {
            // code here
            int[][] startAndEnd = new int[n][2];

            for (int i=0;i<n;i++){
                startAndEnd[i][0] = start[i];
                startAndEnd[i][1] = end[i];
            }

            Arrays.sort(startAndEnd, Comparator.comparingInt(o -> o[0]));

            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Integer::compare) ;

            int laptops = 0;

            for (int[] task : startAndEnd) {
                if (!priorityQueue.isEmpty() && priorityQueue.peek() <= task[0]){
                    priorityQueue.remove();
                }
                priorityQueue.add(task[1]);
                laptops = Math.max(priorityQueue.size(), laptops);
            }

            return laptops;
        }
    }

}
