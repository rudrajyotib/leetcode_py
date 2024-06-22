package leet.solutions;

import java.util.HashMap;
import java.util.Map;

public class CountNumberOfNiceSubarrays {

    public int solve(int[] nums, int k){
        return new Solution().numberOfSubarrays(nums, k);
    }


    static class Solution {
        public int numberOfSubarrays(int[] nums, int k) {

            int sum = 0;
            int answer = 0;
            Map<Integer, Integer> prefixSumMap = new HashMap<>();
            prefixSumMap.put(0, 1);
            for (int num: nums){
                if (num % 2 == 1){
                    sum+=1;
                }
                int diff = sum -k;
                answer += prefixSumMap.getOrDefault(diff, 0);
                prefixSumMap.put(sum, prefixSumMap.getOrDefault(sum, 0)+1);
            }

            return answer;
        }
    }

}
