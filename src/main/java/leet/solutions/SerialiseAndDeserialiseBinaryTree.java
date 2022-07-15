package leet.solutions;

/*
https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
Leetcode#297
 */

import ds.util.TreeNode;

public class SerialiseAndDeserialiseBinaryTree {



    static class Codec {


        private String serialise(TreeNode rootNode, int level)
        {
            if (rootNode == null)
            {
                return "";
            }
            return String.format("%d(%s)[%d](%s)",
                    rootNode.val,
                    serialise(rootNode.left, level+1),
                    level,
                    serialise(rootNode.right, level+1));
        }

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            return serialise(root, 1);
        }


        private TreeNode deserializeRecursive(String data, int level)
        {
            if (data.isEmpty())
            {
                return null;
            }
            int indexOfOpenParentheses = data.indexOf("(");
            TreeNode rootNode = new TreeNode(Integer.parseInt(data.substring(0, indexOfOpenParentheses)));
            String levelSeparator = String.format("[%d]",level+1);
            int indexOfSeparator = data.indexOf(levelSeparator);
            rootNode.left = deserializeRecursive(data.substring(indexOfOpenParentheses+1, indexOfSeparator-1), level+1);
            rootNode.right = deserializeRecursive(data.substring(indexOfSeparator+levelSeparator.length()+1, data.length()-1), level+1);
            return rootNode;
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            return deserializeRecursive(data, 0);
        }
    }

}
