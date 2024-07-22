/*
https://www.geeksforgeeks.org/problems/deletion-and-reverse-in-linked-list
 */
package gfg;

import gfg.util.link.Node;

@SuppressWarnings("UnusedReturnValue")
public class DeletionAndReverseInCircularLinkedList {

    Node reverse(Node head) {
        Node tempHead = head;
        if (head.next == null){
            return head;
        }
        boolean circleFound = false;
        while (!circleFound){
            if (tempHead.next == null){
                circleFound = true;
            }else if (tempHead.next.data == head.data){
                circleFound = true;
            }else{
                tempHead = tempHead.next;
            }
        }
        tempHead.next = null;
        recursiveReverse(head);
        return tempHead;
    }

    private void recursiveReverse(Node node){
        if (node == null){
            return;
        }
        if (node.next == null){
            return;
        }
        Node temp = node.next;
        node.next = null;
        recursiveReverse(temp);
        temp.next = node;
    }

    // Function to delete a node from the circular linked list
    Node deleteNode(Node head, int key) {
        Node tempHead = head;
        if (head.data == key ){
            while (tempHead.next.data != head.data){
                tempHead = tempHead.next;
            }
            tempHead.next = head.next;
            head.next = null;
        }else{
            while(tempHead.next.data != key){
                tempHead = tempHead.next;
            }
            Node deleted = tempHead.next;
            tempHead.next = deleted.next;
            deleted.next = null;
        }
        return tempHead;
    }


}
