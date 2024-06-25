/*
https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 */


package leet.solutions;

public class TwoSum2SortedArray {

    public int[] solve(int[] numbers, int target){
        return new Solution().twoSum(numbers, target);
    }

    static class Solution {
        public int[] twoSum(int[] numbers, int target) {
            int leftPointer = 0;
            int rightPointer = numbers.length - 1;
            while (leftPointer < rightPointer){
                int sum = numbers[leftPointer]+numbers[rightPointer];
                if (sum== target){
                    break;
                }
                if (sum > target){
                    --rightPointer;
                }else{
                    ++leftPointer;
                }
            }
            return new int[]{leftPointer+1, rightPointer+1};

        }
    }
}
