package interviewbit.solutions;

/*
https://www.interviewbit.com/problems/first-missing-integer/
 */


public class FirstMissingInteger {

    public int solve(int[] input){
        return new Solution().firstMissingPositive(input);
    }


    @SuppressWarnings("InnerClassMayBeStatic")
    public class Solution {
        public int firstMissingPositive(int[] input) {

            int startIndexOfPositiveIntegers = 0;

            for (int i=0;i<input.length;i++){
                if (input[i]<=0){
                    int temp = input[startIndexOfPositiveIntegers];
                    input[startIndexOfPositiveIntegers] = input[i];
                    input[i] = temp;
                    ++startIndexOfPositiveIntegers;
                }
            }

            int countOfPositiveIntegers =  input.length - startIndexOfPositiveIntegers;

            if (countOfPositiveIntegers == 0){
                return 1;
            }


            boolean[] positiveIntegerTracker = new boolean[countOfPositiveIntegers];

            for (int i=startIndexOfPositiveIntegers;i<input.length;i++){
                if (input[i]<=countOfPositiveIntegers){
                    positiveIntegerTracker[input[i]-1] = true;
                }
            }

            for (int i=0;i<positiveIntegerTracker.length;i++){
                if (!positiveIntegerTracker[i]){
                    return i+1;
                }
            }


            return countOfPositiveIntegers+1;
        }
    }


}
