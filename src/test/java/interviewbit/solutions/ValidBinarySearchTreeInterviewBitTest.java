package interviewbit.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class ValidBinarySearchTreeInterviewBitTest {

    @Test
    public void shouldValidateSingleNodeTree(){
        assertEquals(1, new ValidBinarySearchTreeInterviewBit().solve(
                new ValidBinarySearchTreeInterviewBit.TreeNode(1)
        ));
    }

    @Test
    public void shouldNotValidateNullTree(){
        assertEquals(0, new ValidBinarySearchTreeInterviewBit().solve(null));
    }

    @Test
    public void shouldValidateLeftAlignedBst(){
        assertEquals(1, new ValidBinarySearchTreeInterviewBit().solve(
                new ValidBinarySearchTreeInterviewBit.TreeNode(5,
                        new ValidBinarySearchTreeInterviewBit.TreeNode(4,
                                new ValidBinarySearchTreeInterviewBit.TreeNode(3,
                                        new ValidBinarySearchTreeInterviewBit.TreeNode(2),
                                        null),
                                null),
                        null)
        ));
    }

    @Test
    public void shouldNotValidateLeftAlignedBst(){
        assertEquals(0, new ValidBinarySearchTreeInterviewBit().solve(
                new ValidBinarySearchTreeInterviewBit.TreeNode(5,
                        new ValidBinarySearchTreeInterviewBit.TreeNode(4,
                                new ValidBinarySearchTreeInterviewBit.TreeNode(3,
                                        new ValidBinarySearchTreeInterviewBit.TreeNode(12),
                                        null),
                                null),
                        null)
        ));
    }

    @Test
    public void shouldValidateRightAlignedBst(){
        assertEquals(1, new ValidBinarySearchTreeInterviewBit().solve(
                new ValidBinarySearchTreeInterviewBit.TreeNode(1,
                        null,
                        new ValidBinarySearchTreeInterviewBit.TreeNode(2,
                                null,
                                new ValidBinarySearchTreeInterviewBit.TreeNode(3,
                                        null,
                                        new ValidBinarySearchTreeInterviewBit.TreeNode(4,
                                                null,
                                                new ValidBinarySearchTreeInterviewBit.TreeNode(5)))))
        ));
    }

    @Test
    public void shouldNotValidateRightAlignedBst(){
        assertEquals(0, new ValidBinarySearchTreeInterviewBit().solve(
                new ValidBinarySearchTreeInterviewBit.TreeNode(1,
                        null,
                        new ValidBinarySearchTreeInterviewBit.TreeNode(2,
                                null,
                                new ValidBinarySearchTreeInterviewBit.TreeNode(3,
                                        null,
                                        new ValidBinarySearchTreeInterviewBit.TreeNode(4,
                                                null,
                                                new ValidBinarySearchTreeInterviewBit.TreeNode(0)))))
        ));
    }

    @Test
    public void shouldValidateDistributedBst(){
        assertEquals(1, new ValidBinarySearchTreeInterviewBit().solve(
                new ValidBinarySearchTreeInterviewBit.TreeNode(10,
                        new ValidBinarySearchTreeInterviewBit.TreeNode(5,
                                new ValidBinarySearchTreeInterviewBit.TreeNode(2),
                                new ValidBinarySearchTreeInterviewBit.TreeNode(7,
                                        null,
                                        new ValidBinarySearchTreeInterviewBit.TreeNode(8))),
                        new ValidBinarySearchTreeInterviewBit.TreeNode(15,
                                new ValidBinarySearchTreeInterviewBit.TreeNode(13),
                                new ValidBinarySearchTreeInterviewBit.TreeNode(20,
                                        new ValidBinarySearchTreeInterviewBit.TreeNode(18),
                                        new ValidBinarySearchTreeInterviewBit.TreeNode(23))))
        ));
    }

    @Test
    public void shouldNotValidateDistributedBstSet1(){
        assertEquals(0, new ValidBinarySearchTreeInterviewBit().solve(
                new ValidBinarySearchTreeInterviewBit.TreeNode(10,
                        new ValidBinarySearchTreeInterviewBit.TreeNode(5,
                                new ValidBinarySearchTreeInterviewBit.TreeNode(2),
                                new ValidBinarySearchTreeInterviewBit.TreeNode(7,
                                        null,
                                        new ValidBinarySearchTreeInterviewBit.TreeNode(8))),
                        new ValidBinarySearchTreeInterviewBit.TreeNode(9,
                                new ValidBinarySearchTreeInterviewBit.TreeNode(13),
                                new ValidBinarySearchTreeInterviewBit.TreeNode(20,
                                        new ValidBinarySearchTreeInterviewBit.TreeNode(18),
                                        new ValidBinarySearchTreeInterviewBit.TreeNode(19))))
        ));
    }

    @Test
    public void shouldNotValidateDistributedBstSet2(){
        assertEquals(0, new ValidBinarySearchTreeInterviewBit().solve(
                new ValidBinarySearchTreeInterviewBit.TreeNode(10,
                        new ValidBinarySearchTreeInterviewBit.TreeNode(5,
                                new ValidBinarySearchTreeInterviewBit.TreeNode(2),
                                new ValidBinarySearchTreeInterviewBit.TreeNode(7,
                                        null,
                                        new ValidBinarySearchTreeInterviewBit.TreeNode(8))),
                        new ValidBinarySearchTreeInterviewBit.TreeNode(15,
                                new ValidBinarySearchTreeInterviewBit.TreeNode(13),
                                new ValidBinarySearchTreeInterviewBit.TreeNode(20,
                                        new ValidBinarySearchTreeInterviewBit.TreeNode(18),
                                        new ValidBinarySearchTreeInterviewBit.TreeNode(20))))
        ));
    }

    @Test
    public void shouldNotValidateDistributedBstSet3(){
        assertEquals(0, new ValidBinarySearchTreeInterviewBit().solve(
                new ValidBinarySearchTreeInterviewBit.TreeNode(10,
                        new ValidBinarySearchTreeInterviewBit.TreeNode(5,
                                new ValidBinarySearchTreeInterviewBit.TreeNode(2),
                                new ValidBinarySearchTreeInterviewBit.TreeNode(12,
                                        null,
                                        new ValidBinarySearchTreeInterviewBit.TreeNode(13))),
                        new ValidBinarySearchTreeInterviewBit.TreeNode(15,
                                new ValidBinarySearchTreeInterviewBit.TreeNode(13),
                                new ValidBinarySearchTreeInterviewBit.TreeNode(20,
                                        new ValidBinarySearchTreeInterviewBit.TreeNode(18),
                                        new ValidBinarySearchTreeInterviewBit.TreeNode(21))))
        ));
    }

    @Test
    public void shouldNotValidateDistributedBstSet4(){
        assertEquals(0, new ValidBinarySearchTreeInterviewBit().solve(
                new ValidBinarySearchTreeInterviewBit.TreeNode(4,
                        new ValidBinarySearchTreeInterviewBit.TreeNode(2,
                                new ValidBinarySearchTreeInterviewBit.TreeNode(1),
                                new ValidBinarySearchTreeInterviewBit.TreeNode(5)),
                        new ValidBinarySearchTreeInterviewBit.TreeNode(5))
        ));
    }

}