package interviewbit.solutions;

/*
https://www.interviewbit.com/problems/populate-next-right-pointers-tree/
 */

import java.util.LinkedList;
import java.util.Queue;

public class PopulateNextRightPointer {


    public void solve(TreeLinkNode root) {
        new Solution().connect(root);
    }

    public static class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }

        TreeLinkNode(int x, TreeLinkNode left, TreeLinkNode right) {
            this.val = x;
            this.left = left;
            this.right = right;
        }
    }

    @SuppressWarnings("InnerClassMayBeStatic")
    public class Solution {
        public void connect(TreeLinkNode root) {
//            connectRecursive(root);

            Queue<TreeLinkNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                int stackDepth = queue.size();
                TreeLinkNode previous = queue.poll();
                if (previous.left != null) {
                    queue.add(previous.left);
                }
                if (previous.right != null) {
                    queue.add(previous.right);
                }
                for (int i = 1; i < stackDepth; i++) {
                    TreeLinkNode nextNode = queue.poll();
                    previous.next = nextNode;
                    previous = nextNode;
                    assert previous != null;
                    if (previous.left != null) {
                        queue.add(previous.left);
                    }
                    if (previous.right != null) {
                        queue.add(previous.right);
                    }
                }
            }

        }

        @SuppressWarnings("unused")
        private void connectRecursive(TreeLinkNode node) {
            if (node == null) {
                return;
            }
            if (node.next == null) {
                if (node.left != null) {
                    if (node.right != null) {
                        node.left.next = node.right;
                    }
                }
            } else {
                if (node.left != null) {
                    if (node.right != null) {
                        node.left.next = node.right;
                    } else {
                        if (node.next.left != null) {
                            node.left.next = node.next.left;
                        } else if (node.next.right != null) {
                            node.left.next = node.next.right;
                        }
                    }
                }
                if (node.right != null) {
                    if (node.next.left != null) {
                        node.right.next = node.next.left;
                    } else if (node.next.right != null) {
                        node.right.next = node.next.right;
                    }
                }
            }
            connectRecursive(node.left);
            connectRecursive(node.right);
        }
    }


}
