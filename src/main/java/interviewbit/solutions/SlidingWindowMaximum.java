package interviewbit.solutions;

/*
https://www.interviewbit.com/problems/sliding-window-maximum/
 */


public class SlidingWindowMaximum {

    public int[] solve(int[] array, int windowLength){
        return new Solution().slidingMaximum(array, windowLength);
    }


    static class Solution {
        // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
        public int[] slidingMaximum(final int[] A, int B) {
            if (B == 1){
                return A;
            }
            int[] slidingWindowMax = new int[A.length - B + 1];
            SlidingWindowMember[] slidingWindowMembers = new SlidingWindowMember[B];
            for (int i=0;i<B;i++){
                slidingWindowMembers[i] = new SlidingWindowMember(A[i]);
            }
            BinaryTreeNode root = toBinaryTree(slidingWindowMembers, 0);
            toMaxHeap(root);
            assert root!=null;
            slidingWindowMax[0] = root.value.value;
            for (int i=1;i<slidingWindowMax.length;i++){
                slidingWindowMembers[(i-1)%B].value = A[i+B-1];
                toMaxHeap(root);
                slidingWindowMax[i] = root.value.value;
            }
            return slidingWindowMax;
        }

        private  void toMaxHeap(BinaryTreeNode node)
        {
            if (node == null)
            {
                return;
            }
            toMaxHeap(node.left);
            toMaxHeap(node.right);
            BinaryTreeNode max = getMaxNode(node.left, node.right);
            swap(node, max);
        }

        private  BinaryTreeNode getMaxNode(BinaryTreeNode left, BinaryTreeNode right)
        {
            if (left == null)
            {
                return right;
            }
            if (right == null)
            {
                return left;
            }
            return left.value.value > right.value.value ? left : right;
        }

        private  void swap(BinaryTreeNode parent, BinaryTreeNode child)
        {
            if (child != null && parent.value.value < child.value.value)
            {
                SlidingWindowMember value = parent.value;
                parent.value = child.value;
                child.value = value;
            }
        }

        static class SlidingWindowMember{
            int value;
            SlidingWindowMember(int value){
                this.value = value;
            }
        }

        static class BinaryTreeNode {
            SlidingWindowMember value;
            BinaryTreeNode left;
            BinaryTreeNode right;

            BinaryTreeNode(SlidingWindowMember value, BinaryTreeNode left, BinaryTreeNode right){
                this.value = value;
                this.left = left;
                this.right = right;
            }

            @Override
            public String toString()
            {
                StringBuilder sb = new StringBuilder();
                toString(this, sb);
                return sb.toString();
            }

            private void toString(BinaryTreeNode node, StringBuilder sb)
            {
                sb.append(node.value.value);
                if (node.left != null)
                {
                    sb.append("(");
                    toString(node.left, sb);
                    sb.append(")");
                }
                if (node.right != null)
                {
                    sb.append("(");
                    toString(node.right, sb);
                    sb.append(")");
                }
            }


        }

        private  BinaryTreeNode toBinaryTree(SlidingWindowMember[] values, int i)
        {
            if (i > values.length - 1)
            {
                return null;
            }
            SlidingWindowMember value = values[i];

            BinaryTreeNode left = toBinaryTree(values, (i * 2) + 1);
            BinaryTreeNode right = toBinaryTree(values, (i * 2) + 2);

            return new BinaryTreeNode(value, left, right);
        }
    }



}
