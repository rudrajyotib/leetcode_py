package interviewbit.solutions;

/*
https://www.interviewbit.com/problems/search-for-a-range/
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchForRange {


    public ArrayList<Integer> solve(List<Integer> sortedArray, int toSearch) {
        return new Solution().searchRange(sortedArray, toSearch);
    }

    @SuppressWarnings("InnerClassMayBeStatic")
    class Solution {
        // DO NOT MODIFY THE LIST. IT IS READ ONLY
        public ArrayList<Integer> searchRange(final List<Integer> sortedArray, int toSearch) {

            if (toSearch < sortedArray.get(0)) {
                return new ArrayList<>(Arrays.asList(-1, -1));
            }

            int arrayLength = sortedArray.size();

            if (toSearch > sortedArray.get(arrayLength - 1)) {
                return new ArrayList<>(Arrays.asList(-1, -1));
            }

            if (sortedArray.size() == 1) {
                if (sortedArray.get(0) == toSearch) {
                    return new ArrayList<>(Arrays.asList(0, 0));
                } else {
                    return new ArrayList<>(Arrays.asList(-1, -1));
                }
            }

            if (sortedArray.get(0) == toSearch && sortedArray.get(arrayLength - 1) == toSearch) {
                return new ArrayList<>(Arrays.asList(0, arrayLength - 1));
            } else if (sortedArray.get(0) == toSearch) {
                return new ArrayList<>(Arrays.asList(0, findIndexOfEndRange(sortedArray, toSearch, 0, arrayLength - 1)));
            } else if (sortedArray.get(arrayLength - 1) == toSearch) {
                return new ArrayList<>(Arrays.asList(findIndexOfStartRange(sortedArray, toSearch, 0, arrayLength - 1), arrayLength - 1));
            } else {
                int elementIndex = findIndexOfSearchElement(sortedArray, toSearch, 0, arrayLength - 1);
                if (elementIndex == -1) {
                    return new ArrayList<>(Arrays.asList(-1, -1));
                }
                return new ArrayList<>(Arrays.asList(findIndexOfStartRange(sortedArray, toSearch, 0, elementIndex),
                        findIndexOfEndRange(sortedArray, toSearch, elementIndex, arrayLength - 1)));
            }

        }

        private int findIndexOfSearchElement(List<Integer> sortedArray, int toSearch, int startIndex, int endIndex) {

            if (startIndex > endIndex) {
                return -1;
            }

            if (startIndex < 0) {
                return -1;
            }

            if (endIndex >= sortedArray.size()) {
                return -1;
            }

            int mid = (startIndex + endIndex) / 2;

            if (sortedArray.get(mid) == toSearch) {
                return mid;
            }
            if (sortedArray.get(mid) > toSearch) {
                return findIndexOfSearchElement(sortedArray, toSearch, startIndex, mid - 1);
            }
            return findIndexOfSearchElement(sortedArray, toSearch, mid + 1, endIndex);

        }

        private int findIndexOfStartRange(List<Integer> sortedArray, int toSearch, int startIndex, int endIndex) {
            if (endIndex != 0 && sortedArray.get(endIndex) > sortedArray.get(endIndex - 1)) {
                return endIndex;
            }
            int mid = (startIndex + endIndex) / 2;
            if (sortedArray.get(mid) < toSearch) {
                return findIndexOfStartRange(sortedArray, toSearch, mid, endIndex);
            } else {
                return findIndexOfStartRange(sortedArray, toSearch, startIndex, mid);
            }

        }

        private int findIndexOfEndRange(List<Integer> sortedArray, int toSearch, int startIndex, int endIndex) {
            if (startIndex != sortedArray.size() - 1 && sortedArray.get(startIndex) < sortedArray.get(startIndex + 1)) {
                return startIndex;
            }
            int mid = (startIndex + endIndex) / 2;
            if (sortedArray.get(mid) > toSearch) {
                return findIndexOfEndRange(sortedArray, toSearch, startIndex, mid);
            }
            return findIndexOfEndRange(sortedArray, toSearch, mid, endIndex);
        }

    }

}
