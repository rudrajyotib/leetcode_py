package interviewbit.solutions;

/*
https://www.interviewbit.com/problems/palindrome-list/
 */

import ds.util.ListNode;

public class PalindromeList {

    public boolean isPalindrome(ListNode node) {
        return new Solution().lPalin(node) == 1;
    }

    public static class Solution {
        public int lPalin(ListNode head) {

            if (head == null) {
                return 0;
            }

            if (head.next == null) {
                return 1;
            }

            if (head.next.next == null) {
                return head.val == head.next.val ? 1 : 0;
            }

            ListNode leftOfMid = null;
            ListNode slowPointer = head;
            ListNode fastPointer = head;

            ListNode tail = head;
            while (tail.next != null) {
                tail = tail.next;
            }

            while (slowPointer != null && fastPointer != null && fastPointer.next != null) {
                leftOfMid = slowPointer;
                slowPointer = slowPointer.next;
                fastPointer = fastPointer.next.next;
            }

            boolean oddSizedList = fastPointer != null;
            ListNode startOfRight;
            if (oddSizedList) {
                assert slowPointer != null;
                startOfRight = slowPointer.next;
            } else {
                startOfRight = slowPointer;
            }
            leftOfMid.next = null;
            reverse(startOfRight);
            ListNode headPointer = head;
            ListNode tailPointer = tail;
            while (headPointer != null && tailPointer != null) {
                if (headPointer.val != tailPointer.val) {
                    return 0;
                }
                headPointer = headPointer.next;
                tailPointer = tailPointer.next;
            }

            return headPointer != null || tailPointer != null ? 0 : 1;
        }

        private void reverse(ListNode node) {
            reverseRecursive(node);
        }

        private ListNode reverseRecursive(ListNode node) {
            if (node.next == null) {
                return node;
            }
            ListNode endOfReversedRight = reverseRecursive(node.next);
            endOfReversedRight.next = node;
            node.next = null;
            return endOfReversedRight.next;
        }
    }

}
