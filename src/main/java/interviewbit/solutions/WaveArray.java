package interviewbit.solutions;

/*
https://www.interviewbit.com/problems/wave-array/
 */

import java.util.ArrayList;
import java.util.Comparator;

public class WaveArray {

    public ArrayList<Integer> solve(ArrayList<Integer> input){
        return new Solution().wave(input);
    }

    @SuppressWarnings("InnerClassMayBeStatic")
    public class Solution {
        public ArrayList<Integer> wave(ArrayList<Integer> input) {
            input.sort(Comparator.comparingInt(o -> o));
            for (int i=0;i<input.size();i=i+2){
                if (i+1<input.size()){
                    Integer temp = input.get(i);
                    Integer next = input.get(i+1);
                    input.set(i+1, temp);
                    input.set(i, next);
                }
            }

            return input;
        }
    }


}
