/*
https://www.geeksforgeeks.org/problems/rotate-a-linked-list/1
 */

package gfg;

import gfg.util.link.Node;

public class RotateLeftShiftLinkedList {

    public Node rotate(Node head, int k) {
        // add code here
        if (k == 0) {
            return head;
        }
        Node temp = head;
        Node prevHead = null;
        int counter = 1;
        while (counter <= k) {
            prevHead = temp;
            temp = temp.next;
            ++counter;
        }
        if (temp == null) {
            return head;
        }
        Node newHead = temp;
        assert prevHead != null;
        prevHead.next = null;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = head;
        return newHead;
    }


}
