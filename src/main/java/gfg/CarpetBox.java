package gfg;

/*
https://practice.geeksforgeeks.org/problems/230d87552a332a2970b2092451334a007f2b0eec/1
 */

public class CarpetBox {


    public int solve(int length, int breadth, int boxLength, int boxBreadth){
        return new Solution().carpetBox(length, breadth, boxLength, boxBreadth);
    }

    static class Solution{
        int carpetBox(int A, int B, int C, int D) {
            //code here
            return recursiveFit(A,B,C,D,0);
        }

        int recursiveFit(int A, int B, int C, int D, int times){
            if (A==0 || B==0){
                return Integer.MAX_VALUE;
            }
            if ((  (A<=C) && (B<=D))
                    || ((A<=D) && (B<=C))
            ){
                return times;
            }
            if ((A>C && A > D && B>C && B>D)){
                return recursiveFit(A/2, B/2, C, D, times+2);
            }
            if ((A<=C && A<=D)){
                return recursiveFit(A, B/2, C, D, times+1);
            }else if ((B <=C && B <=D)){
                return recursiveFit(A/2, B, C, D, times+1);
            }else {
                return Math.min(
                        recursiveFit(A / 2, B, C, D, times + 1),
                        recursiveFit(A, B / 2, C, D, times + 1)
                );
            }
        }
    }

}
