package interviewbit.solutions;

/*
https://www.interviewbit.com/problems/rotated-sorted-array-search/
 */


import java.util.ArrayList;
import java.util.List;

public class RotatedSortedArraySearch {

    public int solve(int toSearch, ArrayList<Integer> numbers){
        return new Solution().search(numbers, toSearch);
    }


    @SuppressWarnings("InnerClassMayBeStatic")
    class Solution{
        public int search(List<Integer> numbers, int toSearch){
            int indexOfOriginalStart = indexOfRotation(numbers);
            if (indexOfOriginalStart==0){
                return binarySearch(numbers, toSearch, 0, numbers.size()-1);
            }
            if (toSearch>=numbers.get(0) && toSearch<=numbers.get(indexOfOriginalStart-1)){
                return binarySearch(numbers, toSearch, 0, indexOfOriginalStart-1);
            }
            if (toSearch>=numbers.get(indexOfOriginalStart) && toSearch<=numbers.get(numbers.size()-1)){
                return binarySearch(numbers, toSearch, indexOfOriginalStart, numbers.size()-1);
            }
            return -1;
        }

        private int binarySearch(List<Integer> numbers, int searchElement, int startIndex, int endIndex){
            if (startIndex>endIndex) {
                return -1;
            }
            int mid = (startIndex+endIndex)/2;
            if (numbers.get(mid) == searchElement){
                return mid;
            }
            if(numbers.get(mid) > searchElement){
                return binarySearch(numbers, searchElement, startIndex, mid-1);
            }else{
                return binarySearch(numbers, searchElement,mid+1, endIndex);
            }
        }

        private int indexOfRotation(List<Integer> numbers){
            if (numbers.get(0) < numbers.get(numbers.size()-1)){
                return 0;
            }
            return searchRotationIndexRecursive(numbers, 0, numbers.size()-1);
        }

        private int searchRotationIndexRecursive(List<Integer> numbers, int startIndex, int endIndex){
            if (startIndex>endIndex){
                return -1;
            }
            if (startIndex == endIndex){
                return startIndex;
            }
            int mid = (startIndex+endIndex)/2;
            if (numbers.get(mid) < numbers.get(mid-1)){
                return mid;
            }
            if (numbers.get(mid) < numbers.get(startIndex)){
                return searchRotationIndexRecursive(numbers, startIndex, mid);
            }
            return searchRotationIndexRecursive(numbers,mid, endIndex);
        }
    }

}
