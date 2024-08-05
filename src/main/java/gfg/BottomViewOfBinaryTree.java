/*
https://www.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1#
 */

package gfg;

import gfg.util.tree.Node;

import java.util.*;

public class BottomViewOfBinaryTree {


    public ArrayList<Integer> bottomView(Node root)
    {
        ArrayList<Integer> result = new ArrayList<>();
        Map<Integer, Node> map = new HashMap<>();
        Queue<NodeWithPos> bfsQueue = new LinkedList<>();
        bfsQueue.add(new NodeWithPos(root, 0));
        int minLeft = 0;
        int maxRight = 0;
        while (!bfsQueue.isEmpty()){
            int size = bfsQueue.size();
            for (int i=0;i<size;i++){
                NodeWithPos nodeWithPos = bfsQueue.remove();
                map.put(nodeWithPos.pos, nodeWithPos.node);
                minLeft = Math.min(minLeft, nodeWithPos.pos);
                maxRight = Math.max(maxRight, nodeWithPos.pos);
                if (nodeWithPos.node.left != null){
                    bfsQueue.add(new NodeWithPos(nodeWithPos.node.left, nodeWithPos.pos - 1));
                }
                if (nodeWithPos.node.right != null){
                    bfsQueue.add(new NodeWithPos(nodeWithPos.node.right, nodeWithPos.pos + 1));
                }
            }
        }
        for (int i = minLeft; i <=maxRight;i++){
            if (map.containsKey(i)){
                result.add(map.get(i).data);
            }
        }

        return result;
    }

    static class NodeWithPos{
        final Node node;
        final int pos;

        NodeWithPos(Node node, int pos) {
            this.node = node;
            this.pos = pos;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj){
                return true;
            }
            if (!(obj instanceof NodeWithPos)){
                return false;
            }
            NodeWithPos other = (NodeWithPos) obj;
            return other.node == this.node;
        }

        @Override
        public int hashCode() {
            return Objects.hash(node);
        }
    }
}
