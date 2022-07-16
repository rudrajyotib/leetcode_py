package interviewbit.solutions;

/*
https://www.interviewbit.com/problems/swap-list-nodes-in-pairs/
 */

import ds.util.ListNode;

public class SwapPairsLinkedList {


    public ListNode solve(ListNode head) {
        return new Solution().swapPairs(head);
    }

    public static class Solution {
        public ListNode swapPairs(ListNode head) {

            if (head == null) {
                return null;
            }

            if (head.next == null) {
                return head;
            }

            ListNode leftOfPrevious = null;
            ListNode swapStart = head;
            ListNode newHead = null;

            while (swapStart != null) {
                if (swapStart.next == null) {
                    swapStart = null;
                } else {
                    ListNode rightOfNext = swapStart.next.next;
                    ListNode temp = swapStart.next;
                    swapStart.next = rightOfNext;
                    temp.next = swapStart;
                    if (leftOfPrevious != null) {
                        leftOfPrevious.next = temp;
                    } else {
                        newHead = temp;
                    }
                    leftOfPrevious = swapStart;
                    swapStart = rightOfNext;
                }
            }


            return newHead;
        }
    }


}
