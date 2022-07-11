package interviewbit.solutions;

/*
https://www.interviewbit.com/problems/postorder-traversal/
 */


import java.util.ArrayList;
import java.util.Stack;

public class PostOrderTraversalWithoutRecursion {


    public ArrayList<Integer> solve(TreeNode root){
        return new Solution().postorderTraversal(root);
    }

      static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) {
           val = x;
           left=null;
           right=null;
          }

          TreeNode(int x, TreeNode left, TreeNode right){
              this.val = x;
              this.left = left;
              this.right = right;
          }
      }
    @SuppressWarnings("InnerClassMayBeStatic")
    public class Solution {
        public ArrayList<Integer> postorderTraversal(TreeNode A) {
            ArrayList<Integer> result = new ArrayList<>();

            VisitTracker headPointer = new VisitTracker(A);
            Stack<VisitTracker> stack = new Stack<>();


            while (headPointer.treeNode!=null || !stack.isEmpty()){
                while (headPointer.treeNode != null){

                    headPointer.right = true;
                    stack.push(headPointer);
                    if (headPointer.treeNode.right != null) {
                        stack.push(new VisitTracker(headPointer.treeNode.right));
                    }
                    headPointer = new VisitTracker(headPointer.treeNode.left);
                }
                if (!stack.isEmpty()){
                    VisitTracker next = stack.pop();
                    if (next.right){
                        result.add(next.treeNode.val);
                    }else{

                        next.right = true;
                        stack.push(next);
                        if (next.treeNode.right != null){
                            stack.push(new VisitTracker(next.treeNode.right));
                        }
                        headPointer = new VisitTracker(next.treeNode.left);
                    }
                }

            }



            return result;

        }

        class VisitTracker{



            TreeNode treeNode;
            boolean right;

            VisitTracker(TreeNode node){
                this.treeNode = node;
            }
        }
    }
    
}
