package leet.solutions;

/*
https://leetcode.com/problems/binary-tree-level-order-traversal/
Leetcode#102
 */


import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {
      static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      @SuppressWarnings("unused")
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

    public List<List<Integer>> solve(TreeNode root)
    {
        Solution solution = new Solution();
        return solution.levelOrder(root);
    }

    @SuppressWarnings("InnerClassMayBeStatic")
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            if (root == null)
            {
                return Collections.emptyList();
            }
            LinkedList<TreeNode> nodesPipeLine = new LinkedList<>();
            LinkedList<List<Integer>> result = new LinkedList<>();
            nodesPipeLine.addLast(root);
            int nodesInCurrentLevel = 1;
            int nodesInNextLevel = 0;
            while (!nodesPipeLine.isEmpty())
            {
                LinkedList<Integer> nodesInPresentLevel = new LinkedList<>();
                for (int i=0;i<nodesInCurrentLevel;i++)
                {
                    TreeNode treeNode = nodesPipeLine.pollFirst();
                    assert treeNode != null;
                    nodesInPresentLevel.addLast(treeNode.val);
                    if (treeNode.left != null)
                    {
                        ++nodesInNextLevel;
                        nodesPipeLine.addLast(treeNode.left);
                    }
                    if (treeNode.right != null)
                    {
                        ++nodesInNextLevel;
                        nodesPipeLine.addLast(treeNode.right);
                    }
                }
                result.addLast(nodesInPresentLevel);
                nodesInCurrentLevel = nodesInNextLevel;
                nodesInNextLevel = 0;
            }

            return result;
        }
    }

}
