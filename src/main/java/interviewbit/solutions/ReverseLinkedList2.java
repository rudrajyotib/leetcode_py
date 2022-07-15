package interviewbit.solutions;

/*
https://www.interviewbit.com/problems/reverse-link-list-ii/
 */

import ds.util.ListNode;

public class ReverseLinkedList2 {


    public ListNode solve(ListNode node, int start, int end){
        return new Solution().reverseBetween(node, start, end);
    }

    public static class Solution {
        public ListNode reverseBetween(ListNode node, int startNode, int endNode) {

            if (startNode == endNode){
                return node;
            }

            ListNode headPointer = node;
            ListNode endOfLeftPortion = null;
            ListNode startOfRightPortion;
            ListNode startOfReversedPortion;
            ListNode endOfReversedPortion;

            for (int i=1;i<startNode;i++){
                endOfLeftPortion = headPointer;
                headPointer = headPointer.next;
            }
            if (endOfLeftPortion != null) {
                endOfLeftPortion.next = null;
            }
            startOfReversedPortion  = headPointer;
            for (int i=startNode;i<endNode;i++){
                headPointer = headPointer.next;
            }
            endOfReversedPortion = headPointer;
            startOfRightPortion = headPointer.next;
            endOfReversedPortion.next = null;

            reverse(startOfReversedPortion);
            ListNode reverseHead = node;

            if(endOfLeftPortion == null){
                reverseHead = endOfReversedPortion;
            }else{
                endOfLeftPortion.next = endOfReversedPortion;
            }

            if (startOfRightPortion != null){
                startOfReversedPortion.next = startOfRightPortion;
            }

            return reverseHead;
        }

        private void reverse(ListNode node){
            reverseRecursive(node);
        }

        private ListNode reverseRecursive(ListNode node){
            if (node.next == null){
                return node;
            }
            ListNode endOfReverseNode = reverseRecursive(node.next);
            endOfReverseNode.next = node;
            node.next = null;
            return node;
        }
    }
}
