package gfg;

/*
https://practice.geeksforgeeks.org/problems/convert-an-array-to-reduced-form1101/1
 */

import java.util.Arrays;
import java.util.Comparator;

public class ConvertArrayToReducedForm {

    void solve(int[] array){
        new Solution().convert(array);
    }


    static class Solution {
        void convert(int[] arr) {
            //Code here
            int[][] arrPos = new int[arr.length][2];
            for (int i=0;i<arr.length;i++){
                arrPos[i][0] = arr[i];
                arrPos[i][1] = i;
            }
            Arrays.sort(arrPos, Comparator.comparingInt(o -> o[0]));
            for (int i=0;i<arrPos.length;i++){
                arrPos[i][0] = i;
            }
            for (int[] arrPo : arrPos) {
                arr[arrPo[1]] = arrPo[0];
            }
        }
    }


}
