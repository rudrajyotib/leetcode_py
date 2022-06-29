package interviewbit.solutions;

/*
https://www.interviewbit.com/problems/median-of-array/
 */

import java.util.List;


public class MedianOfTwoSortedArrays {

    public double solve(List<Integer> a, List<Integer> b) {
        return new Solution().findMedianSortedArrays(a, b);
    }

    @SuppressWarnings("InnerClassMayBeStatic")
    public class Solution {
        // DO NOT MODIFY BOTH THE LISTS
        public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
            if (a.isEmpty()) {
                return findMedianOfSingleList(b);
            }
            if (b.isEmpty()){
                return findMedianOfSingleList(a);
            }

            return a.size() < b.size() ? medianUtil(a, b) : medianUtil(b, a);
        }

        private double findMedianOfSingleList(List<Integer> a) {
            if (a.size() % 2 == 0) {
                return (double) (
                        a.get(a.size() / 2) + a.get(a.size() / 2 - 1)
                ) / 2;
            }else{
                return (double) a.get(a.size()/2);
            }
        }

        private double medianUtil(List<Integer> smallerList, List<Integer> largerList) {
            int realMid = (smallerList.size() + 1 + largerList.size()) / 2;
            int startIndexOfSmallerArrayLeftPortion = 0;
            int endIndexOfSmallerArrayRightPortion = smallerList.size();

            while (startIndexOfSmallerArrayLeftPortion <= endIndexOfSmallerArrayRightPortion) {
                int midOfSmallerArray = (startIndexOfSmallerArrayLeftPortion + endIndexOfSmallerArrayRightPortion) / 2;
                int midOfLargerArray = realMid - midOfSmallerArray;

                int maxOfLeftPortionSmallerArray = (midOfSmallerArray==0)?Integer.MIN_VALUE : smallerList.get(midOfSmallerArray-1);
                int minOfRightPortionSmallerArray = (midOfSmallerArray==smallerList.size()) ? Integer.MAX_VALUE : smallerList.get((midOfSmallerArray));

                int maxOfLeftPortionLargerArray = (midOfLargerArray==0)? Integer.MIN_VALUE : largerList.get(midOfLargerArray-1);
                int minOfRightPortionLargerArray = (midOfLargerArray==largerList.size()) ? Integer.MAX_VALUE : largerList.get(midOfLargerArray);

                if (maxOfLeftPortionSmallerArray <= minOfRightPortionLargerArray
                        && maxOfLeftPortionLargerArray <= minOfRightPortionSmallerArray) {
                    if ((smallerList.size() + largerList.size()) % 2 == 0) {
                        return (double) (Math.max(maxOfLeftPortionLargerArray, maxOfLeftPortionSmallerArray)
                                + Math.min(minOfRightPortionLargerArray, minOfRightPortionSmallerArray)) / 2;
                    } else {
                        return Math.max(maxOfLeftPortionSmallerArray, maxOfLeftPortionLargerArray);
                    }
                } else if (maxOfLeftPortionSmallerArray > minOfRightPortionLargerArray) {
                    endIndexOfSmallerArrayRightPortion = midOfSmallerArray - 1 ;
                } else {
                    startIndexOfSmallerArrayLeftPortion = midOfSmallerArray + 1;
                }
            }


            return 0d;
        }


    }

}
