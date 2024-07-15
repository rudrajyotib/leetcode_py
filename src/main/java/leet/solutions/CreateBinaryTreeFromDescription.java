//https://leetcode.com/problems/create-binary-tree-from-descriptions/

package leet.solutions;

import ds.util.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class CreateBinaryTreeFromDescription {

    public TreeNode solve(int[][] description) {
        return new Solution().createBinaryTree(description);
    }

    static class Solution {

        public TreeNode createBinaryTree(int[][] descriptions) {
            Map<Integer, TreeNode> nodes = new HashMap<>(descriptions.length, 1.0f);
            HashSet<Integer> childNodes = new HashSet<>();

            for (int[] description : descriptions) {
                if (!nodes.containsKey(description[0])) {
                    nodes.put(description[0], new TreeNode(description[0]));
                }
                if (!nodes.containsKey(description[1])) {
                    nodes.put(description[1], new TreeNode(description[1]));
                }
                if (description[2] == 1) {
                    nodes.get(description[0]).left = nodes.get(description[1]);
                } else {
                    nodes.get(description[0]).right = nodes.get(description[1]);
                }
                childNodes.add(description[1]);
            }
            for (int[] description : descriptions) {
                if (!childNodes.contains(description[0])) {
                    return nodes.get(description[0]);
                }
            }
            return null;
        }


    }


}
