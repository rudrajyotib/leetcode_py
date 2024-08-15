package gfg;

import gfg.util.link.Node;
import org.junit.Test;

import static org.junit.Assert.*;

public class AddOneToLinkedListNumberTest {

    @Test
    public void testCase1(){
        assertArrayEquals(new Integer[]{1,0,0}, new AddOneToLinkedListNumber().addOne(
                new Node(9, new Node(9))
        ).toArray());

        assertArrayEquals(new Integer[]{1,0,}, new AddOneToLinkedListNumber().addOne(
                new Node(9)
        ).toArray());

        assertArrayEquals(new Integer[]{4,6,0}, new AddOneToLinkedListNumber().addOne(
                new Node(4, new Node(5, new Node(9)))
        ).toArray());

        assertArrayEquals(new Integer[]{4,5,1}, new AddOneToLinkedListNumber().addOne(
                new Node(4, new Node(5, new Node(0)))
        ).toArray());

        assertArrayEquals(new Integer[]{1}, new AddOneToLinkedListNumber().addOne(
                new Node(0)
        ).toArray());
    }

}