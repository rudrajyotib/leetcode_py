package interviewbit.solutions;

/*
 * https://www.interviewbit.com/problems/root-to-leaf-paths-with-sum/
 */

import ds.util.TreeNode;

import java.util.ArrayList;

public class RootToLeafPathWithSum {

    public ArrayList<ArrayList<Integer>> solve(TreeNode A, int B){
        return new Solution().pathSum(A, B);
    }

     static class Solution {
        public ArrayList<ArrayList<Integer>> pathSum(TreeNode A, int B) {

            ArrayList<ArrayList<Integer>> result = new ArrayList<>();
            sumRecursive(A, A.val,B, new ArrayList<>() {{
                add(A.val);
            }}, result);

            return result;
        }

        private void sumRecursive(TreeNode node, int sum, int target, ArrayList<Integer> trail, ArrayList<ArrayList<Integer>> result){
            if (node == null){
                return;
            }
            if (node.left == null && node.right == null){
                if (sum == target){
                    result.add(trail);
                }
                return;
            }
            if (node.left != null){
                ArrayList<Integer> leftClone = new ArrayList<>(trail);
                leftClone.add(node.left.val);
                sumRecursive(node.left, sum+node.left.val, target, leftClone, result);
            }
            if (node.right != null){
                ArrayList<Integer> rightClone = new ArrayList<>(trail);
                rightClone.add(node.right.val);
                sumRecursive(node.right, sum+node.right.val, target, rightClone, result);
            }
        }
    }


}
