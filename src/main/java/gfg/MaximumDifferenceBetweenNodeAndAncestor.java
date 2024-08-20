/*
https://www.geeksforgeeks.org/problems/maximum-difference-between-node-and-its-ancestor/1
 */

package gfg;

import gfg.util.tree.Node;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDifferenceBetweenNodeAndAncestor {


    int maxDiff(Node root) {
        //your code here
        int diff = Integer.MIN_VALUE;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                assert node != null;
                if (node.left != null) {
                    diff = Math.max(diff, node.data - node.left.data);
                    if (node.left.data < node.data) {
                        node.left.data = node.data;
                    }
                    queue.add(node.left);
                }
                if (node.right != null) {
                    diff = Math.max(diff, node.data - node.right.data);
                    if (node.right.data < node.data) {
                        node.right.data = node.data;
                    }
                    queue.add(node.right);
                }
            }
        }

        return diff;
    }
}
