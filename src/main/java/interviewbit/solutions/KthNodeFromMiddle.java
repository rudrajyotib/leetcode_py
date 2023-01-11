package interviewbit.solutions;

/*
https://www.interviewbit.com/problems/kth-node-from-middle/
 */

import ds.util.ListNode;

public class KthNodeFromMiddle {

    public int solve(ListNode list, int elementFromMiddle){
        return new Solution().solve(list, elementFromMiddle);
    }

    static class Solution {
        public int solve(ListNode A, int B) {

            if (B < 0){
                return -1;
            }

            int length = 0;
            ListNode pointer = A;
            while (pointer != null){
                pointer = pointer.next;
                ++length;
            }

            int requiredNode = (length / 2 ) +1 - B;
            if (requiredNode >0 ){
                int counter = 0;
                ListNode result  = A;
                while (counter < requiredNode-1){
                    result = result.next;
                    ++counter;
                }
                return result.val;
            }

            return -1;
        }
    }


}
