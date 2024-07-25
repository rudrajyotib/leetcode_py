package gfg;

import gfg.util.tree.Node;

public class SumTree {

    private boolean isSum = true;

    public boolean isSumTree(Node root)
    {
        // Your code here
        this.isSum = true;
        recur(root);
        return this.isSum;
    }

    private int recur(Node node){
        if (node == null){
            return 0;
        }
        if (node.left == null && node.right == null){
            return node.data;
        }
        int l = recur(node.left);
        int r = recur(node.right);

        if (node.data != (l + r)){
            this.isSum = false;
            return 0;
        }
        return node.data + l + r;
    }
}
