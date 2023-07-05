package leet.solutions;

/*
https://leetcode.com/problems/binary-tree-level-order-traversal/
Leetcode#102
 */


import ds.util.TreeNode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {


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
            while (!nodesPipeLine.isEmpty())
            {
                result.addLast(new LinkedList<>());
                int levelNodeSize = nodesPipeLine.size();
                for (int i=0;i<levelNodeSize;i++)
                {
                    TreeNode treeNode = nodesPipeLine.pollFirst();
                    assert treeNode != null;
                    result.getLast().add(treeNode.val);
                    if (treeNode.left != null)
                    {
                        nodesPipeLine.addLast(treeNode.left);
                    }
                    if (treeNode.right != null)
                    {
                        nodesPipeLine.addLast(treeNode.right);
                    }
                }
            }

            return result;
        }
    }

}
