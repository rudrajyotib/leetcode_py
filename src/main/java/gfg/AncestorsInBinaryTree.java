/*
https://www.geeksforgeeks.org/problems/ancestors-in-binary-tree/1
 */

package gfg;

import gfg.util.tree.Node;

import java.util.ArrayList;
import java.util.Stack;

public class AncestorsInBinaryTree {

    public ArrayList<Integer> Ancestors(Node root, int target) {
        // add your code here
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        boolean found = find(target, root, stack);
        if (found) {
            while (!stack.isEmpty()) {
                result.add(stack.pop());
            }
        }
        return result;
    }

    private boolean find(int target, Node node, Stack<Integer> stack) {
        if (node == null) {
            return false;
        }
        if (node.data == target) {
            return true;
        }
        stack.push(node.data);
        if (find(target, node.left, stack) || find(target, node.right, stack)) {
            return true;
        }
        stack.pop();
        return false;
    }

}
