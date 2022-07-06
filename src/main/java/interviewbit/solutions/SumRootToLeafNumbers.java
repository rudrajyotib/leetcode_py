package interviewbit.solutions;

/*
https://www.interviewbit.com/problems/sum-root-to-leaf-numbers/
 */


public class SumRootToLeafNumbers {

    public int solve(TreeNode treeNode){
        return new Solution().sumNumbers(treeNode);
    }


    @SuppressWarnings("InnerClassMayBeStatic")
    public class Solution {
        public int sumNumbers(TreeNode root) {
            return sum(root, 0);
        }

        private int sum(TreeNode treeNode, int sumModCarry){
            if (treeNode==null){
                return 0;
            }
            int sumAtNode = ((sumModCarry * 10) + treeNode.val) % 1003;
            if (treeNode.left == null && treeNode.right == null){
                return sumAtNode;
            }
            return (sum(treeNode.left, sumAtNode)+sum(treeNode.right, sumAtNode))%1003;
        }

    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
            left=null;
            right=null;
        }
    }
}


