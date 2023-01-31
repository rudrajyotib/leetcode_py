package gfg;

/*
https://practice.geeksforgeeks.org/problems/fda70097eb2895ecfff269849b6a8aace441947c/1
 */

public class MinimumRepeatString {

    public int solve(String a, String b){
        return new Solution().minRepeats(a, b);
    }

    static class Solution {
        public int minRepeats(String A, String B) {
            // code here
            StringBuilder tempA = new StringBuilder(A);
            int repeat = 1;
            if (A.contains(B)){
                return 1;
            }
            while (tempA.length() < B.length()){
                tempA.append(A);
                ++repeat;
            }
            if (tempA.toString().contains (B)){
                return repeat;
            }
            tempA.append(A);
            if (tempA.toString().contains (B)){
                return repeat + 1;
            }
            return -1;
        }
    }
}
