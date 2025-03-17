package com.StackImplementation;

public class Tester {
    public static void main(String[] args) {
//        Stack<Integer> stack = new StackUsingArray<>(5);
        Stack<Integer> stack = new StackUsingLinkedList<>();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        stack.display();

        System.out.println("Top element: " + stack.peek());
        System.out.println("Popped: " + stack.pop());

        stack.display();
        System.out.println("Stack size: " + stack.size());
    }
}
