package leet.solutions;

/*
https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
Leetcode#105
 */


import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromInorderPreorder {


    @SuppressWarnings({"InnerClassMayBeStatic", "unused"})
    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }


  public TreeNode solve(int[] preorder, int[] inorder)
  {
      Solution solution = new Solution();
      return solution.buildTree(preorder, inorder);
  }

    class Solution {

        private int preIndex = 0;
        private int[] preorder;
        private int[] inorder;
        private Map<Integer, Integer> inorderIndexMap = new HashMap<>();

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            this.preorder = preorder;
            this.inorder = inorder;

            for (int i=0;i<inorder.length;i++)
            {
                inorderIndexMap.put(inorder[i], i);
            }
            return buildSubTree(0, inorder.length-1);
        }

        private TreeNode buildSubTree(int startIndexOfInOrder, int endIndexOfInorder)
        {
            if (endIndexOfInorder<startIndexOfInOrder)
            {
                return null;
            }
            TreeNode node = new TreeNode(this.preorder[preIndex]);
            ++this.preIndex;
            if (startIndexOfInOrder == endIndexOfInorder)
            {
                return node;
            }
            int inOrderIndexOfNode = this.inorderIndexMap.get(node.val);
            node.left = buildSubTree(startIndexOfInOrder, inOrderIndexOfNode-1);
            node.right = buildSubTree(inOrderIndexOfNode+1, endIndexOfInorder);
            return node;
        }
    }

}
