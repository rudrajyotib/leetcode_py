package leet.solutions;

/*
https://leetcode.com/problems/even-odd-tree/
Leetcode#1609
 */

import java.util.LinkedList;

public class EvenOddTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        @SuppressWarnings("unused")
        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean solve(TreeNode root) {
        Solution solution = new Solution();
        return solution.isEvenOddTree(root);
    }


    @SuppressWarnings("InnerClassMayBeStatic")
    class Solution {
        public boolean isEvenOddTree(TreeNode root) {
            if (root == null) {
                return false;
            }
            boolean evenIndex = true;
            int lastNodeInLevel = 0;
            int childrenInNextLevel = 0;
            int childrenInCurrentLevel = 1;
            LinkedList<TreeNode> traversal = new LinkedList<>();
            traversal.addLast(root);
            if (root.val % 2 == 0) {
                return false;
            }
            while (!traversal.isEmpty()) {
                for (int i = 0; i < childrenInCurrentLevel; i++) {
                    TreeNode currentNode = traversal.pollFirst();
                    assert currentNode != null;
                    if (i > 0) {
                        if (evenIndex) {
                            if (currentNode.val <= lastNodeInLevel) {
                                return false;
                            }
                        }else
                        {
                            if (currentNode.val >= lastNodeInLevel) {
                                return false;
                            }
                        }
                    }
                    lastNodeInLevel = currentNode.val;
                    if (currentNode.left != null) {
                        if (checkExpectedEvenOdd(evenIndex, currentNode.left.val)) {
                            traversal.addLast(currentNode.left);
                        } else {
                            return false;
                        }
                        ++childrenInNextLevel;
                    }
                    if (currentNode.right != null) {
                        if (checkExpectedEvenOdd(evenIndex, currentNode.right.val)) {
                            traversal.addLast(currentNode.right);
                        } else {
                            return false;
                        }
                        ++childrenInNextLevel;
                    }
                }
                childrenInCurrentLevel = childrenInNextLevel;
                childrenInNextLevel = 0;
                evenIndex = !evenIndex;
            }
            return true;
        }

        private boolean checkExpectedEvenOdd(boolean evenIndex, int value) {
            if (evenIndex) {
                return value % 2 == 0;
            } else {
                return value % 2 == 1;
            }
        }
    }

}
