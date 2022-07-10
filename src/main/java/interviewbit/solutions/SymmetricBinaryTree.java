package interviewbit.solutions;

/*
https://www.interviewbit.com/problems/symmetric-binary-tree
 */

public class SymmetricBinaryTree {

    public int solve(TreeNode root){
        return new Solution().isSymmetric(root);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }

        TreeNode(int x, TreeNode left, TreeNode right){
            this.val = x;
            this.left = left;
            this.right = right;
        }
    }

    @SuppressWarnings("InnerClassMayBeStatic")
    public class Solution {
        public int isSymmetric(TreeNode A) {
            if (A.left == null && A.right == null){
                return 1;
            }
            if (A.left == null || A.right == null){
                return 0;
            }
            if (A.left.val != A.right.val){
                return 0;
            }
            return checkSymmetryRecursive(A.left, A.right) ? 1:0;
        }

        private boolean checkSymmetryRecursive(TreeNode left, TreeNode right){
            if (left == null && right == null)
            {
                return true;
            }
            if (left == null || right == null){
                return false;
            }
            if (left.val != right.val){
                return false;
            }
            return checkSymmetryRecursive(left.left, right.right) && checkSymmetryRecursive(left.right, right.left);
        }

    }


}
