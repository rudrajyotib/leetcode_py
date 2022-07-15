package interviewbit.solutions;

/*
https://www.interviewbit.com/problems/sort-binary-linked-list/
 */

import ds.util.ListNode;

public class SortBinaryLinkedList {

    public ListNode solve(ListNode root){
        return new Solution().solve(root);
    }



    public static class Solution {
        public ListNode solve(ListNode A) {

            ListNode zeroPointerHead = null;
            ListNode zeroPointerTail = null;
            ListNode onePointerHead = null;
            ListNode onePointerTail = null;

            ListNode pointer = A;

            while (pointer != null){
                if (pointer.val == 0){
                    if (zeroPointerHead == null){
                        zeroPointerHead = pointer;
                        zeroPointerTail = pointer;
                    }else{
                        zeroPointerTail.next = pointer;
                        zeroPointerTail = zeroPointerTail.next;
                    }
                }
                if (pointer.val == 1){
                    if (onePointerHead == null){
                        onePointerHead = pointer;
                        onePointerTail = pointer;
                    }else{
                        onePointerTail.next = pointer;
                        onePointerTail = onePointerTail.next;
                    }
                }
                pointer = pointer.next;
            }

            if (zeroPointerHead == null){
                return onePointerHead;
            }else if (onePointerHead == null){
                return zeroPointerHead;
            }

            zeroPointerTail.next = onePointerHead;
            onePointerTail.next = null;
            return zeroPointerHead;
        }
    }


}
