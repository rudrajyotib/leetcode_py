package hackerrank;

import java.util.LinkedList;

public class LowestCommonAncestorOfBinaryTree {

    public static Node lca(Node root, int v1, int v2) {
        // Write your code here.
        LinkedList<Node> v1Stack = new LinkedList<>();
        LinkedList<Node> v2Stack = new LinkedList<>();
        v1Stack.add(root);
        v2Stack.add(root);
        findPathToNode(root, v1, v1Stack);
        findPathToNode(root, v2, v2Stack);

        boolean noMoreCommonElement = false;
        Node lastKnownCommonElement = null;
        while (!noMoreCommonElement) {
            if (v1Stack.isEmpty() || v2Stack.isEmpty()) {
                noMoreCommonElement = true;
                continue;
            }
            Node v1Next = v1Stack.pollFirst();
            Node v2Next = v2Stack.pollFirst();
            if (v1Next == v2Next) {
                lastKnownCommonElement = v1Next;
            } else {
                noMoreCommonElement = true;
            }
        }
        return lastKnownCommonElement;

    }

    private static boolean findPathToNode(Node node, int target, LinkedList<Node> stack) {
        if (node.data == target) {
            return true;
        }
        if (node.left != null) {
            stack.add(node.left);
            boolean found = findPathToNode(node.left, target, stack);
            if (found) {
                return true;
            }
            stack.pollLast();
        }
        if (node.right != null) {
            stack.add(node.right);
            boolean found = findPathToNode(node.right, target, stack);
            if (found) {
                return true;
            }
            stack.pollLast();
        }
        return false;

    }
}
