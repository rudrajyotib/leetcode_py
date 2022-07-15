package interviewbit.solutions;

/*
https://www.interviewbit.com/problems/recover-binary-search-tree/
 */

import ds.util.TreeNode;

import java.util.Stack;

public class RecoverBinarySearchTree {

    public int[] solve(TreeNode root) {
        return new Solution().recoverTree(root);
    }



    @SuppressWarnings("InnerClassMayBeStatic")
    class Solution {
        public int[] recoverTree(TreeNode root) {
            int[] result = new int[2];

            if (root == null){
                return result;
            }

            Stack<TreeNode> stack = new Stack<>();
            TreeNode headPointer = root;
            TreeNode firstAnomaly = null;
            TreeNode firstAnomalyDiagnosedAt = null;
            TreeNode secondAnomaly = null;
            TreeNode lastVisitedNode = null;

            while ((headPointer!=null) || !stack.isEmpty()){
                while ( headPointer!= null){
                    stack.push(headPointer);
                    headPointer = headPointer.left;
                }
                headPointer = stack.pop();
                if (lastVisitedNode != null) {
                    if (headPointer.val < lastVisitedNode.val) {
                        if (firstAnomaly == null) {
                            firstAnomaly = lastVisitedNode;
                            firstAnomalyDiagnosedAt = headPointer;
                        } else {
                            secondAnomaly = headPointer;
                        }
                    }
                }
                lastVisitedNode = headPointer;
                headPointer = headPointer.right;
            }

            if (firstAnomaly == null){
                return result;
            }
            if (secondAnomaly != null){
                result[0] = secondAnomaly.val;
            }else{
                result[0] = firstAnomalyDiagnosedAt.val;
            }
            result[1] = firstAnomaly.val;



            return result;
        }
    }

}
