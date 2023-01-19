package gfg;

/*
https://practice.geeksforgeeks.org/problems/binary-search-1587115620/1
 */


public class BinarySearch {

    public int solve(int[] input, int length, int element){
        return new Solution().binarysearch(input, length, element);
    }

    static class Solution {
        int binarysearch(int[] arr, int n, int k) {

            int mid;
            int start = 0;
            int end = n-1;
            while (end >= start){
                mid = (start + end) / 2;
                if (arr[mid] == k){
                    return mid;
                }
                if (arr[mid] > k){
                    end = mid-1;
                }else{
                    start = mid +1;
                }
            }

            // code here
            return -1;
        }



    }


}
