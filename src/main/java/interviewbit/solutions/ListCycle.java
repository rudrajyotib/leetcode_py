package interviewbit.solutions;

/*
https://www.interviewbit.com/problems/list-cycle/
 */

import ds.util.ListNode;

public class ListCycle {

    public ListNode solve(ListNode node){
        return new Solution().detectCycle(node);
    }


    public static class Solution {
        public ListNode detectCycle(ListNode a) {
            ListNode nodeInLoop = detectNodeInCycle(a);
            if (nodeInLoop == null){
                return null;
            }
            int lengthOfLoop = lengthOfCycle(nodeInLoop);
            ListNode forwardPointer = a;
            for (int i=1;i<=lengthOfLoop;i++){
                forwardPointer = forwardPointer.next;
            }
            ListNode headPointer = a;
            while (headPointer.val  != forwardPointer.val){
                headPointer = headPointer.next;
                forwardPointer = forwardPointer.next;
            }
            return headPointer;
        }

        private ListNode detectNodeInCycle(ListNode node){
            if (node == null){
                return null;
            }
            if (node.next == null){
                return null;
            }
            ListNode slowPointer = node;
            ListNode fastPointer = node.next.next;
            while (slowPointer != null && fastPointer != null && fastPointer.next!= null){
                if (slowPointer.val == fastPointer.val){
                    return slowPointer;
                }
                slowPointer = slowPointer.next;
                fastPointer = fastPointer.next.next;
            }
            return null;
        }

        private int lengthOfCycle(ListNode node){
            ListNode pointer = node.next;
            int length = 1;
            while (pointer.val != node.val){
                ++length;
                pointer = pointer.next;
            }
            return length;
        }
    }

}
