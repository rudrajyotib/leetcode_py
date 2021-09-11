package leet.solutions;

/*
https://leetcode.com/problems/sort-colors/
Leetcode#75
 */

public class SortColors {

    public void solve(int[] nums)
    {
        Solution solution = new Solution();
        solution.sortColors(nums);
    }

    @SuppressWarnings({"ConstantConditions", "InnerClassMayBeStatic"})
    class Solution {
        public void sortColors(int[] nums) {
            int[] colors = new int[3];
            for (int num : nums) {
                ++colors[num];
            }
            int zeroCount = colors[0];
            int oneCount = colors[0] + colors[1];
            for (int i=1;i<=nums.length;i++)
            {
                if (i <= zeroCount)
                {
                    nums[i-1] = 0;
                }else if ( i>zeroCount && (i<=oneCount))
                {
                    nums[i-1] = 1;
                }else
                {
                    nums[i-1] = 2;
                }
            }
        }
    }

}
