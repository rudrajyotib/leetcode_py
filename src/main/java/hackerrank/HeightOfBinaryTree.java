/*
https://www.hackerrank.com/challenges/tree-height-of-a-binary-tree
 */

package hackerrank;

public class HeightOfBinaryTree {

    public static int height(Node root) {
        // Write your code here.
        return recursiveHeight(root);
    }

    private static int recursiveHeight(Node root){
        if (root == null){
            return -1;
        }
        return Math.max(height(root.left), height(root.right))+1;
    }

}
