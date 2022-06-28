package interviewbit.solutions;

/*
https://www.interviewbit.com/problems/implement-power-function/
 */


public class PowerFunction {

    public int solve(int x, int n, int d){
        return new Solution().pow(x, n, d);

    }

    @SuppressWarnings("InnerClassMayBeStatic")
    class Solution {
        public int pow(int x, int n, int d) {
            if (d==1){return 0;}

            if (x == 0){
                return 0;
            }

            if (n==0){
                return 1;
            }

            if (x % d == 0){
                return 0;
            }


            int positiveX = x<0? x*-1:x;
            int remainder = (int) calculateRecursiveRemainder(positiveX, n, d);

            if (remainder == 0){
                return 0;
            }

            if (x<0 && n%2==1){
                return d-remainder;
            }

            return remainder;
        }

        private long calculateRecursiveRemainder(int x, int y, int d){
            if (y == 0){
                return 1L;
            }
            if (y == 1){
                return (long)x%d;
            }
            long remainderMemo = calculateRecursiveRemainder(x, y/2, d);
            long remainderIntermediate = (remainderMemo * remainderMemo) % d;
            if (y%2 == 1){
                remainderIntermediate = (remainderIntermediate * x) % d;
            }
            return remainderIntermediate;
        }





    }

}

