/*
https://www.geeksforgeeks.org/problems/check-if-subtree/
 */

package gfg;

import gfg.util.tree.Node;

public class CheckIfSubtree {

    public static boolean isSubtree(Node T, Node S) {
        // add code here.
        return isSubtreeRecursive(T, S);
    }

    private static boolean isSubtreeRecursive(Node main, Node sub){
        if (main == null){
            return false;
        }
        if (main.data == sub.data){
            if (isSame(main, sub)){
                return true;
            }
        }
        return isSubtreeRecursive(main.left, sub) || isSubtreeRecursive(main.right, sub);
    }

    private static boolean isSame(Node one, Node two){
        if (one == null && two == null){
            return true;
        }
        if (one != null && two == null){
            return false;
        }
        if (one == null){
            return false;
        }
        if (one.data != two.data){
            return false;
        }
        return isSame(one.left, two.left) && isSame(one.right, two.right);
    }
}
