/*
https://www.geeksforgeeks.org/problems/left-view-of-binary-tree/1
 */

package gfg;

import gfg.util.tree.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LeftVIewOfBinaryTree {
    ArrayList<Integer> leftView(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 1; i <= size; i++) {
                Node left = queue.remove();
                assert left != null;
                if (i == 1) {
                    result.add(left.data);
                }
                if (left.left != null) {
                    queue.add(left.left);
                }
                if (left.right != null) {
                    queue.add(left.right);
                }
            }
        }
        return result;
        // Your code here
    }
}
