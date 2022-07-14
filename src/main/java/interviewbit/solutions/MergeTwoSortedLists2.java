package interviewbit.solutions;

/*
https://www.interviewbit.com/problems/merge-two-sorted-lists-ii/
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;

public class MergeTwoSortedLists2 {

    public void solve(ArrayList<Integer> first, ArrayList<Integer> second){
        new Solution().merge(first, second);
    }

    public static class Solution {
        public void merge(ArrayList<Integer> a, ArrayList<Integer> b) {

            LinkedList<Integer> mergedList = new LinkedList<>();

            int firstPointer = 0;
            int secondPointer = 0;

            while (firstPointer<a.size() && secondPointer<b.size()){
                if (Objects.equals(a.get(firstPointer), b.get(secondPointer))){
                    mergedList.add(a.get(firstPointer));
                    mergedList.add(b.get(secondPointer));
                    ++firstPointer;
                    ++secondPointer;
                }else if (a.get(firstPointer)<b.get(secondPointer)){
                    mergedList.add(a.get(firstPointer));
                    ++firstPointer;
                }else{
                    mergedList.add(b.get(secondPointer));
                    ++secondPointer;
                }
            }

            for (int i=firstPointer;i<a.size();i++){
                mergedList.add(a.get(i));
            }

            for (int i=secondPointer;i<b.size();i++){
                mergedList.add(b.get(i));
            }

            a.clear();
            a.addAll(mergedList);

        }
    }


}
