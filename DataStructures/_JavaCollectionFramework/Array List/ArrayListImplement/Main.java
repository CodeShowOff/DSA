package com.LearningJava.ArrayListImplement;

public class Main {
    public static void main(String[] args) {
        ArrayList obj = new ArrayList();

        obj.addFirst(4);
        obj.addFirst(3);

        obj.addLast(6);
        obj.addLast(7);
        obj.addLast(8);
        obj.addLast(9);

        obj.addFirst(2);
        obj.addFirst(1);

        obj.addAtIndex(5, 4);

        obj.print();

    }
}
