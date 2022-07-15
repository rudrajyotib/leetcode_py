package interviewbit.solutions;

/*
https://www.interviewbit.com/problems/merge-two-sorted-lists/
 */

import ds.util.ListNode;

public class MergeTwoSortedLinkedLists {

    public ListNode solve(ListNode left, ListNode right){
        return new Solution().mergeTwoLists(left, right);
    }

    public static class Solution {
        public ListNode mergeTwoLists(ListNode left, ListNode right) {

            if (left == null && right == null){
                return null;
            }
            if (left == null){
                return right;
            }
            if (right == null){
                return left;
            }

            ListNode result = null;

            ListNode leftPointer = left;
            ListNode rightPointer = right;
            ListNode resultPointer = null;

            while (leftPointer!=null && rightPointer != null){
                ListNode nextResultNode;
                if (leftPointer.val < rightPointer.val){
                    nextResultNode = leftPointer;
                    leftPointer = leftPointer.next;
                }else{
                    nextResultNode = rightPointer;
                    rightPointer = rightPointer.next;
                }
                if (result == null){
                    result = nextResultNode;
                    resultPointer = result;
                }else{
                    resultPointer.next = nextResultNode;
                    resultPointer = resultPointer.next;
                }
            }

            while (leftPointer != null){
                resultPointer.next = leftPointer;
                resultPointer = resultPointer.next;
                leftPointer = leftPointer.next;
            }

            while (rightPointer != null){
                resultPointer.next = rightPointer;
                resultPointer = resultPointer.next;
                rightPointer = rightPointer.next;
            }

            resultPointer.next = null;

            return result;
        }
    }


}
