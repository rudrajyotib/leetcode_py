package leet.solutions;

/*
https://leetcode.com/problems/binary-tree-inorder-traversal/
Leetcode#94
 */

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeInorderTraversal {
    static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
    }

    public List<Integer> solve(TreeNode root)
    {
        Solution solution = new Solution();
        return solution.inorderTraversal(root);
    }


    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {

            if (root ==null)
            {
                //noinspection unchecked
                return Collections.EMPTY_LIST;
            }

            List<Integer> result = new LinkedList<>();
            traverseInOrder(root, result);

            return result;
        }

        private void traverseInOrder(TreeNode treeNode, List<Integer> result)
        {
            if (treeNode ==  null)
            {
                return;
            }
            traverseInOrder(treeNode.left, result);
            result.add(treeNode.val);
            traverseInOrder(treeNode.right, result);
        }
    }
    
}
