/*
https://www.geeksforgeeks.org/problems/delete-middle-of-linked-list
 */

package gfg;

import gfg.util.link.Node;

public class DeleteMidOfLinkedList {

    Node deleteMid(Node head) {
        // This is method only submission.
        // You only need to complete the method.
        if (head.next == null){
            return null;
        }
        Node slow = head;
        Node fast = head;
        int slowCount = 0;
        boolean evenCount = false;
        while (fast != null){
            slow = slow.next;
            if (fast.next != null && fast.next.next == null){
                fast = null;
                evenCount = true;
            }else if (fast.next == null){
                fast = null;
            }else{
                fast = fast.next.next;
                ++slowCount;
            }

        }

        int loopCount = evenCount ? slowCount : slowCount -1 ;

        slow = head;
        for (int i = 0;i< loopCount; i++){
            slow = slow.next;
        }
        slow.next = slow.next.next;

        return head;

    }



}
