package leet.solutions;

/*
https://leetcode.com/problems/maximum-product-of-splitted-binary-tree/
Leetcode#1339
 */
public class MaxProductOfSplitBinaryTree {
    
  static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      @SuppressWarnings("unused")
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }


  public int solve(TreeNode root)
  {
      Solution solution = new Solution();
      return solution.maxProduct(root);
  }

    @SuppressWarnings("InnerClassMayBeStatic")
    class Solution {

        private long maxProduct;
        private long treeSum;

        public int maxProduct(TreeNode root) {
            this.treeSum = sum(root);
            compareMaxProduct(root.left);
            compareMaxProduct(root.right);
            return (int)(this.maxProduct % 1000000007);
        }

        private int compareMaxProduct(TreeNode node)
        {
            if (node == null)
            {
                return 0;
            }
            int sumOfChildren = node.val + compareMaxProduct(node.left) + compareMaxProduct(node.right);
            this.maxProduct = Math.max(this.maxProduct, (sumOfChildren * (this.treeSum - sumOfChildren)));
            return sumOfChildren;
        }


        private int sum(TreeNode node)
        {
            if (node == null)
            {
                return 0;
            }
            return node.val + sum(node.left) + sum(node.right);
        }



    }

}
