package interviewbit.solutions;

import ds.util.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class LeastCommonAncestorTest {


    private TreeNode createTree() {
        return new  TreeNode(10,
                new  TreeNode(20,
                        new  TreeNode(24,
                                null,
                                new  TreeNode(26,
                                        new  TreeNode(28),
                                        new  TreeNode(29))),
                        null),
                new  TreeNode(30,
                        new  TreeNode(15,
                                null,
                                new  TreeNode(17)),
                        new  TreeNode(16,
                                null,
                                new  TreeNode(18,
                                        null,
                                        new  TreeNode(19)))));
    }

    @Test
    public void shouldHandleNullRoot(){
        assertEquals(-1, new LeastCommonAncestor().solve(null, 10, 20));
    }


    @Test
    public void shouldFindLowestCommonAncestorAsRootWhenSearchedForRootAsBothElements() {
         TreeNode root = createTree();
        assertEquals(10, new LeastCommonAncestor().solve(root,10,10));
    }

    @Test
    public void shouldFindLowestCommonAncestorAsRootWhenSearchedForRootAsFirstArg(){
        assertEquals(10, new LeastCommonAncestor().solve(
                createTree(), 10, 19
        ));
    }

    @Test
    public void shouldFindLowestCommonAncestorAsRootWhenSearchedForRootAsSecondArg(){
        assertEquals(10, new LeastCommonAncestor().solve(
                createTree(), 19, 10
        ));
    }

    @Test
    public void shouldNotFindAnyNodeWhenRootIsFirstArgAndSecondArgNotPresent(){
        assertEquals(-1, new LeastCommonAncestor().solve(
                createTree(), 10, 100
        ));
    }

    @Test
    public void shouldNotFindAnyNodeWhenRootIsSecondArgAndFirstArgNotPresent(){
        assertEquals(-1, new LeastCommonAncestor().solve(
                createTree(), 100, 10
        ));
    }

    @Test
    public void shouldFindLowestCommonAncestorWhenBothArgsOnLeftSideOfRoot(){
        assertEquals(24, new LeastCommonAncestor().solve(
                createTree(), 24, 29
        ));
    }

    @Test
    public void shouldFindLowestCommonAncestorWhenBothArgsOnRightSideOfRoot(){
        assertEquals(30, new LeastCommonAncestor().solve(
                createTree(), 17, 19
        ));
    }

    @Test
    public void shouldFindLowestCommonAncestorAsRootWhenBothArgsOnDifferentSidesOfRoot(){
        assertEquals(10, new LeastCommonAncestor().solve(
                createTree(), 29, 19
        ));
    }

    @Test
    public void shouldNotFindLowestCommonAncestorWhenFirstArgumentDoesNotExistAndSecondIsNotRoot(){
        assertEquals(-1, new LeastCommonAncestor().solve(
                createTree(), 291, 19
        ));
    }

    @Test
    public void shouldNotFindLowestCommonAncestorWhenSecondArgumentDoesNotExistAndFirstIsNotRoot(){
        assertEquals(-1, new LeastCommonAncestor().solve(
                createTree(), 29, 191
        ));
    }



}