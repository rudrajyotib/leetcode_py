/*
https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses/
 */

package leet.solutions;

import java.util.Stack;

public class ReverseSubstringBetweenEachPairOfParentheses {

    public String solve(String s){
        return new Solution().reverseParentheses(s);
    }

    static class Solution {
        public String reverseParentheses(String s) {
            StringBuilder resultBuilder = new StringBuilder();
            Stack<Integer> stack = new Stack<>();
            int resultIndex = 0;
            for (int i=0;i<s.length();i++){

                    if (s.charAt(i)== '('){
                        stack.push(resultIndex);
                    }else if (s.charAt(i)== ')'){
                        int prevIndex = stack.pop();
                        String reverse = new StringBuilder(resultBuilder.substring(prevIndex)).reverse().toString();
                        resultBuilder.replace(prevIndex, resultBuilder.length(), reverse);
                    }else{
                        resultBuilder.append(s.charAt(i));
                        ++resultIndex;
                    }

            }
            return resultBuilder.toString();
        }
    }
}
