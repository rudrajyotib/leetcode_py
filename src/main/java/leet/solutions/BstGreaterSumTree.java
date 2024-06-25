/*
https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree
 */

package leet.solutions;

import ds.util.TreeNode;

public class BstGreaterSumTree {

    public TreeNode solve(TreeNode node){
        return new Solution().bstToGst(node);
    }

    static class Solution {
        public TreeNode bstToGst(TreeNode root) {
            int sumFromRootRight = addSumGst(root.right, 0);
            root.val += sumFromRootRight;
            addSumGst(root.left, root.val);
            return root;
        }

        private int addSumGst(TreeNode node, int offset){
            if (node ==  null){
                return 0;
            }
            if (node.left == null && node.right == null){
                int temp = node.val;
                node.val += offset;
                return temp;
            }
            int sumFromRight = addSumGst(node.right, offset);
            int tempNodeVal = node.val + sumFromRight;
            node.val = node.val + offset + sumFromRight;
            int sumFromLeft = addSumGst(node.left , node.val);
            return tempNodeVal + sumFromLeft;

        }
    }

}
