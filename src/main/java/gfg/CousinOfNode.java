/*
https://www.geeksforgeeks.org/problems/cousins-of-a-given-node/
 */

package gfg;

import gfg.util.tree.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CousinOfNode {

    public static ArrayList<Integer> printCousins(Node root, Node node_to_find)
    {
        //code here
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Node> bfsQueue = new LinkedList<>();
        bfsQueue.add(root);
        boolean nodeSpotted = false;
        while ( !bfsQueue.isEmpty() && !nodeSpotted){
            int size = bfsQueue.size();

            List<Node> parents = new LinkedList<>();
            for (int i=0;i<size;i++){
                Node parent = bfsQueue.remove();
                if (parent.left != null && parent.left.data == node_to_find.data){
                    nodeSpotted = true;
                }else if (parent.right != null && parent.right.data == node_to_find.data){
                    nodeSpotted = true;
                }else{
                    parents.add(parent);
                }
                if (parent.left != null){
                    bfsQueue.add(parent.left);
                }
                if (parent.right != null){
                    bfsQueue.add(parent.right);
                }
            }
            if (nodeSpotted){
                for (Node parent : parents) {
                    if (parent.left != null){
                        result.add(parent.left.data);
                    }
                    if (parent.right != null){
                        result.add(parent.right.data);
                    }
                }
            }
        }

        if (result.isEmpty()){
            result.add(-1);
        }

        return result;
    }



}
