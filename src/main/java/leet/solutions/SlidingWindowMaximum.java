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
    class PositionCapsule {

        public int index;
        public int value;

        public PositionCapsule(int value) {
            this.value = value;
        }

    }

    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            PositionCapsule[] positionCapsules = new PositionCapsule[nums.length];
            PositionCapsule[] slidingWindow = new PositionCapsule[k];
            int[] result = new int[nums.length - k + 1];
            int slidingEnd = k - 1;
            if (k == 1) {
                return nums;
            }
            int max = nums[0];
            for (int i = 0; i < nums.length; i++) {
                positionCapsules[i] = new PositionCapsule(nums[i]);
                if (i < k) {
                    slidingWindow[i] = positionCapsules[i];
                    slidingWindow[i].index = i;
                }
                if (nums[i] > max) {
                    max = nums[i];
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
                int departingPosition = positionCapsules[i - k].index;
                slidingWindow[departingPosition] = positionCapsules[i];
                positionCapsules[i].index = departingPosition;
                if (!(positionCapsules[i - k].value < lastLargest && positionCapsules[i].value < lastLargest)) {
                    createMaxHeap(slidingWindow);
                }
                lastLargest = slidingWindow[0].value;
                result[i - k + 1] = slidingWindow[0].value;
            }


            return result;
        }

        private void createMaxHeap(PositionCapsule[] input) {
            for (int i = input.length / 2 - 1; i >= 0; i--) {
                heapify(input, i);
            }
        }

        private void heapify(PositionCapsule[] input, int startIndex) {
            int largest = startIndex;
            int leftIndex = startIndex * 2 + 1;
            int rightIndex = startIndex * 2 + 2;

            if (leftIndex <= input.length - 1) {
                if (input[leftIndex].value > input[largest].value) {
                    largest = leftIndex;
                }
            }

            if (rightIndex <= input.length - 1) {
                if (input[rightIndex].value > input[largest].value) {
                    largest = rightIndex;
                }
            }

            if (largest != startIndex) {
                PositionCapsule swap = input[startIndex];
                input[startIndex] = input[largest];
                input[startIndex].index = startIndex;
                input[largest] = swap;
                input[largest].index = largest;

                heapify(input, largest);
            }
        }


    }
}
