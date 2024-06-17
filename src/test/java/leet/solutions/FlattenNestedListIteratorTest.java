package leet.solutions;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FlattenNestedListIteratorTest {

    @Test
    public void shouldFlattenSingleNestedList() {
        NestedInteger nestedInteger1 = new NestedIntegerImpl(List.of(new NestedIntegerImpl(1),
                new NestedIntegerImpl(2)));

        FlattenNestedListIterator.NestedIterator nestedIterator = new FlattenNestedListIterator.NestedIterator(
                List.of(nestedInteger1)
        );

        List<Integer> result = new ArrayList<>();

        while (nestedIterator.hasNext()) {
            result.add(nestedIterator.next());
        }

        Assert.assertArrayEquals(new Integer[]{1, 2}, result.toArray(new Integer[0]));

    }

    @Test
    public void test2() {
        NestedInteger nestedInteger1 = new NestedIntegerImpl(List.of(new NestedIntegerImpl(
                        List.of(new NestedIntegerImpl(1),
                                new NestedIntegerImpl(List.of(new NestedIntegerImpl(3))))
                ),
                new NestedIntegerImpl(2)));

        FlattenNestedListIterator.NestedIterator nestedIterator = new FlattenNestedListIterator.NestedIterator(
                List.of(nestedInteger1)
        );

        List<Integer> result = new ArrayList<>();

        while (nestedIterator.hasNext()) {
            result.add(nestedIterator.next());
        }

        Assert.assertArrayEquals(new Integer[]{1, 3, 2}, result.toArray(new Integer[0]));

    }

    @Test
    public void emptyListTest() {
        NestedInteger nestedInteger1 = new NestedIntegerImpl(
                List.of(new NestedIntegerImpl())
        );

        FlattenNestedListIterator.NestedIterator nestedIterator = new FlattenNestedListIterator.NestedIterator(
                List.of(nestedInteger1)
        );

        List<Integer> result = new ArrayList<>();

        while (nestedIterator.hasNext()) {
            result.add(nestedIterator.next());
        }

        assert result.isEmpty();
    }


    static class NestedIntegerImpl implements NestedInteger {

        public NestedIntegerImpl() {
            this.list = Collections.emptyList();
        }

        private final List<NestedInteger> list;
        private Integer member;

        public NestedIntegerImpl(List<NestedInteger> list) {
            this.list = list;
        }

        public NestedIntegerImpl(Integer member) {
            this.member = member;
            this.list = Collections.emptyList();
        }

        @Override
        public boolean isInteger() {
            return this.list == null;
        }

        @Override
        public Integer getInteger() {
            return this.member;
        }

        @Override
        public List<NestedInteger> getList() {
            return this.list;
        }
    }

}