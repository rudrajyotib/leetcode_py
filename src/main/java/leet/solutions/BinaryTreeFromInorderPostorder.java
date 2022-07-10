package leet.solutions;

/*
https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
Leetcode#106
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BinaryTreeFromInorderPostorder {

    @SuppressWarnings({"InnerClassMayBeStatic", "unused"})
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public TreeNode solve(int[] inorder, int[] postorder)
    {
        Solution solution = new Solution();
        return solution.buildTree(inorder, postorder);
    }


    class Solution {

        private int postOrderPointer = 0;
        private final Map<Integer, Integer> inOrder = new HashMap<>();
        private int[] postOrder;
        private int treeLength;

        public TreeNode buildTree(int[] inorder, int[] postorder) {
            this.postOrderPointer = postorder.length;
            for (int i=0; i<inorder.length; i++) {
                inOrder.put(inorder[i], i);
            }
            this.postOrder = postorder;
            this.treeLength = postorder.length;
            return createTree(0, treeLength-1);
        }

        private TreeNode createTree( int startPointer, int endPointer)
        {
            if(startPointer<0)
            {
                return null;
            }
            if (startPointer > endPointer)
            {
                return null;
            }
            if (endPointer >= treeLength )
            {
                return null;
            }
            --this.postOrderPointer;
            int indexOfRoot = this.inOrder.get(this.postOrder[this.postOrderPointer]);
            TreeNode root = new TreeNode(this.postOrder[this.postOrderPointer]);
            root.right = createTree(indexOfRoot+1, endPointer);
            root.left = createTree(startPointer, indexOfRoot-1);

            return root;
        }

    }

}
