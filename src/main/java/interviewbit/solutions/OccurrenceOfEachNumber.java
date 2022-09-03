package interviewbit.solutions;

/*
https://www.interviewbit.com/problems/occurence-of-each-number/
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OccurrenceOfEachNumber {

    public int[] solve(int[] nums){
        return new Solution().findOccurences(nums);
    }

    static class Solution {
        public int[] findOccurences(int[] A) {

            Map<Integer, Frequency> frequencyMap = new HashMap<>();
            for (int a:A){
                if (frequencyMap.containsKey(a)){
                    frequencyMap.get(a).increment();
                }else{
                    frequencyMap.put(a, new Frequency());
                }
            }
            int[] result = new int[frequencyMap.size()];
            List<Integer> resultList = new ArrayList<>();
                    frequencyMap
                            .keySet()
                            .stream()
                            .sorted(Integer::compare).map(integer -> frequencyMap.get(integer).val)
                            .forEach(resultList::add);

            for (int i=0;i<resultList.size();i++){
                result[i] = resultList.get(i);
            }


            return result;
        }

        static class Frequency{
            int val = 1;
            void increment(){
                ++val;
            }
        }
    }


}
