package interviewbit.solutions;

/*
https://www.interviewbit.com/problems/inorder-traversal
 */

import java.util.ArrayList;
import java.util.Stack;

public class InorderTraversalWithoutRecursion {

    public ArrayList<Integer> solve(TreeNode root){
        return new Solution().inorderTraversal(root);
    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
        public TreeNode(int x, TreeNode left, TreeNode right) {
            val = x;
            this.left = left;
            this.right = right;
        }
    }

    @SuppressWarnings("InnerClassMayBeStatic")
    public class Solution {
        public ArrayList<Integer> inorderTraversal(TreeNode root) {

            if (root == null){
                return null;
            }

            Stack<TreeNode> stack = new Stack<>();
            TreeNode headPointer = root;
            ArrayList<Integer> inorderTraversal = new ArrayList<>();

            while (headPointer!=null || !stack.isEmpty()){
                while (headPointer!=null){
                    stack.push(headPointer);
                    headPointer = headPointer.left;
                }
                headPointer = stack.pop();
                inorderTraversal.add(headPointer.val);
                headPointer = headPointer.right;
            }


            return inorderTraversal;
        }
    }
}
