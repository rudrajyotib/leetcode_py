package gfg;

import gfg.util.link.Node;
import org.junit.Test;

import static org.junit.Assert.*;

public class DeletionAndReverseInCircularLinkedListTest {

    @Test
    public void testCase1(){
        Node[] nodes = new Node[5];
        for (int i=0;i<5;i++){
            nodes[i] = new Node(i);
        }
        for (int i=0;i<=3;i++){
            nodes[i].next = nodes[i+1];
        }
        nodes[4].next = nodes[0];
        new DeletionAndReverseInCircularLinkedList().deleteNode(nodes[0], 3);
        assertEquals(4, nodes[2].next.data);
        new DeletionAndReverseInCircularLinkedList().reverse(nodes[0]);
        assertNull(nodes[0].next);
        assertEquals(2, nodes[4].next.data);
    }

    @Test
    public void testCase2(){
        Node[] nodes = new Node[5];
        for (int i=0;i<5;i++){
            nodes[i] = new Node(i);
        }
        for (int i=0;i<=3;i++){
            nodes[i].next = nodes[i+1];
        }
        nodes[4].next = nodes[0];
        new DeletionAndReverseInCircularLinkedList().deleteNode(nodes[0], 0);
        assertEquals(1, nodes[4].next.data);
        new DeletionAndReverseInCircularLinkedList().reverse(nodes[0]);
        Node newHead = new DeletionAndReverseInCircularLinkedList().reverse(nodes[1]);
        assertNull(nodes[1].next);
        assertEquals(3, nodes[4].next.data);
        assertEquals(4, newHead.data);
    }

}