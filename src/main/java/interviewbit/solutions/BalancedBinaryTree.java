package interviewbit.solutions;

import ds.util.TreeNode;

public class BalancedBinaryTree {


    public int solve(TreeNode treeNode){
        return new Solution().isBalanced(treeNode);
    }

    static class Solution {
        public int isBalanced(TreeNode A) {
            return checkIsBalancedRecursive(A) == -1 ? 0 : 1;
        }

        private int checkIsBalancedRecursive(TreeNode treeNode){
            if (treeNode == null){
                return 0;
            }
            int leftHeight = checkIsBalancedRecursive(treeNode.left);
            int rightHeight = checkIsBalancedRecursive(treeNode.right);
            if (leftHeight == -1 || rightHeight == -1){
                return -1;
            }
            if (Math.abs(leftHeight-rightHeight) > 1){
                return -1;
            }
            return 1+Math.max(leftHeight, rightHeight);
        }

    }

}
