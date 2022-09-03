package interviewbit.solutions;

/*
https://www.interviewbit.com/problems/largest-number/
 */

import java.util.ArrayList;
import java.util.List;

public class LargestNumber {

    public String solve(int[] input) {
        return new Solution().largestNumber(input);
    }

    static class Solution {
        // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
        public String largestNumber(final int[] A) {

            List<Integer> numList = new ArrayList<>();
            for (int a : A) {
                numList.add(a);
            }

            StringBuilder stringBuilder = new StringBuilder();

            numList.stream()
                    .sorted((o1, o2) -> String.format("%d%d", o2, o1).compareTo(String.format("%d%d", o1, o2)))
                    .forEach(stringBuilder::append);

            String result = stringBuilder.toString();

            for (int i=0;i<result.length();i++){
                if (result.charAt(i)-'0'> 0 ){
                    return result.substring(i);
                }
            }


            return "0";
        }
    }


}
