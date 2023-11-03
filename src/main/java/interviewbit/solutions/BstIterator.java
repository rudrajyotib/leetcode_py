package interviewbit.solutions;

import ds.util.TreeNode;

import java.util.Stack;

public class BstIterator {

    static class Solution {

        private final Stack<TreeNode> stack = new Stack<>();

        public Solution(TreeNode root) {
            stackUpLeftChildren(root);
        }

        private void stackUpLeftChildren(TreeNode node){
            while (node != null){
                stack.push(node);
                node = node.left;
            }
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        /** @return the next smallest number */
        public int next() {
            TreeNode popped = stack.pop();
            stackUpLeftChildren(popped.right);
            return popped.val;
        }
    }



}
