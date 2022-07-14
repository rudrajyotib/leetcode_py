package interviewbit.solutions;

/*
https://www.interviewbit.com/problems/remove-duplicates-from-sorted-list/
 */

public class RemoveDuplicateFromSortedLinkedList {

    public ListNode solve(ListNode root){
        return new Solution().deleteDuplicates(root);
    }

    static class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static class Solution {
        public ListNode deleteDuplicates(ListNode A) {

            ListNode previous = A;
            ListNode current = A.next;

            while (current != null){
                if (current.val == previous.val){
                    previous.next = current.next;
                    current = previous.next;
                }else{
                    previous = current;
                    current = current.next;
                }
            }
            return A;
        }
    }

}
