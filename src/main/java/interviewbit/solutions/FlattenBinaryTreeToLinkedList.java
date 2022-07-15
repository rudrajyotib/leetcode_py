package interviewbit.solutions;

/*
https://www.interviewbit.com/problems/flatten-binary-tree-to-linked-list/
 */

import ds.util.TreeNode;

public class FlattenBinaryTreeToLinkedList {


    public TreeNode solve(TreeNode a){
        return new Solution().flatten(a);
    }



    @SuppressWarnings("InnerClassMayBeStatic")
    public class Solution {
        public TreeNode flatten(TreeNode a) {

            if (a == null){
                return null;
            }
            flattenRecursive(a);
            return a;
        }

        private void flattenRecursive(TreeNode node){
            if (node == null){
                return;
            }
            if (node.left ==null && node.right == null){
                return;
            }
            if(node.left != null){
                flatten(node.left);
                TreeNode temp = node.right;
                node.right = node.left;
                node.left = null;
                TreeNode rightHead = node.right;
                while (rightHead.right != null){
                    rightHead = rightHead.right;
                }
                rightHead.right = temp;
            }
            flatten(node.right);

        }

    }

}
