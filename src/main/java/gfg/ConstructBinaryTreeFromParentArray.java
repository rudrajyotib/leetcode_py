/*
https://www.geeksforgeeks.org/problems/construct-binary-tree-from-parent-array
 */

package gfg;

import gfg.util.tree.Node;

public class ConstructBinaryTreeFromParentArray {


    public Node createTree(int[] parent) {
        // Your code here
        Node[] nodeArray = new Node[parent.length];
        int rootIndex = 0;
        for (int i = 0; i < parent.length; i++) {
            if (nodeArray[i] == null) {
                nodeArray[i] = new Node(i);
            }
            if (parent[i] == -1) {
                rootIndex = i;
                continue;
            }
            if (nodeArray[parent[i]] == null) {
                nodeArray[parent[i]] = new Node(parent[i]);
            }
            if (nodeArray[parent[i]].left == null) {
                nodeArray[parent[i]].left = nodeArray[i];
            } else {
                nodeArray[parent[i]].right = nodeArray[i];
            }
        }

        return nodeArray[rootIndex];

    }
}
