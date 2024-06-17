/*
https://leetcode.com/problems/flatten-nested-list-iterator/description/
 */


package leet.solutions;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class FlattenNestedListIterator {

    static class NestedIterator implements Iterator<Integer> {

        private final Stack<Iterator<NestedInteger>> iterators;
        private Integer nextVal = -1;

        public NestedIterator(List<NestedInteger> nestedList) {
            this.iterators = new Stack<>();
            iterators.push(nestedList.iterator());
        }

        @Override
        public Integer next() {
            return nextVal;
        }

        @Override
        public boolean hasNext() {
            if (iterators.isEmpty()) {
                return false;
            }
            boolean nextSingleElementFound = false;
            while (!nextSingleElementFound && !iterators.isEmpty()) {
                Iterator<NestedInteger> iter = iterators.pop();
                if (iter.hasNext()) {
                    NestedInteger nestedInteger = iter.next();
                    if (nestedInteger.getList().isEmpty() && (nestedInteger.getInteger() != null)) {
                        nextSingleElementFound = true;
                        nextVal = nestedInteger.getInteger();
                        if (iter.hasNext()) {
                            iterators.push(iter);
                        }
                    } else {
                        if (iter.hasNext()) {
                            iterators.push(iter);
                        }
                        iterators.push(nestedInteger.getList().iterator());
                    }
                }

            }
            return nextSingleElementFound;
        }
    }


}


interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return empty list if this NestedInteger holds a single integer
    List<NestedInteger> getList();
}
