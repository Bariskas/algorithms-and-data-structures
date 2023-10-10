package dev.ibulaev.algorithms;

import dev.ibulaev.algorithms.LinkedListAlgorithms.Node;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LinkedListAlgorithmsTest {

    @Test
    void when_CyclicList_then_true() {
        Node<Integer> cyclicListWithPointerInMiddle;

        Node<Integer> firstHead = new Node<>(1);
        Node<Integer> secondElement = new Node<>(2);
        firstHead.next = secondElement;
        Node<Integer> thirdElement = new Node<>(3);
        secondElement.next = thirdElement;
        Node<Integer> tailElement = new Node<>(4, secondElement);
        thirdElement.next = tailElement;

        cyclicListWithPointerInMiddle = firstHead;

        Assertions.assertTrue(LinkedListAlgorithms.hasCycle(cyclicListWithPointerInMiddle));
    }

    @Test
    void when_nonCyclicList_then_false() {
        Node<Integer> justListWithoutCycle = new Node<>(1,
            new Node<>(2, new Node<>(3, new Node<>(4))));

        Assertions.assertFalse(LinkedListAlgorithms.hasCycle(justListWithoutCycle));
    }

    @Test
    void when_palindrome_then_true() {
        Node<Integer> headOfPalindrome = new Node<>(1, new Node<>(2, new Node<>(2, new Node<>(1))));

        Assertions.assertTrue(LinkedListAlgorithms.isPalindrome(headOfPalindrome));
    }
}