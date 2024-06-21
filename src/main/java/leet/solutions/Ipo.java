/*
https://leetcode.com/problems/ipo/description
 */

package leet.solutions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Ipo {


    public int solve(int k, int w, int[] profits, int[] capital){
        return new Solution().findMaximizedCapital(k, w, profits, capital);
    }

    static class Solution {

        public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {

            int[][] projects = new int[profits.length][2];
            for (int i=0;i<profits.length;i++){
                projects[i] = new int[]{capital[i], profits[i]};
            }
            Arrays.sort(projects, Comparator.comparingInt(o -> o[0]));
            int projectIndex = 0;
            int totalCapital = w;

            PriorityQueue<Integer> maxProfitQueue = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));

            for (int i=0;i<k;i++){
                while (projectIndex<projects.length && projects[projectIndex][0] <= totalCapital ){
                    maxProfitQueue.add(projects[projectIndex][1]);
                    ++projectIndex;
                }
                if (maxProfitQueue.isEmpty()){
                    return totalCapital;
                }
                totalCapital += maxProfitQueue.poll();
            }
            return totalCapital;
        }
    }

}
