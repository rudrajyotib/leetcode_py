package gfg;

/*
https://practice.geeksforgeeks.org/problems/check-if-two-arrays-are-equal-or-not3847/1
 */


import java.util.HashMap;
import java.util.Map;

public class CheckIfTwoArraysAreEqual {

    public boolean solve(long[] first, long[] second){
        return new Solution().check(first,second);
    }


    static class Solution{
        //Function to check if two arrays are equal or not.
        public boolean check(long[] A, long[] B)
        {
            if (A.length != B.length){
                return false;
            }
            Map<Long, Long> map = new HashMap<>(A.length, 1.0f);
            for (long l : A) {
                if (map.containsKey(l)) {
                    map.put(l, map.get(l) + 1);
                } else {
                    map.put(l, 1L);
                }
            }
            for (int i=0;i<A.length;i++){
                if (!map.containsKey(B[i])){
                    return false;
                }
                map.put(B[i], map.get(B[i])-1);
                if (map.get(B[i]) == 0){
                    map.remove(B[i]);
                }
            }
            return map.size() == 0;
        }
    }
}
