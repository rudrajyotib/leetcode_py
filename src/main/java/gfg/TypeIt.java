package gfg;

/*
https://practice.geeksforgeeks.org/problems/95080eb9efbf7cc5cb4851ddf8d7946e3f212a49/1
 */


public class TypeIt {

    public int solve(String s){
        return new Solution().minOperation(s);
    }

    static class Solution {
        int minOperation(String s) {
            // code here
            for (int i=s.length()-1;i>=1;i--){
                if (isCopy(s, i)){
                    return (i+1)/2 + (s.length()-1-i) + 1;
                }
            }
            return s.length();
        }

        boolean isCopy(String str, int endIndex){
            if (endIndex %2 == 0){
                return false;
            }
            int firstHalf=(endIndex-1)/2;
            int secondHalf = endIndex;
            while (firstHalf>=0){
                if (str.charAt(firstHalf) != str.charAt(secondHalf)){
                    return false;
                }
                --firstHalf;
                --secondHalf;
            }
            return true;
        }

    }

}
