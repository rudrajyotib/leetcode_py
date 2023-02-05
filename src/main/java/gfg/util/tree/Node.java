package gfg.util.tree;

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
}
