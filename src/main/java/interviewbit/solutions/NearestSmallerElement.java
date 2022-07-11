package interviewbit.solutions;

/*
https://www.interviewbit.com/problems/nearest-smaller-element/
 */

import java.util.Stack;

public class NearestSmallerElement {

    public int[] solve(int[] array) {
        return new Solution().prevSmaller(array);
    }

    @SuppressWarnings("InnerClassMayBeStatic")
    public class Solution {
        public int[] prevSmaller(int[] A) {
            int[] result = new int[A.length];

            Stack<Integer> stack = new Stack<>();

            for (int i = 0; i < A.length; i++) {
                if (stack.isEmpty()) {
                    stack.push(A[i]);
                    result[i] = -1;
                } else {
                    boolean smallerElementFound = false;
                    while (!stack.isEmpty() && !smallerElementFound){
                        smallerElementFound = stack.peek() < A[i];
                        if (!smallerElementFound) {
                            stack.pop();
                        }
                    }
                    if (stack.isEmpty()){
                        result[i] = -1;
                    }else{
                        result[i] = stack.peek();
                    }
                    stack.push(A[i]);
                }
            }


            return result;

        }
    }


}
