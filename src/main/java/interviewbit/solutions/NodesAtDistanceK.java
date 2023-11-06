package interviewbit.solutions;

/*
https://www.interviewbit.com/problems/nodes-at-distance-k/
 */

import ds.util.TreeNode;

import java.util.ArrayList;

public class NodesAtDistanceK {


    public ArrayList<Integer> solve(TreeNode treeNode, int node, int distance){
        return new Solution().distanceK(treeNode, node, distance);
    }

    static class Solution {
        public ArrayList<Integer> distanceK(TreeNode treeNode, int targetNode, int distance) {

            ArrayList<Integer> result = new ArrayList<>();
            identifyNodeAtDistanceAndTraverse(treeNode, targetNode, distance, result);
            return result;
        }

        private int identifyNodeAtDistanceAndTraverse(TreeNode treeNode, int target, int distance, ArrayList<Integer> result){
            if (treeNode == null){
                return -1;
            }
            if (treeNode.val == target){
                traverseDistance(treeNode.left, distance-1, result);
                traverseDistance(treeNode.right, distance-1, result);
                return 0;
            }
            int distanceToTargetAtRight = identifyNodeAtDistanceAndTraverse(treeNode.right, target, distance, result);
            if (distanceToTargetAtRight != -1){
                if (distanceToTargetAtRight == distance){
                    result.add(treeNode.val);
                }else{
                    traverseDistance(treeNode.left, distance-distanceToTargetAtRight-2, result);
                }
                return 1 + distanceToTargetAtRight;
            }
            int distanceToTargetAtLeft = identifyNodeAtDistanceAndTraverse(treeNode.left, target, distance, result);
            if (distanceToTargetAtLeft != -1){
                if (distanceToTargetAtLeft == distance){
                    result.add(treeNode.val);
                }else{
                    traverseDistance(treeNode.right, distance-distanceToTargetAtLeft-2, result);
                }
                return 1 + distanceToTargetAtLeft;
            }
            return -1;
        }

        private void traverseDistance(TreeNode treeNode, int distance, ArrayList<Integer> result){
            if (treeNode == null){
                return;
            }
            if (distance < 0){
                return;
            }
            if (distance == 0){
                result.add(treeNode.val);
            }
            traverseDistance(treeNode.left, distance-1, result);
            traverseDistance(treeNode.right, distance-1, result);
        }


    }

}
