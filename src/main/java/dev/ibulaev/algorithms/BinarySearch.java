package dev.ibulaev.algorithms;

import java.util.Comparator;
import java.util.List;

public class BinarySearch {

    public static <T extends Comparable<? super T>> int binarySearch(List<T> arrToSearch,
        T element) {
        int left = 0;
        int right = arrToSearch.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            T midValue = arrToSearch.get(mid);
            if (midValue.compareTo(element) < 0) {
                left = mid + 1;
            } else if (midValue.compareTo(element) > 0) {
                right = mid - 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    public static <T> int binarySearch(List<T> arr, T el, Comparator<T> comparator) {
        int left = 0;
        int right = arr.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            T midValue = arr.get(mid);
            int compareResult = comparator.compare(midValue, el);
            if (compareResult < 0) {
                left = mid + 1;
            } else if (compareResult > 0) {
                right = mid - 1;
            } else {
                return mid;
            }
        }

        return -1;
    }
}
