package interviewbit.solutions;

/*
https://www.interviewbit.com/problems/largest-permutation/
 */

import java.util.HashMap;
import java.util.Map;

public class LargestPermutation {

    public int[] solve(int[] elements, int maxSwap){
        return new Solution().solve(elements, maxSwap);
    }

    public static class Solution {
        public int[] solve(int[] A, int B) {

            Map<Integer, Integer> elementsToIndexMap = new HashMap<>();
            for (int i=0;i<A.length;i++){
                elementsToIndexMap.put(A[i], i);
            }
            int index = 0;
            int swaps = 0;
            int maxNumber = A.length;
            while (swaps<B && index<A.length){
                if (A[index] != maxNumber-index ){
                    ++swaps;
                    int temp = A[index];
                    A[index] = maxNumber-index;
                    int tempIndex = elementsToIndexMap.get(maxNumber-index);
                    elementsToIndexMap.put(temp, tempIndex);
                    elementsToIndexMap.put(maxNumber-index, index);
                    A[tempIndex] = temp;
                }
                ++index;
            }

            return A;
        }
    }

}
