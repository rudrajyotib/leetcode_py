package interviewbit.solutions;

/*
https://www.interviewbit.com/problems/order-of-people-heights/
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OrderOfPeopleHeights {

    public ArrayList<Integer> solve(ArrayList<Integer> heights, ArrayList<Integer> peopleInFront) {
        return new Solution().order(heights, peopleInFront);
    }

    @SuppressWarnings("InnerClassMayBeStatic")
    public class Solution {
        public ArrayList<Integer> order(ArrayList<Integer> A, ArrayList<Integer> B) {

            List<int[]> heightWithPosition = new ArrayList<>(A.size());

            for (int i = 0; i < A.size(); i++) {
                heightWithPosition.add(new int[]{A.get(i), B.get(i)});
            }

            heightWithPosition.sort(Comparator.comparingInt(o -> o[0]));

            ArrayList<Integer> result = new ArrayList<>(A.size());
            for (int i = 0; i < A.size(); i++) {
                result.add(-1);
            }

            for (int i = 0; i < A.size(); i++) {
                boolean positionFound = false;
                int counter = 0;
                int emptyCellCount = heightWithPosition.get(i)[1];
                int emptyCellCounter = 0;
                int height = heightWithPosition.get(i)[0];
                while (!positionFound) {
                    if (emptyCellCounter == emptyCellCount) {
                        if (result.get(counter) == -1) {
                            result.set(counter, height);
                            positionFound = true;
                        } else {
                            ++counter;
                        }
                    } else {
                        if (result.get(counter) == -1) {
                            ++emptyCellCounter;
                        }
                        ++counter;
                    }
                }

            }

            return result;
        }
    }

}
