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
            ListNode pointer = head;

            boolean inDuplicateStreak = false;

            while (pointer.next != null) {
                if (pointer.val == pointer.next.val) {
                    inDuplicateStreak = true;
                    pointer = pointer.next;
                } else {
                    if (!inDuplicateStreak) {
                        if (resultHead == null) {
                            resultHead = pointer;
                            resultTail = resultHead;
                        } else {
                            resultTail.next = pointer;
                            resultTail = resultTail.next;
                        }
                        pointer = pointer.next;
                    } else {
                        inDuplicateStreak = false;
                        pointer = pointer.next;
                    }
                }
            }

            if (!inDuplicateStreak) {
                if (resultTail != null) {
                    resultTail.next = pointer;
                    resultTail = resultTail.next;
                } else {
                    resultTail = pointer;
                }
            }
            if(resultTail != null){
                resultTail.next = null;
            }

            return resultHead;
        }
    }


}
