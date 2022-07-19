package interviewbit.solutions;

/*
https://www.interviewbit.com/problems/merge-k-sorted-lists/
 */

import ds.util.ListNode;

import java.util.ArrayList;

public class MergeKSortedLists {

    public ListNode solve(ArrayList<ListNode> listNodes){
        return new Solution().mergeKLists(listNodes);
    }

    public static class Solution {
        public ListNode mergeKLists(ArrayList<ListNode> a) {

            HeapNode[] heapNodes = new HeapNode[a.size()];
            ListNode[] pointers = new ListNode[a.size()];
            int listsParsed = 0;

            for (int i=0;i<a.size();i++){
                heapNodes[i] = new HeapNode(i, a.get(i).val);
                pointers[i] = a.get(i);
            }

            MinHeap minHeap = new MinHeap(heapNodes);
            ListNode resultHead = null;
            ListNode resultTail = null;

            while (listsParsed < a.size()){
                HeapNode heapNode = minHeap.getMin();
                if (resultHead == null){
                    resultHead = pointers[heapNode.arrayIndex];
                    resultTail = resultHead;
                }else{
                    resultTail.next = pointers[heapNode.arrayIndex];
                    resultTail = resultTail.next;
                }
                if (pointers[heapNode.arrayIndex].next == null){
                    ++listsParsed;
                    minHeap.replace(new HeapNode(heapNode.arrayIndex, Integer.MAX_VALUE));
                }else{
                    pointers[heapNode.arrayIndex] = pointers[heapNode.arrayIndex].next;
                    minHeap.replace(new HeapNode(heapNode.arrayIndex, pointers[heapNode.arrayIndex].val));
                }
            }


            return resultHead;
        }

        private static class HeapNode{
            private final int arrayIndex;
            private final int value;

            HeapNode(int arrayIndex, int value) {
                this.arrayIndex = arrayIndex;
                this.value = value;
            }
        }

        private static class MinHeap{
            private final HeapNode[] elements;

            MinHeap(HeapNode[] elements) {
                this.elements = elements;
                heapify();
            }

            public HeapNode getMin(){
                return elements[0];
            }

            public void replace(HeapNode heapNode){
                elements[0] = heapNode;
                heapify();
            }

            private void heapify(){
                int elementsLength = elements.length;
                int lastParentNode = (elementsLength-2) /2;
                for (int i=lastParentNode;i>=0;i--){
                    minHeapify(i);
                }
            }

            private void minHeapify(int index){
                int leftChild = 2*index+1;
                int rightChild = 2*index + 2;
                if (leftChild >= elements.length){
                    return;
                }
                if (rightChild >= elements.length){
                    if (elements[index].value > elements[leftChild].value){
                        swap(index, leftChild);
                        minHeapify(leftChild);
                    }
                }else{
                    int swapIndex = elements[leftChild].value < elements[rightChild].value ? leftChild : rightChild;
                    if (elements[index].value > elements[swapIndex].value){
                        swap(index, swapIndex);
                        minHeapify(swapIndex);
                    }
                }
            }
            private void swap(int fromIndex, int toIndex){
                HeapNode temp = elements[fromIndex];
                elements[fromIndex] = elements[toIndex];
                elements[toIndex] = temp;
            }

        }

    }



}
