package interviewbit.solutions;

/*
https://www.interviewbit.com/problems/convert-sorted-list-to-binary-search-tree/
 */


import ds.util.ListNode;
import ds.util.TreeNode;

public class ConvertSortedListToBinarySearchTree {

    public TreeNode solve(ListNode listNode){
        return new Solution().sortedListToBST(listNode);
    }


    @SuppressWarnings("InnerClassMayBeStatic")
    public class Solution {
        public TreeNode sortedListToBST(ListNode a) {
            return buildTreeNodeRecursive(a);
        }

        private TreeNode buildTreeNodeRecursive(ListNode headNode){
            if (headNode == null){
                return null;
            }
            ListNode slowPointer = headNode;
            ListNode fastPointer = headNode;
            ListNode leftOfMid = null;
            while (fastPointer!=null && fastPointer.next != null){
                leftOfMid = slowPointer;
                slowPointer=slowPointer.next;
                fastPointer = fastPointer.next.next;
            }
            if (leftOfMid == null){
                return new TreeNode(headNode.val);
            }
            leftOfMid.next = null;
            TreeNode leftChild = buildTreeNodeRecursive(headNode);
            TreeNode rightChild = buildTreeNodeRecursive(slowPointer.next);
            slowPointer.next = null;
            TreeNode treeNode = new TreeNode(slowPointer.val);
            treeNode.left = leftChild;
            treeNode.right = rightChild;
            return treeNode;
        }


    }







}
