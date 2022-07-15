package interviewbit.solutions;

/*
https://www.interviewbit.com/problems/inorder-traversal-of-cartesian-tree
 */


import ds.util.TreeNode;

public class InorderTraversalOfCartesianTree {

    public TreeNode solve(int[] inOrderTraversal) {
        return new Solution().buildTree(inOrderTraversal);
    }




    public static class Solution {
        public TreeNode buildTree(int[] inOrderTraversal) {

            MaxSegmentTree segmentTree = new MaxSegmentTree(inOrderTraversal);
            return buildTreeRecursive(0, inOrderTraversal.length - 1, inOrderTraversal, segmentTree);

        }


        public TreeNode buildTreeRecursive(int leftLimit, int rightLimit, int[] inOrderTraversal, MaxSegmentTree segmentTree) {
            if (leftLimit > rightLimit) {
                return null;
            }
            int maxElementIndexInRange = segmentTree.query(leftLimit, rightLimit);
            TreeNode node = new TreeNode(inOrderTraversal[maxElementIndexInRange]);
            node.right = buildTreeRecursive(maxElementIndexInRange + 1, rightLimit, inOrderTraversal, segmentTree);
            node.left = buildTreeRecursive(leftLimit, maxElementIndexInRange - 1, inOrderTraversal, segmentTree);
            return node;
        }


        static class MaxSegmentTree {
            private final int[] elements;
            private final int[] segments;

            MaxSegmentTree(int[] elements) {
                this.elements = elements;
                this.segments = new int[calculateTotalCells(elements.length)];
                buildSegmentTree();
            }

            int calculateTotalCells(int count) {
                int leafNodesCount = 1;
                int totalCells = 1;
                while (leafNodesCount < count) {
                    leafNodesCount *= 2;
                    totalCells += leafNodesCount;
                }
                return totalCells;
            }

            int query(int startIndex, int endIndex) {
                return queryRecursive(0, elements.length - 1, startIndex, endIndex, 0);
            }

            int queryRecursive(int leftSubTreeLimit, int rightSubTreeLimit, int leftQueryIndex, int rightQueryIndex, int cellReferenceIndex) {
                if (leftSubTreeLimit > rightQueryIndex || rightSubTreeLimit < leftQueryIndex) {
                    return -1;
                }
                if (leftSubTreeLimit >= leftQueryIndex && rightSubTreeLimit <= rightQueryIndex) {
                    return segments[cellReferenceIndex];
                }
                int midSubTreeLimit = (leftSubTreeLimit + rightSubTreeLimit) / 2;
                int indexFromLeftSubTreeSearch = queryRecursive(leftSubTreeLimit, midSubTreeLimit, leftQueryIndex, rightQueryIndex, (cellReferenceIndex * 2 + 1));
                int indexFromRightSubTreeSearch = queryRecursive(midSubTreeLimit + 1, rightSubTreeLimit, leftQueryIndex, rightQueryIndex, (cellReferenceIndex * 2 + 2));
                if (indexFromLeftSubTreeSearch == -1) {
                    return indexFromRightSubTreeSearch;
                }
                if (indexFromRightSubTreeSearch == -1) {
                    return indexFromLeftSubTreeSearch;
                }
                if (elements[indexFromLeftSubTreeSearch] > elements[indexFromRightSubTreeSearch]) {
                    return indexFromLeftSubTreeSearch;
                }
                return indexFromRightSubTreeSearch;
            }


            void buildSegmentTree() {
                buildSegmentTreeRecursive(0, this.elements.length - 1, 0);
            }

            void buildSegmentTreeRecursive(int left, int right, int cellIndex) {
                if (left == right) {
                    segments[cellIndex] = left;
                    return;
                }
                int leftChildIndex = cellIndex * 2 + 1;
                int rightChildIndex = cellIndex * 2 + 2;
                int mid = (left + right) / 2;
                buildSegmentTreeRecursive(left, mid, leftChildIndex);
                buildSegmentTreeRecursive(mid + 1, right, rightChildIndex);
                if (elements[segments[leftChildIndex]] > elements[segments[rightChildIndex]]) {
                    segments[cellIndex] = segments[leftChildIndex];
                } else {
                    segments[cellIndex] = segments[rightChildIndex];
                }
            }


        }


    }


}
