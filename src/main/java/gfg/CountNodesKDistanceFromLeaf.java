package gfg;

import gfg.util.tree.Node;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class CountNodesKDistanceFromLeaf {

    public int printKDistantfromLeaf(Node root, int k) {
        // Write your code here
        Set<Integer> specialNodes = new HashSet<>();
        LinkedList<Node> list = new LinkedList<>();
        list.add(root);
        moveRecursive(root, list, k, specialNodes);
        return specialNodes.size();
    }

    private void moveRecursive(Node node, LinkedList<Node> list, int k, Set<Integer> specialNodes) {
        if (node.left == null && node.right == null) {
            if (k < list.size()) {
                specialNodes.add(list.get(list.size() - k - 1).data);
            }
            return;
        }
        if (node.left != null) {
            list.addLast(node.left);
            moveRecursive(node.left, list, k, specialNodes);
            list.removeLast();
        }
        if (node.right != null) {
            list.addLast(node.right);
            moveRecursive(node.right, list, k, specialNodes);
            list.removeLast();
        }

    }


}
