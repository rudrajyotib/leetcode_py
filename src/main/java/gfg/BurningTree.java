/*
https://www.geeksforgeeks.org/problems/burning-tree/1
 */

package gfg;

import gfg.util.tree.Node;

public class BurningTree {

//    private static int maxTime = 0;

    private static class MaxTime {
        int time = 0;

        public void update(int minutes) {
            if (minutes > time) {
                this.time = minutes;
            }
        }
    }

    public static int minTime(Node root, int target) {
        MaxTime maxTime = new MaxTime();
        find(root, target, false, 0, maxTime);
        return maxTime.time;
    }

    private static int find(Node node, int target, boolean burnMode, int minutes, MaxTime maxTime) {
        if (node == null) {
            return 0;
        }
        maxTime.update(minutes);
        if (burnMode) {
            Node left = node.left;
            Node right = node.right;
            node.left = null;
            node.right = null;
            find(left, target, true, minutes + 1, maxTime);
            find(right, target, true, minutes + 1, maxTime);
            return 0;
        } else {
            if (node.data == target) {
                return 1;
            }
            int leftMinutes = find(node.left, target, false, 0, maxTime);
            int rightMinutes = find(node.right, target, false, 0, maxTime);
            if (leftMinutes >= 1) {
                Node right = node.right;
                node.right = null;
                find(right, target, true, leftMinutes + 1, maxTime);
                return leftMinutes + 1;
            }
            if (rightMinutes >= 1) {
                Node left = node.left;
                node.left = null;
                find(left, target, true, rightMinutes + 1, maxTime);
                return rightMinutes + 1;
            } else {
                return 0;
            }
        }
    }
}
