package interviewbit.solutions;

/*
https://www.interviewbit.com/problems/intersection-of-sorted-arrays/
 */


import java.util.ArrayList;
import java.util.List;

public class IntersectionOfSortedArrays {

    public ArrayList<Integer> solve(ArrayList<Integer> array1, ArrayList<Integer> array2){
        return new Solution().intersect(array1, array2);
    }

    @SuppressWarnings("InnerClassMayBeStatic")
    class Solution{
        public ArrayList<Integer> intersect(List<Integer> array1, List<Integer> array2){

            int array1Counter = 0;
            int array2Counter = 0;
            ArrayList<Integer> intersectedList = new ArrayList<>();

            while (array1Counter<=array1.size()-1 && array2Counter<=array2.size()-1){
                if (array1.get(array1Counter).equals(array2.get(array2Counter))){
                    intersectedList.add(array1.get(array1Counter));
                    ++array1Counter;
                    ++array2Counter;
                }else if (array1.get(array1Counter)<array2.get(array2Counter)){
                    ++array1Counter;
                }else{
                    ++array2Counter;
                }
            }

            return intersectedList;
        }
    }

}
