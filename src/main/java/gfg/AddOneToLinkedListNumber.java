/*
https://www.geeksforgeeks.org/problems/add-1-to-a-number-represented-as-linked-list/1
 */

package gfg;

import gfg.util.link.Node;

public class AddOneToLinkedListNumber {

    public Node addOne(Node head) {
        // code here.
        Node origTail = reverse(head);
        Node nav = origTail;
        int carry = 1;
        while (nav != null) {
            if (carry == 1) {
                if (nav.data == 9) {
                    nav.data = 0;
                } else {
                    nav.data += 1;
                    carry = 0;
                }
            }
            nav = nav.next;
        }
        reverse(origTail);
        Node returnHead = head;
        if (carry == 1) {
            Node temp = returnHead;
            returnHead = new Node(1);
            returnHead.next = temp;
        }
        return returnHead;
    }

    private Node reverse(Node node) {
        return reverseRecursive(node);
    }

    private Node reverseRecursive(Node node) {
        if (node.next == null) {
            return node;
        }
        Node right = node.next;
        Node endOfReversedRight = reverseRecursive(right);

        node.next = null;
        right.next = node;
        return endOfReversedRight;
    }
}
