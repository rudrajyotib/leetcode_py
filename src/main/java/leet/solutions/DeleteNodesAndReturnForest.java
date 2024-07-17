/*
https://leetcode.com/problems/delete-nodes-and-return-forest/
 */
package leet.solutions;

import ds.util.TreeNode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class DeleteNodesAndReturnForest {

    public List<TreeNode> solve(TreeNode root, int[] to_delete) {
        return new Solution().delNodes(root, to_delete);
    }

    static class Solution {
        public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
            Set<Integer> delete = new HashSet<>();
            for (int i : to_delete) {
                delete.add(i);
            }
            List<TreeNode> result = new LinkedList<>();
            if (delete.contains(root.val)) {
                recursiveTraversal(root, delete, result, false, true);
            } else {
                recursiveTraversal(root, delete, result, true, false);
            }
            return result;
        }

        private void recursiveTraversal(TreeNode node, Set<Integer> delete, List<TreeNode> forest, boolean root, boolean deleted) {
            if (node == null) {
                return;
            }
            TreeNode tempLeft = node.left;
            TreeNode tempRight = node.right;
            if (deleted) {
                node.left = null;
                node.right = null;
            }
            if (tempRight != null) {
                boolean childToBeDeleted = false;
                boolean childCanBeRoot = false;
                if (!delete.contains(tempRight.val)) {
                    if (deleted) {
                        childCanBeRoot = true;
                    }
                } else {
                    childToBeDeleted = true;
                    node.right = null;
                }
                recursiveTraversal(tempRight, delete, forest, childCanBeRoot, childToBeDeleted);
            }
            if (tempLeft != null) {
                boolean childToBeDeleted = false;
                boolean childCanBeRoot = false;
                if (!delete.contains(tempLeft.val)) {
                    if (deleted) {
                        childCanBeRoot = true;
                    }
                } else {
                    childToBeDeleted = true;
                    node.left = null;
                }
                recursiveTraversal(tempLeft, delete, forest, childCanBeRoot, childToBeDeleted);
            }
            if (!deleted && root) {
                forest.add(node);
            }
        }
    }
}
