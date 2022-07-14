package interviewbit.solutions;

/*
https://www.interviewbit.com/problems/remove-element-from-array/
 */

import java.util.ArrayList;

public class RemoveElement {

    public int solve(ArrayList<Integer> list, int targetElement){
        return new Solution().removeElement(list, targetElement);
    }


    public static class Solution {
        public int removeElement(ArrayList<Integer> a, int b) {
            int lastValidIndex = 0;

            for (int i=0;i<a.size();i++){
                if (a.get(i) != b){
                    int temp = a.get(i);
                    a.set(lastValidIndex, temp);
                    a.set(i, temp);
                    ++lastValidIndex;
                }
            }
            int toBeRemoved = a.size() - lastValidIndex;
            for (int i=0;i<toBeRemoved;i++){
                a.remove(lastValidIndex);
            }
            return lastValidIndex;
        }
    }


}
