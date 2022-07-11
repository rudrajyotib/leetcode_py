package interviewbit.solutions;

/*
https://www.interviewbit.com/problems/bst-iterator/
 */

import java.util.Stack;

public class BinarySearchTreeIterator {

      static public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
          TreeNode(int x, TreeNode left, TreeNode right){
              this.val = x;
              this.left = left;
              this.right = right;
          }
      }

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
