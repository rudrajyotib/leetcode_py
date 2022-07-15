package interviewbit.solutions;

/*
https://www.interviewbit.com/problems/valid-binary-search-tree/
 */

import ds.util.TreeNode;

public class ValidBinarySearchTreeInterviewBit {

    public int solve(TreeNode root){
        return new Solution().isValidBST(root);
    }



    @SuppressWarnings("InnerClassMayBeStatic")
    public class Solution {
        public int isValidBST(TreeNode A) {
            if (A== null){
                return 0;
            }
            return validateRecursive(A, Integer.MIN_VALUE, Integer.MAX_VALUE) ? 1 : 0;
        }

        private boolean validateRecursive(TreeNode node, int minLeft, int maxRight){


            if (node.val <= minLeft || node.val >= maxRight){
                return false;
            }
            if (node.left == null && node.right == null){
                return true;
            }

            boolean leftChildOk = node.left == null || validateRecursive(node.left, minLeft, node.val);
            boolean rightChildOk = node.right == null || validateRecursive(node.right, node.val, maxRight);
            return leftChildOk && rightChildOk;
        }
    }
}
