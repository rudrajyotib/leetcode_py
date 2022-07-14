package interviewbit.solutions;

/*
https://www.interviewbit.com/problems/remove-duplicates-from-sorted-array-ii/
 */

import java.util.ArrayList;
import java.util.Objects;

public class RemoveDuplicates2 {

    public int solve(ArrayList<Integer> list) {
        return new Solution().removeDuplicates(list);
    }

    public static class Solution {
        public int removeDuplicates(ArrayList<Integer> a) {

            if (a.size() < 3) {
                return a.size();
            }

            int uniqueCounter = 1;
            int streak = 1;
            for (int i = 1; i < a.size() ; i++) {
                if (Objects.equals(a.get(i), a.get(i - 1))) {
                    ++streak;
                } else {
                    streak = 1;
                }
                if (streak <= 2) {
                    a.set(uniqueCounter, a.get(i));
                    ++uniqueCounter;
                }
            }


            return uniqueCounter;
        }
    }

}
