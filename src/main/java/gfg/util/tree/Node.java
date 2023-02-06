package gfg.util.tree;

import java.util.LinkedList;
import java.util.List;

public class Node {
    public int data;
    public Node left, right;

    public Node(int item)
    {
        data = item;
        left = right = null;
    }

    public Node(int item, Node left, Node right){
        this.data = item;
        this.left = left;
        this.right = right;
    }

    public List<Integer> inOrder(){
        List<Integer> traversal = new LinkedList<>();
        inOrderRecursive(this, traversal);
        return traversal;
    }

    private void inOrderRecursive(Node node, List<Integer> traversal){
        if (node == null){
            return;
        }
        inOrderRecursive(node.left, traversal);
        traversal.add(node.data);
        inOrderRecursive(node.right, traversal);
    }
}
