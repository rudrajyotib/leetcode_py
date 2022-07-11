package interviewbit.solutions;

/*
https://www.interviewbit.com/problems/zigzag-level-order-traversal-bt/
 */

import java.util.*;

public class ZigzagLevelOrderTraversalBinaryTree {

    public ArrayList<ArrayList<Integer>> solve(TreeNode root){
        return new Solution().zigzagLevelOrder(root);
    }

      static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) {
           val = x;
           left=null;
           right=null;
          }

          TreeNode(int x, TreeNode left, TreeNode right){
              this.val = x;
              this.left = left;
              this.right = right;
          }
      }


    @SuppressWarnings("InnerClassMayBeStatic")
    public class Solution {
        public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode A) {
            ArrayList<ArrayList<Integer>> result = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(A);
            boolean leftToRight = true;
            while (!queue.isEmpty()){
                int queueDepth = queue.size();
                Integer[] levelStore = new Integer[queueDepth];
                for (int i=0;i<queueDepth;i++){
                    TreeNode temp = queue.poll();
                    assert temp != null;
                    levelStore[i] = temp.val;
                    if (temp.left != null){
                        queue.add(temp.left);
                    }
                    if (temp.right != null){
                        queue.add(temp.right);
                    }
                }
                if (leftToRight){
                    result.add(new ArrayList<>(Arrays.asList(levelStore)));
                }else{
                    ArrayList<Integer> nextLevel = new ArrayList<>(levelStore.length);
                    for (int i=levelStore.length-1;i>=0;i--){
                        nextLevel.add(levelStore[i]);
                    }
                    result.add(nextLevel);
                }
                leftToRight = !leftToRight;
            }

            return result;
        }
    }

}
