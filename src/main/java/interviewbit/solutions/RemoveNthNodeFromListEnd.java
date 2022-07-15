package interviewbit.solutions;

/*
https://www.interviewbit.com/problems/remove-nth-node-from-list-end/
 */

import ds.util.ListNode;

public class RemoveNthNodeFromListEnd {

    public ListNode solve(ListNode head, int distanceFromEnd) {
        return new Solution().removeNthFromEnd(head, distanceFromEnd);
    }


    public static class Solution {
        public ListNode removeNthFromEnd(ListNode head, int distanceFromEnd) {

            if (head == null) {
                return null;
            }

            ListNode farPointer = head;

            for (int i = 1; i <= distanceFromEnd; i++) {
                if (farPointer == null) {
                    return head.next;
                } else {
                    farPointer = farPointer.next;
                }
            }

            if (farPointer == null) {
                return head.next;
            }

            ListNode startPointer = head;
            ListNode oneBeforeStartPointer = null;

            while (farPointer != null) {
                oneBeforeStartPointer = startPointer;
                startPointer = startPointer.next;
                farPointer = farPointer.next;
            }

            oneBeforeStartPointer.next = startPointer.next;


            return head;
        }
    }


}
