/*
https://leetcode.com/problems/count-nodes-with-the-highest-score/description/
 */

package leet.solutions;

import java.util.LinkedList;
import java.util.List;

public class CountNodesWithHighestScore {

    public int solve(int[] parents) {
        return new Solution().countHighestScoreNodes(parents);
    }

    static class Solution {
        public int countHighestScoreNodes(int[] parents) {
            Node[] allNodes = new Node[parents.length];
            for (int i = 0; i < parents.length; i++) {
                allNodes[i] = new Node(i);
            }
            for (int i = 1; i < parents.length; i++) {
                allNodes[parents[i]].childrenIndex.add(i);
            }
            allNodes[0].calculateDepth(allNodes);
            long maxResultProduct = 0;
            int countWithMaxProduct = 0;
            for (int i = 0; i < parents.length; i++) {
                long depthProduct = getDepthProduct(parents, allNodes, i);
                if (depthProduct > maxResultProduct) {
                    maxResultProduct = depthProduct;
                    countWithMaxProduct = 1;
                } else if (depthProduct == maxResultProduct) {
                    ++countWithMaxProduct;
                }
            }
            return countWithMaxProduct;
        }

        private static long getDepthProduct(int[] parents, Node[] allNodes, int i) {
            long childDepthProduct = 1;
            Node node = allNodes[i];
            for (Integer child : node.childrenIndex) {
                childDepthProduct *= allNodes[child].depth;
            }
            int depthOfRemainingTreeWithParent = parents.length - (node.depth);
            if (depthOfRemainingTreeWithParent == 0) {
                depthOfRemainingTreeWithParent = 1;
            }
            return childDepthProduct * depthOfRemainingTreeWithParent;
        }


        static class Node {
            int index;
            List<Integer> childrenIndex;
            int depth = 1;

            public Node(int index) {
                this.index = index;
                this.childrenIndex = new LinkedList<>();
            }

            public void calculateDepth(Node[] allNodes) {
                int tempDepth = 1;
                for (Integer child : this.childrenIndex) {
                    allNodes[child].calculateDepth((allNodes));
                    tempDepth += allNodes[child].depth;
                }
                this.depth = tempDepth;
            }
        }
    }

}
