package interviewbit.solutions;

import ds.util.TreeNode;

public class SortedArrayToBalancedBST {

    public TreeNode solve(final int[] sortedArray){
        return new Solution().sortedArrayToBST(sortedArray);
    }

    static class Solution {
        // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
        public TreeNode sortedArrayToBST(final int[] A) {
            if (A == null || A.length == 0) {
                return null;
            }
            return createBinarySearchTreeRecursive(0, A.length - 1, A);
        }

        private TreeNode createBinarySearchTreeRecursive(int startIndex, int endIndex, int[] sortedArray) {
            if (startIndex > endIndex) {
                return null;
            }
            int mid = (startIndex + endIndex) / 2;
            TreeNode root = new TreeNode(sortedArray[mid]);
            root.left = createBinarySearchTreeRecursive(startIndex, mid - 1, sortedArray);
            root.right = createBinarySearchTreeRecursive(mid + 1, endIndex, sortedArray);
            return root;
        }

    }
}
