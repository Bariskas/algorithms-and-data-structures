package dev.ibulaev.structures;

import java.util.Arrays;
import java.util.Stack;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MonotonicStackTest {

    @Test
    void exampleOfUsageIncStack() {
        int[] arr = {1, 4, 5, 3, 12, 10};
        Stack<Integer> monotonicStack = MonotonicStack.incStackFromIntArray(arr);
        int[] stackAsArrayFromTop = new int[monotonicStack.size()];

        int i = 0;
        while (!monotonicStack.empty()) {
            stackAsArrayFromTop[i++] = monotonicStack.pop();
        }
        //
        Assertions.assertArrayEquals(new int[]{10, 3, 1}, stackAsArrayFromTop);
        System.out.println(Arrays.toString(stackAsArrayFromTop));
    }

    @Test
    void exampleOfUsageDecStack() {
        int[] arr = {1, 4, 5, 3, 12, 10};
        Stack<Integer> monotonicStack = MonotonicStack.decStackFromIntArray(arr);
        int[] stackAsArrayFromTop = new int[monotonicStack.size()];

        int i = 0;
        while (!monotonicStack.empty()) {
            stackAsArrayFromTop[i++] = monotonicStack.pop();
        }
        //
        Assertions.assertArrayEquals(new int[]{10, 12}, stackAsArrayFromTop);
        System.out.println(Arrays.toString(stackAsArrayFromTop));
    }

}