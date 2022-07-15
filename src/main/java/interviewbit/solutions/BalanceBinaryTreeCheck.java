package interviewbit.solutions;

/*
https://www.interviewbit.com/problems/balanced-binary-tree/
 */


import ds.util.TreeNode;

public class BalanceBinaryTreeCheck {

    public int solve(TreeNode rootNode) {
        return new Solution().isBalanced(rootNode);
    }



    @SuppressWarnings("InnerClassMayBeStatic")
    public class Solution {
        public int isBalanced(TreeNode root) {
            return checkHeightRecursive(root).balanced ? 1 : 0;
        }

        private HeightBalanceChecker checkHeightRecursive(TreeNode node) {
            if (node == null) {
                return new HeightBalanceChecker();
            }
            HeightBalanceChecker left = checkHeightRecursive(node.left);
            HeightBalanceChecker right = checkHeightRecursive(node.right);

            HeightBalanceChecker heightBalanceChecker = new HeightBalanceChecker();

            if (!left.balanced || !right.balanced || Math.abs(left.height - right.height) > 1) {
                heightBalanceChecker.balanced = false;
            } else {
                heightBalanceChecker.height = Math.max(left.height, right.height) + 1;
            }
            return heightBalanceChecker;
        }


        class HeightBalanceChecker {
            int height = 0;
            boolean balanced = true;
        }
    }

}
