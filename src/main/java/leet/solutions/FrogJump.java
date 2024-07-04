/*
https://leetcode.com/problems/frog-jump/submissions
 */

package leet.solutions;

import java.util.*;

public class FrogJump {

    public boolean solve(int[] stones){
        return new Solution().canCross(stones);
    }

    static class Solution {
        public boolean canCross(int[] stones) {

            if (stones.length == 1){
                return true;
            }
            if (stones.length == 2){
                return stones[1] == 1;
            }
            if (stones[1] != 1){
                return false;
            }

            int n = stones.length;
            Queue<Integer[]> queue = new LinkedList<>();
            queue.add(new Integer[]{2,3});
            queue.add(new Integer[]{2,4});
            Map<Integer, Set<Integer>> stoneSet = new HashMap<>(stones.length, 1);
            for (int stone : stones) {
                stoneSet.put(stone, new HashSet<>());
            }

            while (!queue.isEmpty()){
                Integer[] jump = queue.poll();
                if (jump[0] == 0){
                    continue;
                }
                if(!stoneSet.containsKey(jump[1])){
                    continue;
                }
                if (jump[1] == stones[n-1]){
                    return true;
                }
                if (stoneSet.get(jump[1]).contains(jump[0])){
                    continue;
                }
                stoneSet.get(jump[1]).add(jump[0]);

                queue.add(new Integer[]{jump[0]+1, jump[1]+(jump[0]+1)});
                queue.add(new Integer[]{jump[0]-1, jump[1]+(jump[0]-1)});
                queue.add(new Integer[]{jump[0], jump[1]+(jump[0])});
            }

            return false;
        }
    }
}
