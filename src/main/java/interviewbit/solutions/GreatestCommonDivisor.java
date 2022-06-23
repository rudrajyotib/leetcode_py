package interviewbit.solutions;

/*
https://www.interviewbit.com/problems/greatest-common-divisor/
 */



public class GreatestCommonDivisor {

    public int solve(int A, int B){
        return new Solution().gcd(A, B);
    }


    @SuppressWarnings("InnerClassMayBeStatic")
    public class Solution {
        public int gcd(int a, int b) {
            if (a == 0) {
                return b;
            }
            if (b == 0) {
                return a;
            }
            if (a == b) {
                return a;
            }
            if (a > b) {
                return gcd(a - b, b);
            } else {
                return gcd(a, b - a);
            }
        }

    }


}
