package leet.solutions;

/*
https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
Leetcode#235
 */


public class LowestCommonAncestorOfBinarySearchTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode solve(TreeNode root, TreeNode p, TreeNode q)
    {
        Solution solution = new Solution();
        return solution.lowestCommonAncestor(root, p, q);
    }

    @SuppressWarnings("InnerClassMayBeStatic")
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            return searchLowestCommonAncestorRecursive(root, p, q);
        }

        public TreeNode searchLowestCommonAncestorRecursive(TreeNode root, TreeNode p, TreeNode q)
        {
            if    (( (p.val>root.val) && (q.val < root.val)  )
                    || ( (q.val>root.val) && (p.val < root.val)  ))
            {
                return root;
            }
            if ((p.val==root.val) || (q.val== root.val))
            {
                return root;
            }
            if (p.val < root.val)
            {
                return searchLowestCommonAncestorRecursive(root.left, p, q);
            }
            return searchLowestCommonAncestorRecursive(root.right, p, q);
        }

    }

}
