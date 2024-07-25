package gfg;

import gfg.util.link.Node;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReverseLinkedListInGroupsTest {

    @Test
    public void testCase1(){
        assertArrayEquals(new Integer[]{4,3,2,1,8,7,6,5,9},
                ReverseLinkedListInGroups.reverse(
                        new Node(1, new Node(2, new Node(3, new Node(4,new Node(5, new Node(6, new Node(7, new Node(8, new Node(9)))))))))
                , 4).toArray());
    }

    @Test
    public void testCase2(){
        assertArrayEquals(new Integer[]{4,3,2,1,8,7,6,5},
                ReverseLinkedListInGroups.reverse(
                        new Node(1, new Node(2, new Node(3, new Node(4,new Node(5, new Node(6, new Node(7, new Node(8))))))))
                , 4).toArray());
    }

    @Test
    public void testCase3(){
        assertArrayEquals(new Integer[]{4,3,2,1},
                ReverseLinkedListInGroups.reverse(
                        new Node(1, new Node(2, new Node(3, new Node(4))))
                , 4).toArray());
    }

    @Test
    public void testCase4(){
        assertArrayEquals(new Integer[]{3,2,1},
                ReverseLinkedListInGroups.reverse(
                        new Node(1, new Node(2, new Node(3)))
                , 4).toArray());
    }

    @Test
    public void testCase5(){
        assertArrayEquals(new Integer[]{1,2,3},
                ReverseLinkedListInGroups.reverse(
                        new Node(1, new Node(2, new Node(3)))
                , 1).toArray());
    }


}