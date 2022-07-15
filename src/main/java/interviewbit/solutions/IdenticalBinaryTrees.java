package interviewbit.solutions;

/*
https://www.interviewbit.com/problems/identical-binary-trees/
 */

import ds.util.TreeNode;

public class IdenticalBinaryTrees {

    public int solve(TreeNode first, TreeNode second){
        return new Solution().isSameTree(first, second);
    }


    @SuppressWarnings("InnerClassMayBeStatic")
    public class Solution {
        public int isSameTree(TreeNode A, TreeNode B) {
            return checkIdentityRecursive(A,B) ? 1 : 0;
        }

        private boolean checkIdentityRecursive(TreeNode first, TreeNode second){
            if (first == null && second == null){
                return true;
            }
            if (first == null || second == null){
                return false;
            }
            if (first.val != second.val){
                return false;
            }
            return checkIdentityRecursive(first.left, second.left) && checkIdentityRecursive(first.right, second.right);
        }
    }


}
