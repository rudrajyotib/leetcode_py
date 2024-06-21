/*
https://leetcode.com/problems/grumpy-bookstore-owner/description/
 */

package leet.solutions;

public class GrumpyBookstoreOwner {


    public int solve(int[] customers, int[] grumpy, int minutes) {
        return new Solution().maxSatisfied(customers, grumpy, minutes);
    }

    static class Solution {
        public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {


            int ifNonGrumpyMinutesCount = 0;
            int max = 0;
            for (int i=0;i<customers.length;i++){
                if (grumpy[i] == 0){
                    ifNonGrumpyMinutesCount += customers[i];
                }
            }
            if (minutes == 0){
                return ifNonGrumpyMinutesCount;
            }
            int[] nonGrumpyArray = new int[customers.length - minutes + 1];
            int[] grumpyArray = new int[customers.length - minutes + 1];
            for (int i=0;i<minutes;i++){
                nonGrumpyArray[0] += customers[i];
                if (grumpy[i] == 0){
                    grumpyArray[0] += customers[i];
                }
                max = Math.max(max,(ifNonGrumpyMinutesCount-grumpyArray[0])+nonGrumpyArray[0]);
            }
            for (int i=1;i<nonGrumpyArray.length;i++){
                nonGrumpyArray[i] = nonGrumpyArray[i-1]-customers[i-1]+customers[i+minutes-1];
                grumpyArray[i]=grumpyArray[i-1];
                if (grumpy[i-1] == 0){
                    grumpyArray[i] -= customers[i-1];
                }
                if (grumpy[i+minutes-1] == 0){
                    grumpyArray[i] += customers[i+minutes-1];
                }
                max = Math.max(max,(ifNonGrumpyMinutesCount-grumpyArray[i])+nonGrumpyArray[i]);
            }


            return max;
        }
    }

}
