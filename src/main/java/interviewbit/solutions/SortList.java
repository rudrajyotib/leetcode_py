package interviewbit.solutions;

/*
https://www.interviewbit.com/problems/sort-list/
Merge sort of linked list.
 */

import ds.util.ListNode;

public class SortList {


    public ListNode solve(ListNode listNode){
        return new Solution().sortList(listNode);
    }

    public static class Solution {
        public ListNode sortList(ListNode A) {
            return sortAndMerge(A);
        }

        private ListNode sortAndMerge(ListNode node){

            if (node == null){
                return null;
            }

            if (node.next == null){
                return node;
            }

            ListNode slowPointer = node;
            ListNode fastPointer = node;
            ListNode leftOfMid = null;

            while (fastPointer!=null && fastPointer.next!=null){
                leftOfMid = slowPointer;
                slowPointer = slowPointer.next;
                fastPointer = fastPointer.next.next;
            }

            leftOfMid.next = null;
            ListNode left = sortAndMerge(node);
            ListNode right = sortAndMerge(slowPointer);

            return merge(left, right);
        }

        private ListNode merge(ListNode left, ListNode right){
             if (left == null ){
                 return right;
             }else if (right == null){
                 return left;
             }
             ListNode leftPointer = left;
             ListNode rightPointer = right;
             ListNode sortedList = null;
             ListNode sortedListPointer = null;
             while (leftPointer != null && rightPointer != null){
                 ListNode smallerNode;
                 if (leftPointer.val < rightPointer.val){
                     smallerNode = leftPointer;
                     leftPointer = leftPointer.next;
                 }else{
                     smallerNode = rightPointer;
                     rightPointer = rightPointer.next;
                 }
                 if (sortedList == null){
                     sortedList = smallerNode;
                     sortedListPointer = smallerNode;
                 }else{
                     sortedListPointer.next = smallerNode;
                     sortedListPointer = sortedListPointer.next;
                 }
             }
             while (leftPointer != null){
                 sortedListPointer.next = leftPointer;
                 sortedListPointer = sortedListPointer.next;
                 leftPointer = leftPointer.next;
             }
             while (rightPointer != null){
                 sortedListPointer.next = rightPointer;
                 sortedListPointer = sortedListPointer.next;
                 rightPointer = rightPointer.next;
             }
             sortedListPointer.next = null;

             return sortedList;
        }
    }

}
