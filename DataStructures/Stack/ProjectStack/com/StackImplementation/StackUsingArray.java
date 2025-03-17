package com.StackImplementation;

import java.util.EmptyStackException;

public class StackUsingArray<T> implements Stack<T>{

    T[] stack;
    int top;

    @SuppressWarnings("unchecked")
    StackUsingArray(int size){
        this.stack = (T[]) new Object[size]; // Generic array creation
        this.top = -1;
    }

    @Override
    public void push(T val){
        if(top == stack.length - 1){
            throw new StackOverflowError("Stack is full.");
        }
        stack[++top] = val;
    }

    @Override
    public T pop(){
        if(top == -1){
            throw new EmptyStackException();
        }
        return stack[top--];
    }

    @Override
    public T peek(){
        if(top == -1){
            throw new EmptyStackException();
        }
        return stack[top];
    }

    @Override
    public int size(){
        return top + 1;
    }

    @Override
    public boolean empty(){
        return top == -1;
    }

    @Override
    public void display() {
        if (empty()) {
            System.out.println("Stack is empty");
            return;
        }
        System.out.print("Stack elements: ");
        for (int i = 0; i <= top; i++) {
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }
}
