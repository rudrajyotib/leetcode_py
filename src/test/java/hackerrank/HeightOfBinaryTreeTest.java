package hackerrank;

import org.junit.Test;

import static org.junit.Assert.*;

public class HeightOfBinaryTreeTest {

    @Test
    public void testCase1(){
        assertEquals(2, HeightOfBinaryTree.height(
                new Node(4,
                        new Node(2,
                                new Node(1),
                                new Node(3)),
                        new Node(6,
                                new Node(5),
                                new Node(7)))
        ));

        assertEquals(3, HeightOfBinaryTree.height(
                new Node(4,
                        new Node(2,
                                new Node(1),
                                new Node(3)),
                        new Node(6,
                                new Node(5),
                                new Node(7,
                                        new Node(8),
                                        null)))
        ));
    }

}