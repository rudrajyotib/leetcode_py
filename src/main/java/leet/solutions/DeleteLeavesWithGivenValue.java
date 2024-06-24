/*
https://leetcode.com/problems/delete-leaves-with-a-given-value/description
 */

package leet.solutions;

import ds.util.TreeNode;

public class DeleteLeavesWithGivenValue {


    public TreeNode solve(TreeNode root, int target){
        return new Solution().removeLeafNodes(root, target);
    }

    static class Solution {
        public TreeNode removeLeafNodes(TreeNode root, int target) {
            deleteLeafRecursive(root, target);
            if (root.left == null && root.right == null && root.val == target){
                return null;
            }
            return root;
        }

        private boolean deleteLeafRecursive(TreeNode node, int target){
            if (node == null){
                return true;
            }
            if (deleteLeafRecursive(node.left, target) ){
                node.left = null;
            }
            if (deleteLeafRecursive(node.right, target) ) {
                node.right = null;
            }
            return node.left == null && node.right == null && node.val == target;
        }
    }
}
