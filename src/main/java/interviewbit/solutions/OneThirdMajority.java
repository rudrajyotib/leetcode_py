package interviewbit.solutions;
/*
https://www.interviewbit.com/problems/n3-repeat-number

https://www.geeksforgeeks.org/majority-element/
 */


import java.util.List;

public class OneThirdMajority {

    public int solve(final List<Integer> numbers){
        return new Solution().majority(numbers);
    }

    @SuppressWarnings("InnerClassMayBeStatic")
    class Solution{
        public int majority(final List<Integer> numbers){
            int firstCounter = 0;
            int secondCounter = 0;
            int firstMatch = Integer.MIN_VALUE;
            int secondMatch = Integer.MAX_VALUE;

            for (Integer integer : numbers) {
                if (integer == firstMatch) {
                    firstCounter++;
                } else if (integer == secondMatch) {
                    secondCounter++;
                } else if (firstCounter == 0) {
                    firstMatch = integer;
                    firstCounter++;
                } else if (secondCounter == 0) {
                    secondMatch = integer;
                    secondCounter++;
                } else {
                    firstCounter--;
                    secondCounter--;
                }
            }
            firstCounter=0;
            secondCounter=0;
            for (int number : numbers) {
                if (number == firstMatch) {
                    firstCounter++;
                } else if (number == secondMatch) {
                    secondCounter++;
                }
            }
            if (firstCounter>(numbers.size()/3)){
                return firstMatch;
            }
            if (secondCounter>(numbers.size()/3)){
                return secondMatch;
            }
            return -1;


        }
    }

}
