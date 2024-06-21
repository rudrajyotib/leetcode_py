/*
https://leetcode.com/problems/minimum-increment-to-make-array-unique/description
 */


package leet.solutions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MinimumIncrementToMakeArrayUnique {

    public int solve(int[] nums){
        return new Solution().minIncrementForUnique(nums);
    }

    static class Solution {
        public int minIncrementForUnique(int[] nums) {
            Arrays.sort(nums);
            int count = 0;
            for (int i=1;i<nums.length;i++){
                if (nums[i]<=nums[i-1]){
                    count += (nums[i-1] - nums[i])+1;
                }
                nums[i] = nums[i-1] + 1;
            }
            return count;
        }

        @SuppressWarnings("unused")
        private int tle(int[] nums) {
            Arrays.sort(nums);
            int totalMoves = 0;
            List<Integer[]> uniqueNumsList = new LinkedList<>();
            uniqueNumsList.add(new Integer[]{nums[0], 1});
            for (int i = 1; i< nums.length; i++){
                if (uniqueNumsList.get(uniqueNumsList.size()-1)[0] == nums[i]){
                    ++uniqueNumsList.get(uniqueNumsList.size()-1)[1];
                }else{
                    uniqueNumsList.add(new Integer[]{nums[i], 1});
                }
            }
            for (int i=0;i<=uniqueNumsList.size()-2;i++){
                if (uniqueNumsList.get(i)[1] > 1){
                    Integer[] nextNum = uniqueNumsList.get(i+1);
                    int emptyPlaces = nextNum[0] - uniqueNumsList.get(i)[0] -1;
                    if (emptyPlaces >= (uniqueNumsList.get(i)[1]-1) ){
                        int n = uniqueNumsList.get(i)[1] - 1;
                        totalMoves += n * (n+1) /2;
                    }else {
                        int moves = emptyPlaces * (emptyPlaces + 1) / 2;
                        totalMoves += moves;
                        totalMoves += (uniqueNumsList.get(i)[1]-emptyPlaces -1) * (emptyPlaces+1);
                        uniqueNumsList.get(i+1)[1] += (uniqueNumsList.get(i)[1]-emptyPlaces -1);
                    }
                }
            }
            int repeatAtLastNumber = uniqueNumsList.get(uniqueNumsList.size()-1)[1];
            totalMoves += (repeatAtLastNumber-1) * repeatAtLastNumber / 2;

            return totalMoves;
        }
    }

}
