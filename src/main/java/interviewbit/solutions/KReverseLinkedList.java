package interviewbit.solutions;

/*
https://www.interviewbit.com/problems/k-reverse-linked-list/
 */

import ds.util.ListNode;

public class KReverseLinkedList {

    public ListNode solve(ListNode head, int width) {
        return new Solution().reverseList(head, width);
    }


    public static class Solution {
        public ListNode reverseList(ListNode head, int batch) {
            if (batch == 1) {
                return head;
            }

            ListNode pointer = head;
            ListNode leftOfPreviousPortion = null;
            ListNode startOfReversePortion;
            ListNode resultNode = null;

            while (pointer != null) {

                startOfReversePortion = pointer;
                for (int i = 1; i < batch; i++) {
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
                leftOfPreviousPortion = startOfReversePortion;
                startOfReversePortion.next = pointer;

            }


            return resultNode;
        }

        private void reverse(ListNode node) {
            reverseRecursive(node);
        }

        private ListNode reverseRecursive(ListNode node) {
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
