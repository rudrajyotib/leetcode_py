package gfg;

/*
https://practice.geeksforgeeks.org/problems/first-element-to-occur-k-times5150/1
 */


public class FirstElementToAppearKTimes {


    public int solve(int[] array, int times){
        return new Solution().firstElementKTime(array, times);
    }

    static class Solution
    {
        public int firstElementKTime(int[] a, int k) {
            int[] tracker = new int[201];
            for (int j : a) {
                ++tracker[j];
                if (tracker[j] == k) {
                    return j;
                }
            }
            return -1;
        }
    }

}
