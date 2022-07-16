package interviewbit.solutions;

/*
https://www.interviewbit.com/problems/reverse-alternate-k-nodes/
 */

import ds.util.ListNode;

public class ReverseAlternateKNodes {

    public ListNode solve(ListNode head, int width) {
        return new Solution().solve(head, width);
    }


    public static class Solution {
        public ListNode solve(ListNode head, int width) {

            if (width == 1) {
                return head;
            }

            ListNode pointer = head;
            ListNode leftOfPreviousPortion = null;
            ListNode startOfReversePortion;
            boolean reverseModeOn = true;
            ListNode resultNode = null;

            while (pointer != null) {
                if (!reverseModeOn) {
                    for (int i = 1; i < width; i++) {
                        pointer = pointer.next;
                    }
                    reverseModeOn = true;
                    leftOfPreviousPortion = pointer;
                    pointer = pointer.next;
                    leftOfPreviousPortion.next = null;
                } else {
                    startOfReversePortion = pointer;
                    for (int i = 1; i < width; i++) {
                        pointer = pointer.next;
                    }
                    ListNode endOfReversibleLength = pointer;
                    if (resultNode == null) {
                        resultNode = endOfReversibleLength;
                    }
                    pointer = pointer.next;
                    endOfReversibleLength.next = null;
                    reverse(startOfReversePortion);
                    if (leftOfPreviousPortion != null) {
                        leftOfPreviousPortion.next = endOfReversibleLength;
                    }
                    startOfReversePortion.next = pointer;
                    reverseModeOn = false;
                }
            }


            return resultNode;
        }

        public void reverse(ListNode node) {
            reverseRecursive(node);
        }

        public ListNode reverseRecursive(ListNode node) {
            if (node.next == null) {
                return node;
            }
            ListNode reversedRight = reverseRecursive(node.next);
            reversedRight.next = node;
            node.next = null;
            return node;
        }

    }

}
