package leet.solutions;

import ds.util.TreeNode;

public class InvertBinaryTree {



    public TreeNode solve(TreeNode root)
    {
        Solution solution = new Solution();
        return solution.invertTree(root);
    }

    @SuppressWarnings("InnerClassMayBeStatic")
    class Solution {
        public TreeNode invertTree(TreeNode root) {
            if (root == null)
            {
                return null;
            }
            invertTreeRecursive(root);
            return root;
        }

        public void invertTreeRecursive(TreeNode node)
        {
            if (node == null)
            {
                return;
            }
            TreeNode temp = node.right;
            node.right = node.left;
            node.left = temp;
            invertTreeRecursive(node.left);
            invertTreeRecursive(node.right);
        }
    }


}
