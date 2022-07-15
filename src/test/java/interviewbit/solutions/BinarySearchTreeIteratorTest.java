package interviewbit.solutions;

import ds.util.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTreeIteratorTest {

    @Test
    public void shouldIterateSet1(){
        BinarySearchTreeIterator.Solution binarySearchTreeIterator = new BinarySearchTreeIterator.Solution(new TreeNode(40,
                new TreeNode(20,
                        null,
                        new TreeNode(30,
                                new TreeNode(28),
                                new TreeNode(35,
                                        null,
                                        new TreeNode(38)))),
                new TreeNode(60,
                        null,
                        new TreeNode(90,
                                new TreeNode(70),
                                null))));

        assertTrue(binarySearchTreeIterator.hasNext());
        assertEquals(20, binarySearchTreeIterator.next());
        assertEquals(28, binarySearchTreeIterator.next());
        assertEquals(30, binarySearchTreeIterator.next());
        assertTrue(binarySearchTreeIterator.hasNext());
        assertEquals(35, binarySearchTreeIterator.next());
        assertEquals(38, binarySearchTreeIterator.next());
        assertTrue(binarySearchTreeIterator.hasNext());
        assertEquals(40, binarySearchTreeIterator.next());
        assertTrue(binarySearchTreeIterator.hasNext());
        assertEquals(60, binarySearchTreeIterator.next());
        assertEquals(70, binarySearchTreeIterator.next());
        assertTrue(binarySearchTreeIterator.hasNext());
        assertEquals(90, binarySearchTreeIterator.next());
        assertFalse(binarySearchTreeIterator.hasNext());
    }

    @Test
    public void shouldIterateSet2(){
        BinarySearchTreeIterator.Solution iterator = new BinarySearchTreeIterator.Solution(new TreeNode(1));
        assertTrue(iterator.hasNext());
        assertTrue(iterator.hasNext());
        assertTrue(iterator.hasNext());
        assertEquals(1, iterator.next());
        assertFalse(iterator.hasNext());
        assertFalse(iterator.hasNext());
    }

}