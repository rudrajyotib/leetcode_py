package interviewbit.solutions;

/*
https://www.interviewbit.com/problems/longest-valid-parentheses/
 */

import java.util.Stack;

public class LongestValidParentheses {

    public int solve(String input) {
        return new Solution().longestValidParentheses(input);
    }

    static class Solution {
        public int longestValidParentheses(String input) {

            int longestStreak = 0;
            int currentStreak = 0;
            Stack<Integer> holder = new Stack<>();
            boolean lastActionClose = false;

            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == '(') {
                   if (lastActionClose){
                       holder.push(currentStreak);
                   }else{
                       holder.push(0);
                   }
                   currentStreak = 0;
                    lastActionClose = false;

                } else {
                    if (holder.isEmpty()) {
                        currentStreak = 0;
                    } else {
                        currentStreak = holder.pop() + currentStreak + 2;
                        longestStreak = Math.max(longestStreak, currentStreak);
                    }
                    lastActionClose = true;
                }
            }

            return longestStreak;
        }
    }


}
