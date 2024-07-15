package gfg;

import gfg.util.link.Node;
import org.junit.Test;

import static org.junit.Assert.*;

public class AddNumberLinkedListTest {

    @Test
    public void testCase1(){
        assertArrayEquals(new Integer[]{1,0,0,0},
                AddNumberLinkedList.addTwoLists(Node.createLinkedList(new Integer[]{4,4,5}), Node.createLinkedList(new Integer[]{5,5,5})).toArray());
    }

    @Test
    public void testCase2(){
        assertArrayEquals(new Integer[]{1,0,0,0,0},
                AddNumberLinkedList.addTwoLists(Node.createLinkedList(new Integer[]{4,4,5}), Node.createLinkedList(new Integer[]{9,5,5,5})).toArray());
    }

    @Test
    public void testCase3(){
        assertArrayEquals(new Integer[]{9,0,0,0},
                AddNumberLinkedList.addTwoLists(Node.createLinkedList(new Integer[]{4,4,5}), Node.createLinkedList(new Integer[]{8,5,5,5})).toArray());
    }

    @Test
    public void testCase4(){
        assertArrayEquals(new Integer[]{2,3},
                AddNumberLinkedList.addTwoLists(Node.createLinkedList(new Integer[]{0,0,1}), Node.createLinkedList(new Integer[]{2,2})).toArray());
    }

    @Test
    public void testCase5(){
        assertArrayEquals(new Integer[]{1,0,2,3},
                AddNumberLinkedList.addTwoLists(Node.createLinkedList(new Integer[]{0,0,1}), Node.createLinkedList(new Integer[]{0,1,0,2,2})).toArray());
    }

    @Test
    public void testCase6(){
        assertArrayEquals(new Integer[]{0},
                AddNumberLinkedList.addTwoLists(Node.createLinkedList(new Integer[]{0,0,0}), Node.createLinkedList(new Integer[]{0})).toArray());
    }

    @Test
    public void testCase7(){
        assertArrayEquals(new Integer[]{1,0},
                AddNumberLinkedList.addTwoLists(Node.createLinkedList(new Integer[]{0,0,1}), Node.createLinkedList(new Integer[]{0,9})).toArray());
    }


}