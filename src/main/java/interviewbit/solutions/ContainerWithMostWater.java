package interviewbit.solutions;

/*
https://www.interviewbit.com/problems/container-with-most-water/
 */

public class ContainerWithMostWater {


    public int solve(int[] walls){
        return new Solution().maxArea(walls);
    }

    public static class Solution {
        public int maxArea(int[] walls) {

            int maxArea = 0;
            int leftPointer = 0;
            int rightPointer = walls.length-1;

            while (leftPointer < rightPointer){
                maxArea = Math.max(maxArea, Math.min(walls[leftPointer], walls[rightPointer]) * (rightPointer-leftPointer));
                if (walls[leftPointer] < walls[rightPointer]){
                    ++leftPointer;
                }else{
                    --rightPointer;
                }
            }

            return maxArea;
        }
    }

}
