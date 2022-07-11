package interviewbit.solutions;

/*
https://www.interviewbit.com/problems/path-sum/
 */

import java.util.Stack;

public class PathSum {

    public int solve(TreeNode treeNode, int sum) {
        return new Solution().hasPathSum(treeNode, sum);
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

        TreeNode(int x, TreeNode left, TreeNode right) {
            this.val = x;
            this.left = left;
            this.right = right;
        }
    }

    @SuppressWarnings("InnerClassMayBeStatic")
    public class Solution {
        public int hasPathSum(TreeNode A, int B) {

            Stack<NodeWithSum> stack = new Stack<>();
            NodeWithSum headPointer = new NodeWithSum(A, A.val);
            stack.push(headPointer);
            while (!stack.isEmpty()) {
                NodeWithSum current = stack.pop();
                if (current.treeNode.left == null && current.treeNode.right == null) {
                    if (current.sum == B) {
                        return 1;
                    }
                } else {
                    if (current.treeNode.left != null) {
                        stack.push(new NodeWithSum(current.treeNode.left, current.treeNode.left.val + current.sum));
                    }
                    if (current.treeNode.right != null) {
                        stack.push(new NodeWithSum(current.treeNode.right, current.treeNode.right.val + current.sum));
                    }
                }
            }

            return 0;
        }

        class NodeWithSum {

            final TreeNode treeNode;
            final int sum;

            NodeWithSum(TreeNode treeNode, int sum) {
                this.treeNode = treeNode;
                this.sum = sum;
            }
        }

    }


}
