package gfg;

/*
https://practice.geeksforgeeks.org/problems/d7e0ce338b11f0be36877d9c35cc8dfad6636957/1
 */

import gfg.util.tree.Node;

public class TransformToSumTree {


    public void solve(Node root){
        new Solution().toSumTree(root);
    }

    static class Solution{
        public void toSumTree(Node root){
            //add code here.
            transform(root);
        }

        private int transform(Node node){
            if (node == null){
                return 0;
            }
            if (node.left == null && node.right == null){
                int temp = node.data;
                node.data = 0;
                return temp;
            }
            int leftSum = transform(node.left);
            int rightSum = transform(node.right);
            int temp = node.data + leftSum + rightSum;
            node.data =  leftSum + rightSum;
            return temp;
        }
    }
}
