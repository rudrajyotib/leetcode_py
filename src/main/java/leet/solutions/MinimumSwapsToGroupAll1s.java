/*
https://leetcode.com/problems/minimum-swaps-to-group-all-1s-together-ii
 */

package leet.solutions;

public class MinimumSwapsToGroupAll1s {

    public int solve(int[] nums){
        return new Solution().minSwaps(nums);
    }

    static class Solution {
        public int minSwaps(int[] nums) {
            int oneCount = 0;
            for(int num: nums){
                if (num == 1){
                    ++oneCount;
                }
            }
            if (oneCount == 0 || oneCount == 1){
                return 0;
            }
            int minSwapCount = Integer.MAX_VALUE;
            int[] oneCountFromLeft = new int[oneCount];
            oneCountFromLeft[0] = nums[0] == 1 ? 1 : 0;
            for (int i=1;i<oneCount;i++){
                oneCountFromLeft[i] = oneCountFromLeft[i-1];
                if (nums[i] == 1){
                    ++oneCountFromLeft[i];
                }
            }
            int ctr = 0;
            int oneCountFromRight = 0;
            int index = nums.length - 1;
            while (ctr<oneCount-1){
                if (nums[index-ctr] == 1){
                    ++oneCountFromRight;
                }
                ++ctr;
                int onesInCircle = oneCountFromRight + oneCountFromLeft[oneCount - ctr - 1];
                int swaps = oneCount - onesInCircle;
                minSwapCount = Math.min(minSwapCount, swaps);
            }
            int slidingWindowEndPoint = oneCount - 1;
            int onesInWindow = oneCountFromLeft[oneCount-1];
            int swaps = oneCount - onesInWindow;
            minSwapCount = Math.min(minSwapCount, swaps);
            for (int i=slidingWindowEndPoint+1;i<nums.length;i++){
                if (nums[i-oneCount] == 1){
                    --onesInWindow;
                }
                if (nums[i] == 1){
                    ++onesInWindow;
                }
                swaps = oneCount - onesInWindow;
                minSwapCount = Math.min(minSwapCount, swaps);
            }
            return minSwapCount;
        }
    }
}
