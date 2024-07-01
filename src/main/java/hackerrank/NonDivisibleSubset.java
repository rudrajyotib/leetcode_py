/*
https://www.hackerrank.com/challenges/non-divisible-subset/problem
 */

package hackerrank;

import java.util.List;

public class NonDivisibleSubset {

    public static int nonDivisibleSubset(int k, List<Integer> s) {
        // Write your code here
        int[] countWithRemainder = new int[k];
        for (Integer num: s){
            ++countWithRemainder[num%k];
        }
        int result = 0;
        if (countWithRemainder[0]>0){
            ++result;
        }
        if (k%2 == 0 && countWithRemainder[k/2]>0){
            ++result;
        }

        for (int i=1;i<=(k-1)/2;i++){
            result += Math.max(countWithRemainder[i], countWithRemainder[k-i]);
        }

        return result;
    }


}
