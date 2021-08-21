package leet.solutions;

/*
https://leetcode.com/problems/binary-tree-maximum-path-sum/
Leetcode#124
 */

public class BinaryTreeMaximumPath {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;


        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public int solve(TreeNode node) {
        Solution solution = new Solution();
        return solution.maxPathSum(node);
    }

    @SuppressWarnings("InnerClassMayBeStatic")
    class Solution {

        private int maxVal = 0;

        public int maxPathSum(TreeNode root) {
            if (root == null) {
                return 0;
            }
            this.maxVal = root.val;
            recursivePath(root);
            return this.maxVal;
        }

        private int recursivePath(TreeNode node) {
            int leftSideContribution = 0;
            int rightSideContribution = 0;
            if (node.left != null) {
                leftSideContribution = recursivePath(node.left);
            }
            if (node.right != null) {
                rightSideContribution =  recursivePath(node.right);
            }

            int maxAtNode = Math.max(node.val, Math.max(node.val + leftSideContribution,
                    Math.max(node.val + rightSideContribution, node.val + leftSideContribution + rightSideContribution)));

            if (maxAtNode > this.maxVal) {
                this.maxVal = maxAtNode;
            }

            return Math.max(node.val, Math.max(node.val + leftSideContribution, node.val + rightSideContribution));
        }


    }

}
