package leet.solutions;

/*
https://leetcode.com/problems/sliding-window-maximum/
TLE
 */

public class SlidingWindowMaximum {


    public int[] solve(int[] nums, int k) {
        return new Solution().maxSlidingWindow(nums, k);
    }



    @SuppressWarnings("InnerClassMayBeStatic")
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            int[][] positionMatrix = new int[nums.length][2];
            int[][] slidingWindowMatrix = new int[k][2];
            int[] result = new int[nums.length - k + 1];
            int slidingEnd = k - 1;
            if (k == 1) {
                return nums;
            }
            int max = nums[0];
            for (int i = 0; i < nums.length; i++) {
                positionMatrix[i] = new int[]{nums[i], i};
                if (i < k) {
                    slidingWindowMatrix[i] = positionMatrix[i];
                    slidingWindowMatrix[i][1] = i;
                    if (nums[i] > max) {
                        max = nums[i];
                    }
                }

            }
//            for (int i = 0; i <= slidingEnd; i++) {
//                slidingWindow[i] = positionCapsules[i];
//                slidingWindow[i].index = i;
//            }
//            createMaxHeap(slidingWindow);
            result[0] = max;
            int lastLargest = result[0];
            for (int i = slidingEnd + 1; i < nums.length; i++) {
                int departingPosition = positionMatrix[i - k][1];
                slidingWindowMatrix[departingPosition] = positionMatrix[i];
                positionMatrix[i][1] = departingPosition;
                if ((positionMatrix[i - k][0] >= lastLargest || positionMatrix[i][0] >= lastLargest)) {
                    createMaxHeap(slidingWindowMatrix);
                    lastLargest = slidingWindowMatrix[0][0];
                }
                result[i - k + 1] = lastLargest;
            }


            return result;
        }

        private void createMaxHeap(int[][] input) {
            for (int i = input.length / 2 - 1; i >= 0; i--) {
                heapify(input, i);
            }
        }

        private void heapify(int[][] input, int startIndex) {
            int largest = startIndex;
            int leftIndex = startIndex * 2 + 1;
            int rightIndex = startIndex * 2 + 2;

            if (leftIndex <= input.length - 1) {
                if (input[leftIndex][0] > input[largest][0]) {
                    largest = leftIndex;
                }
            }

            if (rightIndex <= input.length - 1) {
                if (input[rightIndex][0] > input[largest][0]) {
                    largest = rightIndex;
                }
            }

            if (largest != startIndex) {
                int[] swap = input[startIndex];
                input[startIndex] = input[largest];
                input[startIndex][1] = startIndex;
                input[largest] = swap;
                input[largest][1] = largest;

                heapify(input, largest);
            }
        }


    }
}
