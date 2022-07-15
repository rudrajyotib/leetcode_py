package leet.solutions;

/*
https://leetcode.com/problems/recover-binary-search-tree/
Leetcode#99
 */

import ds.util.TreeNode;

public class RecoverBinarySearchTree {


    public void solve(TreeNode rootNode)
    {
        Solution solution = new Solution();
        solution.recoverTree(rootNode);
    }





    static class Solution {

        private TreeNode firstAnomalyDetectionPoint = null;
        private TreeNode firstPointOfAnomaly = null;
        private TreeNode secondPointOfAnomaly = null;
        private TreeNode lastVisitedNode;

        public void recoverTree(TreeNode root) {
            this.firstAnomalyDetectionPoint = null;
            this.firstPointOfAnomaly = null;
            this.secondPointOfAnomaly = null;
            this.lastVisitedNode = null;
            detectAnomaly(root);
            if (firstAnomalyDetectionPoint == null)
            {
                return;
            }
            if (this.secondPointOfAnomaly == null)
            {
                int temp = this.firstAnomalyDetectionPoint.val;
                this.firstAnomalyDetectionPoint.val = this.firstPointOfAnomaly.val;
                this.firstPointOfAnomaly.val = temp;
            }else
            {
                int temp = this.firstPointOfAnomaly.val;
                this.firstPointOfAnomaly.val = this.secondPointOfAnomaly.val;
                this.secondPointOfAnomaly.val = temp;
            }
        }

        private void detectAnomaly(TreeNode rootNode)
        {
            if (rootNode == null)
            {
                return;
            }
            if (rootNode.left != null)
            {
                detectAnomaly(rootNode.left);
            }
            if ((this.lastVisitedNode != null) && (this.lastVisitedNode.val > rootNode.val))
            {
                if (firstAnomalyDetectionPoint == null)
                {
                    this.firstAnomalyDetectionPoint = rootNode;
                    this.firstPointOfAnomaly = this.lastVisitedNode;
                }else
                {
                    this.secondPointOfAnomaly = rootNode;
                }
            }
            this.lastVisitedNode = rootNode;
            detectAnomaly(rootNode.right);
        }
    }

}
