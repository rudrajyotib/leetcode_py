package gfg;

import gfg.util.tree.Node;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class BinaryTreeToDllTest {

    @Test
    public void testCase1(){

        Node node = new Node(1,
                new Node(2,
                        new Node(4),
                        new Node(5)),
                new Node(3,
                        new Node(6),
                        new Node(7)));

        Node dllHead = new BinaryTreeToDll().bToDLL(node);
        assertEquals(4, dllHead.data);
        Node temp = dllHead;
        List<Integer> toRight = new LinkedList<>();
        Node rightMost = dllHead;
        while (temp != null){
            toRight.add(temp.data);
            rightMost = temp;
            temp = temp.right;
        }
        assertArrayEquals(new Integer[]{4,2,5,1,6,3,7}, toRight.toArray(new Integer[0]));
        List<Integer> toLeft = new LinkedList<>();
        temp = rightMost;
        while (temp != null){
            toLeft.add(temp.data);
            temp = temp.left;
        }
        assertArrayEquals(new Integer[]{7,3,6,1,5,2,4}, toLeft.toArray(new Integer[0]));
    }

}