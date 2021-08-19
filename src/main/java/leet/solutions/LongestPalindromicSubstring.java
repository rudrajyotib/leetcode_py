package leet.solutions;

/*
https://leetcode.com/problems/longest-palindromic-substring/
Leetcode#5
 */


public class LongestPalindromicSubstring {

}

class Solution {
    public String longestPalindrome(String s) {

        if (s.isEmpty())
        {
            return "";
        }
        if (s.length() == 1)
        {
            return s.substring(0,1);
        }

        int startIndex = 0;
        int endIndex = 0;
        int maxLength = 0;

        for (int i=1; i<s.length(); i++)
        {
            if (   (i < s.length()-1 )  &&   (s.charAt(i-1) == s.charAt(i+1))   )
            {
                int[] expansion = expand(i-1, i+1, s);
                if ( (expansion[1] - expansion[0]) > maxLength)
                {
                    startIndex = expansion[0];
                    endIndex = expansion[1];
                    maxLength = endIndex - startIndex;
                }
            }
            if (s.charAt(i) == s.charAt(i-1))
            {
                int[] expansion = expand(i-1, i, s);
                if ( (expansion[1] - expansion[0]) > maxLength)
                {
                    startIndex = expansion[0];
                    endIndex = expansion[1];
                    maxLength = endIndex - startIndex;
                }
            }
        }
        if (maxLength == 0){
            return s.substring(0,1);
        }
        return s.substring(startIndex, endIndex+1);
    }

    private int[] expand(int startIndex, int endIndex, String input)
    {
        boolean expansionPossible = true;
        while (expansionPossible)
        {
            if (startIndex>0 && endIndex<input.length()-1)
            {
                if (input.charAt(startIndex-1) == input.charAt(endIndex+1))
                {
                    --startIndex;
                    ++endIndex;
                }
                else
                {
                    expansionPossible = false;
                }
            }else
            {
                expansionPossible=false;
            }
        }
        return new int[]{startIndex, endIndex};
    }
}