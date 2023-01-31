package gfg;

/*
https://practice.geeksforgeeks.org/problems/214734e358208c1c6811d9b237b518f6b3c3c094/1
 */

import java.util.Stack;

public class NextGreaterElement {

    public long[] solve(long[] array){
        return new Solution().nextLargerElement(array, array.length);
    }


    static class Solution{
        public  long[] nextLargerElement(long[] arr, int n) {
            // Your code here
            long[] result = new long[n];
            Stack<Long> stack = new Stack<>();
            result[n-1] = -1L;
            stack.add(arr[n-1]);
            for (int i=n-2;i>=0;i--){
                while (!stack.isEmpty() && ! (stack.peek() > arr[i]) ){
                    stack.pop();
                }
                if (stack.isEmpty()){
                    result[i] = -1;
                }else{
                    result[i] = stack.peek();
                }
                stack.add(arr[i]);
            }
            return result;
        }
    }

}
