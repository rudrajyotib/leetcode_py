package leet.solutions;

/*
https://leetcode.com/problems/maximum-depth-of-binary-tree/
Leetcode#104
 */


import ds.util.TreeNode;

public class MaximumDepthOfBinaryTree {



        public int solve(TreeNode root)
        {
            Solution solution = new Solution();
            return solution.maxDepth(root);
        }

        @SuppressWarnings("InnerClassMayBeStatic")
        class Solution {
            public int maxDepth(TreeNode root) {
                if (root == null)
                {
                    return 0;
                }
                return maxDepth(root, 1);
            }

            private int maxDepth(TreeNode node, int level)
            {
                if (node == null)
                {
                    return 0;
                }
                return Math.max(
                        level,
                        Math.max(maxDepth(node.left, level+1),
                        maxDepth(node.right, level+1))
                );
            }
        }



}
