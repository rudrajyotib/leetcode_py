package interviewbit.solutions;

/*
https://www.interviewbit.com/problems/distinct-numbers-in-window/
 */

import java.util.HashMap;
import java.util.Map;

public class DistinctNumbersInWindow {

    public int[] solve(int[] numbers, int window){
        return new Solution().dNums(numbers, window);
    }


    public static class Solution {
        public int[] dNums(int[] numbers, int window) {
            int totalWindowCount = (numbers.length - window) + 1;
            int[] distinctWindow = new int[totalWindowCount];
            Map<Integer, Integer> numberWithIndices = new HashMap<>();
            for (int i=0;i<window;i++){
                numberWithIndices.put(numbers[i], i);
            }
            distinctWindow[0] = numberWithIndices.size();
            for (int i=1;i<totalWindowCount;i++){
                int toGetDeleted = numbers[i-1];
                if (numberWithIndices.get(toGetDeleted) == i-1){
                    numberWithIndices.remove(toGetDeleted);
                }
                numberWithIndices.put(numbers[i+window-1], i+window-1);
                distinctWindow[i] = numberWithIndices.size();
            }
            return distinctWindow;
        }
    }


}
