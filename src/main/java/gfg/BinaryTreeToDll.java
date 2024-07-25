/*
https://www.geeksforgeeks.org/problems/binary-tree-to-dll
 */

package gfg;

import gfg.util.tree.Node;

public class BinaryTreeToDll {

    private Node last = null;
    private Node dllHead = null;
    //Function to convert binary tree to doubly linked list and return it.
    public Node bToDLL(Node root)
    {
        //  Your code here
        last= null;
        dllHead = null;
        recur(root);
        return dllHead;
    }

    private void recur(Node node){
        if (node == null){
            return;
        }
        recur(node.left);
        if (last == null){
            last = node;
            dllHead = node;
        }else{
            last.right = node;
            node.left = last;
            last = node;
        }
        recur(node.right);
    }
}
