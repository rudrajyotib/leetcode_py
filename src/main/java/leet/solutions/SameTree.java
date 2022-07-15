package leet.solutions;

/*
https://leetcode.com/problems/same-tree/
Leetcode#100
 */

import ds.util.TreeNode;

public class SameTree {




      public boolean solve(TreeNode p, TreeNode q)
      {
        Solution solution = new Solution();
        return solution.isSameTree(p, q);
      }

    @SuppressWarnings("InnerClassMayBeStatic")
    class Solution {
        public boolean isSameTree(TreeNode p, TreeNode q) {
            return checkRecursive(p, q);
        }

        private boolean checkRecursive(TreeNode p, TreeNode q) {
            if ((p == null) && (q == null)) {
                return true;
            }
            if ((p != null) && (q == null)) {
                return false;
            }
            if (p == null) {
                return false;
            }
            if (p.val != q.val) {
                return false;
            }
            return checkRecursive(p.left, q.left) && checkRecursive(p.right, q.right);

        }
    }
}
