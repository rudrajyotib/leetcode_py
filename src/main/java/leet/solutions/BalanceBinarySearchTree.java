package leet.solutions;

import ds.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BalanceBinarySearchTree {


    public TreeNode solve(TreeNode root){
        return new Solution().balanceBST(root);
    }

    static class Solution {
        public TreeNode balanceBST(TreeNode root) {
            List<Integer> inOrder = new ArrayList<>();
            inOrderRecursive(root, inOrder);
            return constructBinaryTreeFromInOrderRecursive(inOrder, 0, inOrder.size()-1);
        }

        private TreeNode constructBinaryTreeFromInOrderRecursive(List<Integer> inOrder, int startIndex, int endIndex){
            if (startIndex>endIndex){
                return null;
            }
            if (startIndex == endIndex){
                return new TreeNode(inOrder.get(startIndex));
            }
            int mid = (startIndex + endIndex) / 2;
            TreeNode node = new TreeNode(inOrder.get(mid));
            node.left = constructBinaryTreeFromInOrderRecursive(inOrder, startIndex, mid-1);
            node.right = constructBinaryTreeFromInOrderRecursive(inOrder, mid+1, endIndex);
            return node;
        }

        private void inOrderRecursive(TreeNode node, List<Integer> inOrderResult){
            if (node == null){
                return;
            }
            inOrderRecursive(node.left, inOrderResult);
            inOrderResult.add(node.val);
            inOrderRecursive(node.right, inOrderResult);
        }

    }

}
