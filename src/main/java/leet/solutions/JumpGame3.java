/*
https://leetcode.com/problems/jump-game-iii/
 */

package leet.solutions;

import java.util.LinkedList;
import java.util.Queue;

public class JumpGame3 {

    public boolean solve(int[] arr, int start){
        return new Solution().canReach(arr, start);
    }


    static class Solution {
        public boolean canReach(int[] arr, int start) {

            if (arr.length == 1 ){
                return arr[0] == 0;
            }
            if (arr[start] == 0 ){
                return true;
            }

            Queue<Integer> bfsQueue = new LinkedList<>();
            boolean[] visited = new boolean[arr.length];

            visited[start] = true;
            bfsQueue.add(start+arr[start]);
            bfsQueue.add(start-arr[start]);

            while (!bfsQueue.isEmpty()){
                Integer index = bfsQueue.poll();
                if (index < 0 || index >= arr.length){
                    continue;
                }
                if (visited[index]){
                    continue;
                }
                visited[index] = true;
                if (arr[index] == 0){
                    return true;
                }
                bfsQueue.add(index+arr[index]);
                bfsQueue.add(index-arr[index]);
            }
            return false;
        }
    }

}
