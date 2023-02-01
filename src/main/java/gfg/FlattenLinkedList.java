package gfg;

/*
https://practice.geeksforgeeks.org/problems/da62a798bca208c7a678c133569c3dc7f5b73500/1
 */

import gfg.util.link.Node;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FlattenLinkedList {

    public Node solve(Node root){
        return new GfG().flatten(root);
    }

    static class GfG
    {
        Node flatten(Node root)
        {
            // Your code here
            PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o.data));
            Node iter = root;
            Node result = null ;
            Node resultIter = null;
            while (iter != null){
                priorityQueue.add(iter);
                iter = iter.next;
            }
            while ( !priorityQueue.isEmpty()){
                Node node = priorityQueue.remove();
                if (result == null){
                    result = new Node(node.data);
                    resultIter = result;
                }else{
                    resultIter.bottom = new Node(node.data);
                    resultIter = resultIter.bottom;
                }
                if (node.bottom != null){
                    priorityQueue.offer(node.bottom);
                }
            }
            return result;
        }
    }

}
