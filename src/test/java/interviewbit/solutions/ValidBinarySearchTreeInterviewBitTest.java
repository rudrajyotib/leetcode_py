package interviewbit.solutions;

import ds.util.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class ValidBinarySearchTreeInterviewBitTest {

    @Test
    public void shouldValidateSingleNodeTree(){
        assertEquals(1, new ValidBinarySearchTreeInterviewBit().solve(
                new TreeNode(1)
        ));
    }

    @Test
    public void shouldNotValidateNullTree(){
        assertEquals(0, new ValidBinarySearchTreeInterviewBit().solve(null));
    }

    @Test
    public void shouldValidateLeftAlignedBst(){
        assertEquals(1, new ValidBinarySearchTreeInterviewBit().solve(
                new  TreeNode(5,
                        new  TreeNode(4,
                                new  TreeNode(3,
                                        new  TreeNode(2),
                                        null),
                                null),
                        null)
        ));
    }

    @Test
    public void shouldNotValidateLeftAlignedBst(){
        assertEquals(0, new ValidBinarySearchTreeInterviewBit().solve(
                new  TreeNode(5,
                        new  TreeNode(4,
                                new  TreeNode(3,
                                        new  TreeNode(12),
                                        null),
                                null),
                        null)
        ));
    }

    @Test
    public void shouldValidateRightAlignedBst(){
        assertEquals(1, new ValidBinarySearchTreeInterviewBit().solve(
                new  TreeNode(1,
                        null,
                        new  TreeNode(2,
                                null,
                                new  TreeNode(3,
                                        null,
                                        new  TreeNode(4,
                                                null,
                                                new  TreeNode(5)))))
        ));
    }

    @Test
    public void shouldNotValidateRightAlignedBst(){
        assertEquals(0, new ValidBinarySearchTreeInterviewBit().solve(
                new  TreeNode(1,
                        null,
                        new  TreeNode(2,
                                null,
                                new  TreeNode(3,
                                        null,
                                        new  TreeNode(4,
                                                null,
                                                new  TreeNode(0)))))
        ));
    }

    @Test
    public void shouldValidateDistributedBst(){
        assertEquals(1, new ValidBinarySearchTreeInterviewBit().solve(
                new  TreeNode(10,
                        new  TreeNode(5,
                                new  TreeNode(2),
                                new  TreeNode(7,
                                        null,
                                        new  TreeNode(8))),
                        new  TreeNode(15,
                                new  TreeNode(13),
                                new  TreeNode(20,
                                        new  TreeNode(18),
                                        new  TreeNode(23))))
        ));
    }

    @Test
    public void shouldNotValidateDistributedBstSet1(){
        assertEquals(0, new ValidBinarySearchTreeInterviewBit().solve(
                new  TreeNode(10,
                        new  TreeNode(5,
                                new  TreeNode(2),
                                new  TreeNode(7,
                                        null,
                                        new  TreeNode(8))),
                        new  TreeNode(9,
                                new  TreeNode(13),
                                new  TreeNode(20,
                                        new  TreeNode(18),
                                        new  TreeNode(19))))
        ));
    }

    @Test
    public void shouldNotValidateDistributedBstSet2(){
        assertEquals(0, new ValidBinarySearchTreeInterviewBit().solve(
                new  TreeNode(10,
                        new  TreeNode(5,
                                new  TreeNode(2),
                                new  TreeNode(7,
                                        null,
                                        new  TreeNode(8))),
                        new  TreeNode(15,
                                new  TreeNode(13),
                                new  TreeNode(20,
                                        new  TreeNode(18),
                                        new  TreeNode(20))))
        ));
    }

    @Test
    public void shouldNotValidateDistributedBstSet3(){
        assertEquals(0, new ValidBinarySearchTreeInterviewBit().solve(
                new  TreeNode(10,
                        new  TreeNode(5,
                                new  TreeNode(2),
                                new  TreeNode(12,
                                        null,
                                        new  TreeNode(13))),
                        new  TreeNode(15,
                                new  TreeNode(13),
                                new  TreeNode(20,
                                        new  TreeNode(18),
                                        new  TreeNode(21))))
        ));
    }

    @Test
    public void shouldNotValidateDistributedBstSet4(){
        assertEquals(0, new ValidBinarySearchTreeInterviewBit().solve(
                new  TreeNode(4,
                        new  TreeNode(2,
                                new  TreeNode(1),
                                new  TreeNode(5)),
                        new  TreeNode(5))
        ));
    }

}