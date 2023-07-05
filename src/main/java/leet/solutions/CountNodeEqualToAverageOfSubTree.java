//https://leetcode.com/problems/count-nodes-equal-to-average-of-subtree/

package leet.solutions;

import ds.util.TreeNode;

public class CountNodeEqualToAverageOfSubTree {

    public int solve(TreeNode root){
        return new Solution().averageOfSubtree(root);
    }

    static class Solution {

        int resultCount = 0;

        public int averageOfSubtree(TreeNode root) {
            countAndCheckAverageRecursive(root);
            return resultCount;
        }

        private int[] countAndCheckAverageRecursive(TreeNode treeNode){
            if(treeNode.left == null && treeNode.right == null){
                ++resultCount;
                return new int[]{1, treeNode.val};
            }
            int sum = treeNode.val;
            int count = 1;
            if (treeNode.left != null){
                int[] leftSum = countAndCheckAverageRecursive(treeNode.left);
                sum += leftSum[1];
                count += leftSum[0];
            }
            if (treeNode.right != null){
                int[] rightSum = countAndCheckAverageRecursive(treeNode.right);
                sum += rightSum[1];
                count += rightSum[0];
            }
            int average = sum / count;
            if (treeNode.val == average){
                ++resultCount;
            }
            return new int[]{count, sum};
        }
    }

}
