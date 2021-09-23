package leet.solutions;

/*
https://leetcode.com/problems/validate-binary-search-tree/
Leetcode#98
 */

public class ValidateBinarySearchTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        @SuppressWarnings("unused")
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

    public boolean solve(TreeNode node)
    {
        Solution solution = new Solution();
        return solution.isValidBST(node);
    }


    @SuppressWarnings("InnerClassMayBeStatic")
    class Solution {

        private TreeNode lastKnownNode = null;

        public boolean isValidBST(TreeNode root) {
            this.lastKnownNode = null;
            if (root == null)
            {
                return false;
            }
            return validate(root);
        }

        private boolean validate(TreeNode rootNode)
        {
            if(rootNode == null)
            {
                return true;
            }
            boolean validLeftNode = true;
            if (rootNode.left != null)
            {
                validLeftNode = validate(rootNode.left);
            }
            if (!validLeftNode)
            {
                return false;
            }
            if ((this.lastKnownNode != null) && (this.lastKnownNode.val >= rootNode.val))
            {
                return false;
            }
            this.lastKnownNode = rootNode;

            return validate(rootNode.right);
        }

    }


}
