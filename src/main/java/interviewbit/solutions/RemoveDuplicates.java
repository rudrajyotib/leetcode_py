package interviewbit.solutions;

/*
https://www.interviewbit.com/problems/remove-duplicates-from-sorted-array/
 */


import java.util.ArrayList;

public class RemoveDuplicates {

    public int solve(ArrayList<Integer> input){
        return new Solution().removeDuplicates(input);
    }

    @SuppressWarnings("InnerClassMayBeStatic")
    public class Solution{
        public int removeDuplicates(ArrayList<Integer> input){

            int uniqueCounter = 0;
            for (int i=0;i<input.size()-1;i++){
                if (!input.get(i).equals(input.get(i + 1))){
                    input.set(uniqueCounter, input.get(i));
                    ++uniqueCounter;
                }
            }
            input.set(uniqueCounter, input.get(input.size()-1));

            return  uniqueCounter+1;
        }
    }

}
