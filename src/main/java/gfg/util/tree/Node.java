package gfg.util.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

    public List<Integer> preOrder(){
        List<Integer> traversal = new LinkedList<>();
        preOrderRecursive(this, traversal);
        return traversal;
    }

    private void preOrderRecursive(Node node, List<Integer> traversal){
        if (node == null){
            return;
        }
        traversal.add(node.data);
        preOrderRecursive(node.left, traversal);
        preOrderRecursive(node.right, traversal);
    }

    private void inOrderRecursive(Node node, List<Integer> traversal){
        if (node == null){
            return;
        }
        inOrderRecursive(node.left, traversal);
        traversal.add(node.data);
        inOrderRecursive(node.right, traversal);
    }

    public List<Integer> levelOrder(){
        List<Integer> list = new LinkedList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(this);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i=0;i<size;i++){
                Node node = queue.remove();
                list.add(node.data);
                if (node.left != null){
                    queue.add(node.left);
                }
                if (node.right != null){
                    queue.add(node.right);
                }
            }
        }
        return list;
    }
}
