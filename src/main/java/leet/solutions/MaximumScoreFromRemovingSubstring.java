/*
https://leetcode.com/problems/maximum-score-from-removing-substrings
 */

package leet.solutions;

import java.util.Stack;

public class MaximumScoreFromRemovingSubstring {

    public int solve(String s, int x, int y){
        return new Solution().maximumGain(s, x, y);
    }


    static class Solution {
        public int maximumGain(String s, int x, int y) {
            StackAndScore stackAndScore = new StackAndScore();
            Stack<Character> stack = new Stack<>();
            for (Character c : s.toCharArray()){
                stack.push(c);
            }
            stackAndScore.characters = stack;
            if (x > y ){
                removeAb(stackAndScore, x);
            }else{
                removeBa(stackAndScore, y);
            }
            if (x > y){
                removeBa(stackAndScore, y);
            }else{
                removeAb(stackAndScore, x);
            }
            return stackAndScore.score;
        }


        private void removeAb(StackAndScore stackAndScore, int increment){
            Stack<Character> tempStack = new Stack<>();
            while (stackAndScore.characters.size() > 1){
                if (stackAndScore.characters.peek() == 'b'){
                    stackAndScore.characters.pop();
                    if (stackAndScore.characters.peek() == 'a'){
                        stackAndScore.increment(increment);
                        stackAndScore.characters.pop();
                        if (!tempStack.isEmpty()){
                            stackAndScore.characters.push(tempStack.pop());
                        }
                    }else {
                        tempStack.push('b');
                    }
                }else{
                    tempStack.push(stackAndScore.characters.pop());
                }
            }
            while (!tempStack.isEmpty()){
                stackAndScore.characters.push(tempStack.pop());
            }
        }

        private void removeBa(StackAndScore stackAndScore, int increment){
            Stack<Character> tempStack = new Stack<>();
            while (stackAndScore.characters.size() > 1){
                if (stackAndScore.characters.peek() == 'a'){
                    stackAndScore.characters.pop();
                    if (stackAndScore.characters.peek() == 'b'){
                        stackAndScore.increment(increment);
                        stackAndScore.characters.pop();
                        if (!tempStack.isEmpty()){
                            stackAndScore.characters.push(tempStack.pop());
                        }
                    }else {
                        tempStack.push('a');
                    }
                }else{
                    tempStack.push(stackAndScore.characters.pop());
                }
            }
            while (!tempStack.isEmpty()){
                stackAndScore.characters.push(tempStack.pop());
            }
        }

        static class StackAndScore {
            Stack<Character> characters;
            int score;

            void increment(int x){
                score+=x;
            }

        }

    }

}
