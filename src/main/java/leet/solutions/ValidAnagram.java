package leet.solutions;

/*
https://leetcode.com/problems/valid-anagram/
Leetcode#242
 */


import java.util.Arrays;

public class ValidAnagram {

    public boolean solve(String s, String t)
    {
        Solution solution = new Solution();
        return solution.isAnagram(s, t);
    }

    class Solution {
        public boolean isAnagram(String s, String t) {

            if (s.length() != t.length())
            {
                return false;
            }

            int[] left = new int[26];
            int[] right = new int[26];

            for (int i=0;i<s.length();i++)
            {
                left[s.charAt(i)-97] += 1;
                right[t.charAt(i)-97] += 1;
            }


            return Arrays.equals(left, right);
        }
    }

}
