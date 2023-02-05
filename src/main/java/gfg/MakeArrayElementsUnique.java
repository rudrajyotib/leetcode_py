package gfg;

/*
https://practice.geeksforgeeks.org/problems/6e63df6d2ebdf6408a9b364128bb1123b5b13450/1
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class MakeArrayElementsUnique {


    public long solve(int[] array){
        return new Solution().minIncrements(array);
    }

    static class Solution {
        public long minIncrements(int[] arr) {
            // Code here

            Map<Integer, Integer> countMap = new HashMap<>();
            for (int i : arr) {
                if (countMap.containsKey(i)){
                    countMap.put(i, countMap.get(i)+1);
                }else{
                    countMap.put(i,1);
                }
            }
            int[][] numberWithCount = new int[countMap.size()][2];
            int counter=0;
            for (Map.Entry<Integer, Integer> countMapEntry : countMap.entrySet()) {
                numberWithCount[counter][0] = countMapEntry.getKey();
                numberWithCount[counter][1] = countMapEntry.getValue();
                ++counter;
            }
            Arrays.sort(numberWithCount, Comparator.comparingInt(o -> o[0]));
            long upgrades = 0;
            for (int i=0;i<=numberWithCount.length-2;i++){
                if (numberWithCount[i][1] > 1){
                    int diffWithNextNum = numberWithCount[i + 1][0] - numberWithCount[i][0] -1 ;
                    int duplicateCount = numberWithCount[i][1] - 1;
                    int toUpgrade = Math.min(duplicateCount, diffWithNextNum);
                    long tempUpgrade = (long) (toUpgrade) *(toUpgrade+1)/2;
                    upgrades += tempUpgrade;
                    upgrades += (long) (duplicateCount - toUpgrade) * (diffWithNextNum+1);
                    numberWithCount[i+1][1] += (duplicateCount - toUpgrade);
                }
            }
            int lastUpgrade = numberWithCount[numberWithCount.length-1][1]-1;
            upgrades += (((long) lastUpgrade * (lastUpgrade+1) / 2));
            return upgrades;
        }
    }
}
