package interviewbit.solutions;

public class ClimbingStairs {

    public int solve(int n){
        return new Solution().climbStairs(n);
    }


    public static class Solution {
        public int climbStairs(int A) {

            if (A == 1){
                return 1;
            }
            if ( A == 2){
                return 2;
            }

            int[] temp=new int[A+1];
            temp[1] = 1;
            temp[2] = 2;

            for (int i=3;i<=A;i++){
                temp[i] = temp[i-1] + temp[i-2];
            }
            return temp[A];
        }
    }

}
