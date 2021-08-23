package leet.solutions;

/*
https://leetcode.com/problems/product-of-array-except-self/
Leetcode#238
 */

public class ProductOfArrayExceptSelf {

    public int[] solve(int[] nums)
    {
        Solution solution = new Solution();
        return solution.productExceptSelf(nums);
    }

    class Solution {
        public int[] productExceptSelf(int[] nums) {
            if (nums.length == 2)
            {
                return new int[]{nums[1], nums[0]};
            }
            int[] leftMultipliers = new int[nums.length];
            leftMultipliers[0]=1;
            for (int i=1;i<nums.length;i++)
            {
                leftMultipliers[i] = nums[i-1] * leftMultipliers[i-1];
            }
            int[] rightMultipliers = new int[nums.length];
            rightMultipliers[nums.length-1] = 1;
            for (int i=nums.length-2;i>=0;i--)
            {
                rightMultipliers[i] = nums[i+1] * rightMultipliers[i+1];
            }
            int[] result = new int[nums.length];
            for (int i=0;i<nums.length;i++)
            {
                result[i] = leftMultipliers[i] * rightMultipliers[i];
            }
            return result;
        }
    }

}
