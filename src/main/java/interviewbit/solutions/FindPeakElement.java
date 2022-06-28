package interviewbit.solutions;

import java.util.ArrayList;

/*
https://www.interviewbit.com/problems/find-a-peak-element/
 */


public class FindPeakElement {


    public int solve(ArrayList<Integer> numbers){
        return new Solution().solve(numbers);
    }

    @SuppressWarnings("InnerClassMayBeStatic")
    public class Solution {
        public int solve(ArrayList<Integer> numbers) {

            if (numbers.size() == 1){
                return numbers.get(0);
            }
            if (numbers.size() == 2){
                return numbers.get(0)<numbers.get(1)? numbers.get(1):numbers.get(0);
            }
            int length = numbers.size();
            if (numbers.get(0) > numbers.get(1)){
                return numbers.get(0);
            }
            if (numbers.get(length-1) > numbers.get(length -2 )){
                return numbers.get(length-1);
            }

            int left = 0;
            int right = numbers.size() - 1;
            int mid=0;


            while (left <= right ){
                mid = (left + right)/2;
                if (mid == 0 ||
                        ( (numbers.get(mid)>numbers.get(mid-1)) && (numbers.get(mid) > numbers.get(mid+1)) )
                ){
                    return numbers.get(mid);
                }
                if (mid>0 && numbers.get(mid-1) > numbers.get(mid)){
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }
            return numbers.get(mid);
        }
    }


}
