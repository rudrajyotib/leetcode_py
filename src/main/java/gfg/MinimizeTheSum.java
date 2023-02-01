package gfg;

/*
https://practice.geeksforgeeks.org/problems/86e609332c9ef4f6b8aa79db11a6c0808c4a1bca/1
 */

import java.util.PriorityQueue;

public class MinimizeTheSum {

    public long solve(int[] arr){
        return new Solution().minimizeSum(arr);
    }

    static class Solution {
        long minimizeSum(int[] arr) {
            // code here
            long result = 0;
            PriorityQueue<Long> priorityQueue = new PriorityQueue<>();
            for (int element : arr) {
                priorityQueue.offer((long)element);
            }
            while (priorityQueue.size() >= 2){
                long num1 = priorityQueue.remove();
                long num2 = priorityQueue.remove();
                long temp = num1 + num2;
                result += temp;
                priorityQueue.offer(temp);
            }
            return result;
        }
    }

}
