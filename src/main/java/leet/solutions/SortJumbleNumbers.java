/*
https://leetcode.com/problems/sort-the-jumbled-numbers
 */
package leet.solutions;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SortJumbleNumbers {

    public int[] solve(int[] mappings, int[] nums){
        return new Solution().sortJumbled(mappings, nums);
    }


    static class Solution {
        public int[] sortJumbled(int[] mapping, int[] nums) {
            List<IndexedConvertedNumber> list = new ArrayList<>(nums.length);
            for (int i=0;i<nums.length;i++){
                list.add(new IndexedConvertedNumber(i, convert(mapping, nums[i]), nums[i]));
            }
            list.sort(IndexedConvertedNumber::compareTo);
            int[] result = new int[nums.length];
            int index = 0;
            for (IndexedConvertedNumber convertedNumber : list) {
                result[index] = convertedNumber.originalNumber;
                ++index;
            }
            return result;
        }

        private int convert(int[] mapping, int number){
            int quotient = number;
            Stack<Integer> stack = new Stack<>();
            if (number == 0 ){
                return mapping[0];
            }
            while (quotient > 0 ){
                stack.push(mapping[quotient%10]);
                quotient = quotient / 10;
            }
            int convert = 0;
            int depth = stack.size()-1;
            while (!stack.isEmpty()){
                convert += (stack.pop())*(int)Math.pow(10, depth);
                --depth;
            }
            return convert;
        }

        @SuppressWarnings("rawtypes")
        static class IndexedConvertedNumber implements Comparable{
            private final int index;
            private final int convertedNumber;
            private final int originalNumber;


            IndexedConvertedNumber(int index, int convertedNumber, int originalNumber) {
                this.index = index;
                this.convertedNumber = convertedNumber;
                this.originalNumber = originalNumber;
            }

            @Override
            public int compareTo(Object o) {
                IndexedConvertedNumber indexedConvertedNumber = (IndexedConvertedNumber) o;
                if (this.convertedNumber == indexedConvertedNumber.convertedNumber){
                    return Integer.compare(this.index, indexedConvertedNumber.index);
                }
                return Integer.compare(this.convertedNumber, indexedConvertedNumber.convertedNumber);
            }
        }

    }

}
