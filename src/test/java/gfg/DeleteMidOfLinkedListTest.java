package gfg;

import gfg.util.link.Node;
import org.junit.Test;

import static org.junit.Assert.*;

public class DeleteMidOfLinkedListTest {

    @Test
    public void testCase1(){
        assertArrayEquals(new Integer[]{1,2,4,5},
                new DeleteMidOfLinkedList().deleteMid(
                        Node.createLinkedList(new Integer[]{1,2,3,4,5})
                ).toArray());
    }

    @Test
    public void testCase2(){
        assertArrayEquals(new Integer[]{1,2,3,5,6},
                new DeleteMidOfLinkedList().deleteMid(
                        Node.createLinkedList(new Integer[]{1,2,3,4,5,6})
                ).toArray());
    }

}