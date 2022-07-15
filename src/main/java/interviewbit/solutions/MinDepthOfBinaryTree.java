package interviewbit.solutions;

/*
https://www.interviewbit.com/problems/min-depth-of-binary-tree/
 */


import ds.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MinDepthOfBinaryTree {

    public int solve(TreeNode root) {
        return new Solution().minDepth(root);
    }




    @SuppressWarnings("InnerClassMayBeStatic")
    public class Solution {
        public int minDepth(TreeNode A) {

            if (A == null) {
                return 0;
            }
            if (A.left == null && A.right == null) {
                return 1;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(A);
            int level = 0;
            while (!queue.isEmpty()) {
                ++level;
                int queueDepth = queue.size();
                for (int i = 0; i < queueDepth; i++) {
                    TreeNode temp = queue.poll();
                    assert temp != null;
                    if (temp.left == null && temp.right == null) {
                        return level;
                    }
                    if (temp.left != null) {
                        queue.add(temp.left);
                    }
                    if (temp.right != null) {
                        queue.add(temp.right);
                    }
                }
            }

            return level;
        }
    }


}
