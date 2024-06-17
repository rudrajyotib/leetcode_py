/*
https://leetcode.com/problems/append-characters-to-string-to-make-subsequence/description/
 */

package leet.solutions;

public class AppendCharactersToMakeSubsequence {

    public int solve(String s, String t) {
        return new Solution().appendCharacters(s, t);
    }

    static class Solution {
        public int appendCharacters(String s, String t) {
            if (s.contains(t)) {
                return 0;
            }
            int maxMatchFromLeft = 0;

            int pointerS = 0;
            int pointerT = 0;

            while (pointerS < s.length() && pointerT < t.length()) {
                if (s.charAt(pointerS) == t.charAt(pointerT)) {
                    ++pointerT;
                    ++maxMatchFromLeft;
                }
                ++pointerS;
            }

            return (t.length() - maxMatchFromLeft);
        }
    }

}
