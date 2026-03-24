package com.Codes.Recursion;

public class PrintNumbers {
    private static void printReverse(int num){
        if(num == 0) {
            return;
        }
        System.out.println(num);
        printReverse(num - 1);
    }

    private static void printForward(int num){
        if(num == 0) {
            return;
        }
        printForward(num - 1);
        System.out.println(num);
    }

    public static void main(String[] args) {
        printReverse(10);
        printForward(10);
    }
}
