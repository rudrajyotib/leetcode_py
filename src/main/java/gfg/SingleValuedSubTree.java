package gfg;

/*
https://practice.geeksforgeeks.org/problems/single-valued-subtree/1
 */

import gfg.util.tree.Node;

public class SingleValuedSubTree {

    public int solve(Node root){
        return new Solution().singlevalued(root);
    }

    static class Solution
    {
        int count = 0;
        public int singlevalued(Node root)
        {
            //code here
            dfs(root);
            return count;
        }

        private boolean dfs(Node node){
            if (node.left == null && node.right == null){
                ++count;
                return true;
            }
            int leftVal = node.left != null ? node.left.data : node.data;
            int rightVal = node.right != null ? node.right.data : node.data;
            boolean leftSame = node.left == null || dfs(node.left);
            boolean rightSame = node.right == null || dfs(node.right);
            if (leftVal == rightVal && leftVal == node.data && leftSame && rightSame){
                ++count;
                return true;
            }
            return false;
        }
    }

}
