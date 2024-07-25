/*
https://www.geeksforgeeks.org/problems/diameter-of-binary-tree
 */

package gfg;

import gfg.util.tree.Node;

public class DiameterOfBinaryTree {

    public int solve(Node root){
        return new Solution().diameter(root);
    }

    public static class Solution {
        // Function to return the diameter of a Binary Tree.

        int dia = 0;

        public int diameter(Node root) {
            // Your code here
            this.dia = 0;
            recur(root);
            return this.dia;
        }

        private int recur(Node node){
            if (node == null){
                return 0;
            }
            int l = recur(node.left);
            int r = recur(node.right);
            this.dia = Math.max(this.dia, (l + r + 1) );
            return Math.max(l,r)+1;
        }
    }
}
