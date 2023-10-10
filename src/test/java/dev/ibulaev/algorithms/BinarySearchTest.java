package dev.ibulaev.algorithms;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BinarySearchTest {

    @Test
    void when_elementExist_then_indexReturned() {
        List<Long> longList = List.of(1L, 2L, 4L, 5L);
        List<Double> doubleList = List.of(3., 4., 5., 8., 9.);
        List<ComparableObject> comparableObjects = List.of(
            ComparableObject.of(1),
            ComparableObject.of(2),
            ComparableObject.of(3),
            ComparableObject.of(3),
            ComparableObject.of(4));

        List<NonComparableObject> nonComparableObjects = List.of(
            NonComparableObject.of(1),
            NonComparableObject.of(2),
            NonComparableObject.of(3),
            NonComparableObject.of(3),
            NonComparableObject.of(4));

        Assertions.assertEquals(0, BinarySearch.binarySearch(longList, 1L));
        Assertions.assertEquals(1, BinarySearch.binarySearch(longList, 2L));
        Assertions.assertEquals(3, BinarySearch.binarySearch(longList, 5L));
        Assertions.assertEquals(4, BinarySearch.binarySearch(doubleList, 9.));
        Assertions.assertEquals(1, BinarySearch.binarySearch(doubleList, 4.));
        Assertions.assertEquals(0, BinarySearch.binarySearch(comparableObjects, ComparableObject.of(1)));
        Assertions.assertEquals(2, BinarySearch.binarySearch(comparableObjects, ComparableObject.of(3)));
        Assertions.assertEquals(4, BinarySearch.binarySearch(comparableObjects, ComparableObject.of(4)));
        Assertions.assertEquals(0, BinarySearch.binarySearch(nonComparableObjects, NonComparableObject.of(1), NonComparableObject.comparatorByValue()));
        Assertions.assertEquals(2, BinarySearch.binarySearch(nonComparableObjects, NonComparableObject.of(3), NonComparableObject.comparatorByValue()));
        Assertions.assertEquals(4, BinarySearch.binarySearch(nonComparableObjects, NonComparableObject.of(4), NonComparableObject.comparatorByValue()));
    }

    @Test
    void when_elementNotExist_then_minusOneReturned() {
        List<Long> longList = List.of(1L, 2L, 4L, 5L);
        List<Double> doubleList = List.of(3., 4., 5., 8., 9.);
        List<ComparableObject> comparableObjects = List.of(
            ComparableObject.of(1),
            ComparableObject.of(2),
            ComparableObject.of(3),
            ComparableObject.of(3),
            ComparableObject.of(4));

        List<NonComparableObject> nonComparableObjects = List.of(
            NonComparableObject.of(1),
            NonComparableObject.of(2),
            NonComparableObject.of(3),
            NonComparableObject.of(3),
            NonComparableObject.of(4));

        Assertions.assertEquals(-1, BinarySearch.binarySearch(longList, 0L));
        Assertions.assertEquals(-1, BinarySearch.binarySearch(doubleList, 10.));
        Assertions.assertEquals(-1, BinarySearch.binarySearch(comparableObjects, ComparableObject.of(6)));
        Assertions.assertEquals(-1, BinarySearch.binarySearch(nonComparableObjects, NonComparableObject.of(5), NonComparableObject.comparatorByValue()));
    }

    static class ComparableObject implements Comparable<ComparableObject> {

        private final Integer value;

        private ComparableObject(Integer value) {
            this.value = value;
        }

        @Override
        public int compareTo(ComparableObject o) {
            return value.compareTo(o.value);
        }

        public static ComparableObject of(Integer value) {
            return new ComparableObject(value);
        }
    }

    static class NonComparableObject {
        private final Integer value;
        private NonComparableObject(Integer value) {
            this.value = value;
        }

        public static NonComparableObject of(Integer value) {
            return new NonComparableObject(value);
        }

        public static Comparator<NonComparableObject> comparatorByValue() {
//            return (l, r) -> l.value.compareTo(r.value);
            return Comparator.comparing(l -> l.value);
        }
    }
}