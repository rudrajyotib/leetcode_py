package gfg;

/*
https://practice.geeksforgeeks.org/problems/ec277982aea7239b550b28421e00acbb1ea03d2c/1
 */

import gfg.util.tree.Node;

import java.util.ArrayList;
import java.util.List;

public class MaxValueLevelOrder {


    public List<Integer> solve(Node root){
        return new Solution().maximumValue(root);
    }

    static class Solution {
        ArrayList<Integer> maximumValue(Node node) {
            //code here
            ArrayList<Integer> result = new ArrayList<>();
            result.add(node.data);
            dfs(node.left, result, 2);
            dfs(node.right, result, 2);
            return result;
        }

        private void dfs(Node node, ArrayList<Integer> result, int level){
            if (node == null){
                return;
            }
            if (level > result.size()){
                result.add(node.data);
            }else{
                if (node.data > result.get(level-1)){
                    result.set(level-1, node.data);
                }
            }
            dfs(node.left, result, level+1);
            dfs(node.right, result, level + 1);

        }

    }
}
