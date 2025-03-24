package ru.npsolonenko;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Arrays;
import java.util.List;

public class SortedStreamJoiner {
    public <A> Iterator<A> joinSortedStreams(Iterator<A> first, Iterator<A> second, Comparator<A> comp) {
        return new Iterator<A>() {
            private A firstCurrent = first.hasNext() ? first.next() : null;
            private A secondCurrent = second.hasNext() ? second.next() : null;

            @Override
            public boolean hasNext() {
                return firstCurrent != null || secondCurrent != null;
            }

            @Override
            public A next() {
                if (firstCurrent == null && secondCurrent == null)
                    throw new java.util.NoSuchElementException();

                if (firstCurrent == null) {
                    A result = secondCurrent;
                    secondCurrent = second.hasNext() ? second.next() : null;
                    return result;
                }

                if (secondCurrent == null) {
                    A result = firstCurrent;
                    firstCurrent = first.hasNext() ? first.next() : null;
                    return result;
                }

                if (comp.compare(firstCurrent, secondCurrent) <= 0) {
                    A result = firstCurrent;
                    firstCurrent = first.hasNext() ? first.next() : null;
                    return result;
                }
                else {
                    A result = secondCurrent;
                    secondCurrent = second.hasNext() ? second.next() : null;
                    return result;
                }
            }
        };
    }

    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1, 3, 7);
        List<Integer> list2 = Arrays.asList(2, 4, 6, 5);

        Iterator<Integer> mergedNumbers = new SortedStreamJoiner().joinSortedStreams(
                list1.iterator(),
                list2.iterator(),
                Comparator.naturalOrder()
        );

        System.out.println("Joined array:");
        while (mergedNumbers.hasNext())
            System.out.print(mergedNumbers.next() + " ");
    }
}
