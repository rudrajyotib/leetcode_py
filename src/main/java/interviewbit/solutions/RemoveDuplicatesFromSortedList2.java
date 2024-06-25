package interviewbit.solutions;

/*
https://www.interviewbit.com/problems/remove-duplicates-from-sorted-list-ii/
 */

import ds.util.ListNode;

public class RemoveDuplicatesFromSortedList2 {

    public ListNode solve(ListNode head) {
        return new Solution().deleteDuplicates(head);
    }


    public static class Solution {
        public ListNode deleteDuplicates(ListNode head) {

            if (head == null) {
                return null;
            }

            if (head.next == null) {
                return head;
            }


            ListNode resultHead = null;
            ListNode resultTail = null;
            ListNode pointer;
            boolean potentialSingle = false;
            if (head.val != head.next.val) {
                potentialSingle = true;
                resultHead = new ListNode(head.val);
                resultTail = resultHead;
            }
            pointer = head.next;

            while (pointer.next != null) {
                if (pointer.val == pointer.next.val) {
                    potentialSingle = false;
                } else {
                    if (potentialSingle) {
                        if (resultHead == null) {
                            resultHead = new ListNode(pointer.val);
                            resultTail = resultHead;
                        } else {
                            resultTail.next = new ListNode(pointer.val);
                            resultTail = resultTail.next;
                        }
                    } else {
                        potentialSingle = true;
                    }
                }
                pointer = pointer.next;
            }
            if (potentialSingle) {
                if (resultHead == null) {
                    resultHead = new ListNode(pointer.val);
                } else {
                    resultTail.next = new ListNode(pointer.val);
                }
            }

            return resultHead;
        }
    }


}
