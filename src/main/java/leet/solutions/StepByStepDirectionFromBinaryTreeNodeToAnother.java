/*
https://leetcode.com/problems/step-by-step-directions-from-a-binary-tree-node-to-another/description/
 */


package leet.solutions;

import ds.util.TreeNode;

import java.util.Stack;

public class StepByStepDirectionFromBinaryTreeNodeToAnother {


    public String solve(TreeNode root, int start, int destination) {
        return new Solution().getDirections(root, start, destination);
    }

    static class Solution {
        public String getDirections(TreeNode root, int startValue, int destValue) {
            Stack<String> route = new Stack<>();
            if (startValue == root.val) {
                stackRoute(route, root, destValue);
                return String.join("", route);
            }
            if (destValue == root.val) {
                stackRoute(route, root, startValue);
                return "U".repeat(route.size());
            }
            stackRoute(route, root, startValue);
            String startRoute = String.join("", route);
            route.clear();
            stackRoute(route, root, destValue);
            String destRoute = String.join("", route);
            int matchingRoute = 0;
            while (matchingRoute < destRoute.length()
                    && matchingRoute < startRoute.length()
                    && startRoute.charAt(matchingRoute) == destRoute.charAt(matchingRoute)) {
                ++matchingRoute;
            }
            return String.format("%s%s",
                    startRoute.substring(matchingRoute).replaceAll("L", "U").replaceAll("R", "U"),
                    destRoute.substring(matchingRoute)
            );
        }

        private boolean stackRoute(Stack<String> routeThisFar, TreeNode node, int target) {
            if (node.val == target) {
                return true;
            }
            if (node.right != null) {
                routeThisFar.push("R");
                boolean found = stackRoute(routeThisFar, node.right, target);
                if (found) {
                    return true;
                }
                routeThisFar.pop();
            }
            if (node.left != null) {
                routeThisFar.push("L");
                boolean found = stackRoute(routeThisFar, node.left, target);
                if (found) {
                    return true;
                }
                routeThisFar.pop();
            }
            return false;
        }
    }
}
