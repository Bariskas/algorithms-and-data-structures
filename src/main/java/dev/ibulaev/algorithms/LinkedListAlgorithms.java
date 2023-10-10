package dev.ibulaev.algorithms;

public class LinkedListAlgorithms {
    public static <E> boolean hasCycle(Node<E> head) {
        if (head == null) {
            return false;
        }

        Node slow, fast;
        slow = fast = head;

        while (slow.next != null && fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                return true;
            }
        }

        return false;
    }

    public static <E> boolean isPalindrome(Node<E> head) {
        if (head == null) {
            return false;
        }

        Node<E> middle = middleNode(head);
        Node<E> reversedFromMiddle = reverseList(middle);

        while (reversedFromMiddle != null) {
            if (reversedFromMiddle.val != reversedFromMiddle.val) {
                return false;
            }

            reversedFromMiddle = reversedFromMiddle.next;
            head = head.next;
        }

        return true;
    }
    public static <E> Node<E> middleNode(Node<E> head) {
        Node<E> slow, fast;
        slow = fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
    public static <E> Node<E> reverseList(Node<E> head) {
        Node<E> prev, cur;
        prev = null;
        cur = head;

        while (cur != null) {
            Node<E> next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
    public static class Node<E> {
        E val;
        Node<E> next;

        Node(E element, Node<E> next) {
            this.val = element;
            this.next = next;
        }


        Node(E element) {
            this.val = element;
        }
    }
}
