/*
https://www.geeksforgeeks.org/problems/print-a-binary-tree-in-vertical-order
 */

package gfg;

import gfg.util.tree.Node;

import java.util.*;

public class VerticalTraversalOfBinaryTree {


    static ArrayList<Integer> verticalOrder(Node root) {
        // add your code here
        Queue<NodeWithLevel> queue = new LinkedList<>();
        Map<Integer, List<Node>> map = new HashMap<>();
        queue.add(new NodeWithLevel(0, root));
        int nodeCount = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                ++nodeCount;
                NodeWithLevel n = queue.remove();
                if (!map.containsKey(n.level)) {
                    map.put(n.level, new LinkedList<>());
                }
                map.get(n.level).add(n.node);
                if (n.node.left != null) {
                    queue.add(new NodeWithLevel(n.level - 1, n.node.left));
                }
                if (n.node.right != null) {
                    queue.add(new NodeWithLevel(n.level + 1, n.node.right));
                }
            }
        }
        ArrayList<Integer> result = new ArrayList<>(nodeCount);
        map.entrySet().stream().sorted(Comparator.comparingInt(Map.Entry::getKey))
                .forEach(integerListEntry -> integerListEntry.getValue().stream().map(node -> node.data).forEach(result::add));
        return result;
    }

    public static class NodeWithLevel {
        private final int level;
        private final Node node;

        public NodeWithLevel(int level, Node node) {
            this.level = level;
            this.node = node;
        }

    }
}
