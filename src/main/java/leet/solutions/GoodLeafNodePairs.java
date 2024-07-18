/*
https://leetcode.com/problems/number-of-good-leaf-nodes-pairs
 */

package leet.solutions;

import ds.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class GoodLeafNodePairs {

    public int solve(TreeNode node, int dist) {
        return new Solution().countPairs(node, dist);
    }


    static class Solution {

        private int pairCount = 0;

        public int countPairs(TreeNode root, int distance) {
            this.pairCount = 0;
            leafNodePairs(root, distance);
            return this.pairCount;
        }

        private List<Integer> leafNodePairs(TreeNode node, int distance) {
            if (node == null) {
                return new ArrayList<>();
            }
            if (node.left == null && node.right == null) {
                return new ArrayList<>(List.of(0));
            }
            List<Integer> fromLeft = leafNodePairs(node.left, distance);
            List<Integer> fromRight = leafNodePairs(node.right, distance);
            fromLeft.replaceAll(integer -> integer + 1);
            fromRight.replaceAll(integer -> integer + 1);
            for (Integer left : fromLeft) {
                for (Integer right : fromRight) {
                    if ((left + right) <= distance) {
                        ++this.pairCount;
                    }
                }
            }
            fromLeft.addAll(fromRight);
            return fromLeft;
        }
    }

}
