package gfg;

/*
https://practice.geeksforgeeks.org/problems/6eb51dc638ee1b936f38d1ab4b2f7062d4425463/1
 */

import gfg.util.tree.Node;

import java.util.Stack;

public class MaxGcdOfSiblingsOfBinaryTree {

    int maxGcd(Node root){
        Stack<Node> stack = new Stack<>();
        int maxGcd = -1;
        int maxGcdNode = -1;
        stack.add(root);
        while(!stack.isEmpty()){
            Node node = stack.pop();
            if (node.left != null){
                stack.add(node.left);
            }
            if (node.right != null){
                stack.add(node.right);
            }
            if (node.left != null && node.right != null){
                int g = gcd(node.left.data, node.right.data);
                if (g > maxGcd){
                    maxGcd = g;
                        maxGcdNode = node.data;
                }
                if (g == maxGcd && node.data > maxGcdNode){
                    maxGcdNode = node.data;
                }
            }
        }
        return maxGcdNode;
    }

    private int gcd(int a, int b) {
        if (a == 0) {
            return b;
        }
        if (b == 0) {
            return a;
        }
        if (a == b) {
            return a;
        }
        if (a > b) {
            return gcd(a - b, b);
        } else {
            return gcd(a, b - a);
        }
    }

}
