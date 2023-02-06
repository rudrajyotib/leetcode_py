package gfg;

/*
https://practice.geeksforgeeks.org/problems/c85e3a573a7de6dfd18398def16d05387852b319/1
 */

import gfg.util.tree.Node;

public class BstDownwardTraversal {

    public long solve(Node root, int target) {
        return new Solution().verticallyDownBST(root, target);
    }

    static class Solution {
        long sum = 0L;

        long verticallyDownBST(Node root, int target) {
            boolean targetFound = false;
            Node iter = root;
            while (!targetFound && iter != null) {
                if (target == iter.data) {
                    targetFound = true;
                } else {
                    if (target > iter.data) {
                        iter = iter.right;
                    } else {
                        iter = iter.left;
                    }
                }
            }
            if (iter == null) {
                return -1;
            }

            if (iter.left != null) {
                dfs(iter.left, -1);
            }
            if (iter.right != null) {
                dfs(iter.right, 1);
            }

            return sum;
        }

        private void dfs(Node node, int drift) {
            if (drift == 0) {
                sum += node.data;
            }
            if (node.left != null) {
                dfs(node.left, drift - 1);
            }
            if (node.right != null) {
                dfs(node.right, drift + 1);
            }
        }
    }

}
