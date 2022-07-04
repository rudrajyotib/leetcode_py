package interviewbit.solutions;

/*
https://www.interviewbit.com/problems/longest-common-prefix/
 */

import java.util.ArrayList;
import java.util.Comparator;

public class LongestCommonPrefix {


    public String solve(ArrayList<String> input) {
        return new Solution().longestCommonPrefix(input);
    }

    @SuppressWarnings("InnerClassMayBeStatic")
    public class Solution {
        public String longestCommonPrefix(ArrayList<String> input) {

            StringBuilder stringBuilder = new StringBuilder();
            input.sort(Comparator.comparingInt(String::length));
            for (int i = 0; i < input.get(0).length(); i++) {
                for (int j = 1; j < input.size(); j++) {
                    if (input.get(0).charAt(i) != input.get(j).charAt(i)) {
                        return stringBuilder.toString();
                    }
                }
                stringBuilder.append(input.get(0).charAt(i));
            }
            return stringBuilder.toString();
        }
    }


}
