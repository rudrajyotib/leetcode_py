/*
https://leetcode.com/problems/minimum-deletions-to-make-string-balanced
 */

package leet.solutions;

public class MinimumDeleteToMakeStringBalanced {

    public int solve(String s){
        return new Solution().minimumDeletions(s);
    }


    static class Solution {
        public int minimumDeletions(String s) {
            int l = s.length();
            int[] a = new int[l];
            int[] b = new int[l];
            char[] c = s.toCharArray();
            int allA = 0;
            int allB = 0;
            if (c[0] == 'a'){
                ++allA;
            }else{
                ++allB;
            }
            for (int i=1;i<l;i++){
                a[i] = allA;
                b[i] = allB;
                if (c[i] == 'a'){
                    ++allA;
                }else{
                    ++allB;
                }
            }
            int minDelete = Math.min(allB, allA);
            for (int i=0;i<l;i++){
                int toDelete;
                if (c[i] == 'a'){
                    toDelete = b[i] + (allA - a[i] - 1);
                }else{
                    toDelete = b[i] + (allA - a[i]);
                }
                minDelete = Math.min(minDelete, toDelete);
            }

            return minDelete;
        }
    }

}
