package interviewbit.solutions;

/*
https://www.interviewbit.com/problems/least-common-ancestor/
 */


import ds.util.TreeNode;

public class LeastCommonAncestor {

    public int solve(TreeNode root, int a, int b){
        return new Solution().lca(root, a, b);
    }


    @SuppressWarnings("InnerClassMayBeStatic")
    public class Solution {
        public int lca(TreeNode root, int a, int b) {

            if (root == null){
                return -1;
            }
            if (root.val==a && root.val==b){
                return root.val;
            }

            String pathOfA = calculateRoute(root, "", a);
            if (pathOfA.equals("XX")){
                return -1;
            }
            String pathOfB = calculateRoute(root, "", b);
            if (pathOfB.equals("XX")){
                return -1;
            }
            if (pathOfA.isEmpty() || pathOfB.isEmpty()){
                return root.val;
            }
            TreeNode lowestCommonAncestor = root;
            int pathCounter = 0;
            while (pathCounter<pathOfA.length() && pathCounter<pathOfB.length()){
                if (pathOfA.charAt(pathCounter) == pathOfB.charAt(pathCounter)){
                    lowestCommonAncestor = (pathOfA.charAt(pathCounter)=='L') ? lowestCommonAncestor.left : lowestCommonAncestor.right;
                    ++pathCounter;
                }else{
                    return lowestCommonAncestor.val;
                }

            }

            return lowestCommonAncestor.val;
        }

        private String calculateRoute(TreeNode node, String prefix, int target){
            if (node.val == target){
                return prefix;
            }
            String leftPath = node.left != null ? calculateRoute(node.left, prefix+"L", target) : "XX";
            if (leftPath.equals("XX")){
                return node.right != null ? calculateRoute(node.right, prefix+"R", target) : "XX";
            }
            return leftPath;
        }


    }



}
