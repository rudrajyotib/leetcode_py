package interviewbit.solutions;

/*
https://www.interviewbit.com/problems/preorder-traversal/
 */

import ds.util.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

public class PreOrderTraversalWithoutRecursion {

    public ArrayList<Integer> solve(TreeNode node){
        return new Solution().preorderTraversal(node);
    }




    @SuppressWarnings("InnerClassMayBeStatic")
    public class Solution {
        public ArrayList<Integer> preorderTraversal(TreeNode node) {
            if (node == null){
                return new ArrayList<>();
            }
            ArrayList<Integer> result = new ArrayList<>();
            Stack<TreeNode> recursionStack = new Stack<>();
            TreeNode headPointer = node;

            while (headPointer!=null || !recursionStack.isEmpty()){
                while (headPointer!=null){
                    result.add(headPointer.val);
                    if (headPointer.right != null){
                        recursionStack.add(headPointer.right);
                    }
                    headPointer = headPointer.left;
                }
                if (!recursionStack.isEmpty()) {
                    headPointer = recursionStack.pop();
                }
            }

            return result;
        }
    }



}
