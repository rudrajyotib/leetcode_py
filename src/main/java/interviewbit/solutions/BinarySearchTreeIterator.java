package interviewbit.solutions;

/*
https://www.interviewbit.com/problems/bst-iterator/
 */

import ds.util.TreeNode;

import java.util.Stack;

public class BinarySearchTreeIterator {



    public static class Solution {

          private final Stack<TreeNode> stack;

        public Solution(TreeNode root) {
            stack = new Stack<>();
            pushIntoStack(root);
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }

        public int next() {
            TreeNode top = stack.pop();
            if (top.right != null){
                pushIntoStack(top.right);
            }
            return top.val;
        }

        private void pushIntoStack(TreeNode node){
            if (node == null){
                return;
            }
            stack.push(node);
            TreeNode leftIterator = node.left;
            while (leftIterator != null){
                stack.push(leftIterator);
                leftIterator = leftIterator.left;
            }
        }
    }
    
    
}
