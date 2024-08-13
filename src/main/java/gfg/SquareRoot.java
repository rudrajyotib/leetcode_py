/*
https://www.geeksforgeeks.org/problems/square-root/1
 */

package gfg;

public class SquareRoot {

    public long floorSqrt(long n) {
        if (n <= 3){
            return 1;
        }
        // Your code here
        return recur(0, n, n);
    }
    private long recur(long start, long end, long target){
        if (start <= end){
            long mid = (start + end) / 2;
            if ((mid*mid)<=target && (mid+1)*(mid+1)>target){
                return mid;
            }
            if (mid * mid < target) {
                return recur(mid + 1, end, target);
            }
            else {
                return recur(start, mid - 1, target);
            }
        }
        return start;
    }
}
