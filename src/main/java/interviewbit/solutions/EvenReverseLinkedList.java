package interviewbit.solutions;
/*
https://www.interviewbit.com/problems/even-reverse/
 */

import ds.util.ListNode;

public class EvenReverseLinkedList {

    public ListNode solve(ListNode head) {
        return new Solution().solve(head);
    }

    public static class Solution {
        public ListNode solve(ListNode head) {

            if (head == null) {
                return null;
            }

            if (head.next == null) {
                return head;
            }

            ListNode evenHead = head.next;
            ListNode oddTail = head;
            ListNode evenTail = evenHead;

            ListNode oddPointer = head.next.next;
            ListNode evenPointer = evenTail.next != null ? evenTail.next.next : null;
            boolean oddTurn = true;

            while (oddPointer != null && evenPointer != null) {
                if (oddTurn) {
                    oddTail.next = oddPointer;
                    oddTail = oddTail.next;
                    oddPointer = oddPointer.next.next;
                    oddTurn = false;
                } else {
                    evenTail.next = evenPointer;
                    evenTail = evenTail.next;
                    evenPointer = evenPointer.next != null ? evenPointer.next.next : null;
                    oddTurn = true;
                }
            }


            if (oddPointer != null) {
                oddTail.next = oddPointer;
                oddTail = oddTail.next;
            }

            if (evenPointer != null) {
                evenTail.next = evenPointer;
                evenTail = evenTail.next;
            }

            oddTail.next = null;
            evenTail.next = null;

            reverse(evenHead);

            oddPointer = head.next;
            evenPointer = evenTail;
            oddTurn = false;
            ListNode resultPointer = head;
            while (oddPointer != null && evenPointer != null){
                if (oddTurn){
                    resultPointer.next = oddPointer;
                    resultPointer = resultPointer.next;
                    oddPointer = oddPointer.next;
                    resultPointer.next = null;
                    oddTurn  = false;
                }else{
                    resultPointer.next = evenPointer;
                    resultPointer = resultPointer.next;
                    evenPointer = evenPointer.next;
                    resultPointer.next = null;
                    oddTurn = true;
                }
            }

            if (evenPointer != null) {
                resultPointer.next = evenPointer;
            }
            if (oddPointer != null) {
                resultPointer.next = oddPointer;
            }


            return head;
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
