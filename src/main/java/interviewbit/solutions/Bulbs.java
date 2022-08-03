package interviewbit.solutions;

/*
https://www.interviewbit.com/problems/interview-questions/
 */

public class Bulbs {

    public int solve(int[] presentStates){
        return new Solution().bulbs(presentStates);
    }

    public static class Solution {
        public int bulbs(int[] A) {
            return calculateRecursive(A, 0, 0);
        }

        private int calculateRecursive(int[] states, int index, int flipCount){
            if (index >= states.length){
                return 0;
            }
            int presentState = (states[index] + flipCount) % 2;
            if (presentState == 1){
                return calculateRecursive(states, index+1, flipCount);
            }else{
                return 1 + calculateRecursive(states, index+1, flipCount+1);
            }
        }
    }

}
