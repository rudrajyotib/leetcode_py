package interviewbit.solutions;

import java.util.ArrayList;
import java.util.List;

public class MaxDistance {

    public int solve(List<Integer> numbers){
        return new Solution().maximumGap(numbers);
    }


    @SuppressWarnings("InnerClassMayBeStatic")
    public class Solution {
        // DO NOT MODIFY THE LIST. IT IS READ ONLY
        public int maximumGap(final List<Integer> numbers) {

            int size = numbers.size();
            List<Integer> rightMax = new ArrayList<>(numbers.size());
            rightMax.addAll(numbers);
            rightMax.set(size-1, numbers.get(size-1));
            for (int i=size-2;i>=0;i--){
                rightMax.set(i, Math.max(rightMax.get(i), rightMax.get(i+1)));
            }
            int inputListCounter = 0;
            int rightMaxListCounter = 0;
            int maxDiff = 0;
            while (inputListCounter<size && rightMaxListCounter<size){
                if (rightMax.get(rightMaxListCounter) >= numbers.get(inputListCounter)){
                    maxDiff = Math.max(maxDiff, rightMaxListCounter-inputListCounter);
                    rightMaxListCounter++;
                }else{
                    inputListCounter++;
                }
            }
            return maxDiff;
        }
    }

}
