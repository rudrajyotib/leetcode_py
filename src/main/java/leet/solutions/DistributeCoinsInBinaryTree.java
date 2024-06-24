/*
https://leetcode.com/problems/distribute-coins-in-binary-tree/
 */

package leet.solutions;

import ds.util.TreeNode;

public class DistributeCoinsInBinaryTree {


    public int solve(TreeNode root){
        return new Solution().distributeCoins(root);
    }

    static class Solution {
        int moves = 0;
        public int distributeCoins(TreeNode root) {
            moveRecursive(root);
            return moves;
        }

        private int moveRecursive(TreeNode node){
            if (node == null) {
                return 0;
            }
            int leftExcess = moveRecursive(node.left);
            int rightExcess = moveRecursive(node.right);
            int excess = leftExcess + rightExcess + node.val - 1;
            moves += Math.abs(excess);
            return excess;
        }
    }

}
