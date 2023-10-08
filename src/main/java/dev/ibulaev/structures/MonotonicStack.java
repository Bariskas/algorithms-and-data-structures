package dev.ibulaev.structures;

import java.util.Stack;

public class MonotonicStack {

    public static Stack<Integer> incStackFromIntArray(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        for (int j : arr) {
            while (!stack.empty() && stack.peek() > j) {
                stack.pop();
            }
            stack.push(j);
        }
        return stack;
    }
    public static Stack<Integer> decStackFromIntArray(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        for (int j : arr) {
            while (!stack.empty() && stack.peek() < j) {
                stack.pop();
            }
            stack.push(j);
        }
        return stack;
    }

}
