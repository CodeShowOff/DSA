package com.LearningJava.ArrayListImplement;

public class ArrayList {
    Integer[] array;
    int count = 0;

    ArrayList(int size){
        array = new Integer[size];
    }

    ArrayList(){
        array = new Integer[10];
    }

    void addFirst(int value){

        if(count < array.length) {
            for (int i = count; i > 0; i--) {
                array[i] = array[i - 1];
            }
            array[0] = value;

            this.count++;
        }else{
            copy();
            for (int i = count; i > 0; i--) {
                array[i] = array[i - 1];
            }
            array[0] = value;

            this.count++;
        }
    }

    void addLast(int value){

        if(count < array.length){
            array[count] = value;
            this.count++;
        }else{
            copy();
            array[count] = value;
            this.count++;
        }
    }

    void addAtIndex(int value, int index){
        if(index <= count) {
            for (int i = count; i > index; i--) {
                array[i] = array[i - 1];
            }
            array[index] = value;
            this.count++;
        }else{
            System.out.println("Index out of range.");
        }
    }


    void print(){
        for (int i = 0; i < count; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public void copy(){
        Integer[] newArray = new Integer[count + count];

        for(int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }

        this.array = newArray;
    }

    public static void main(String[] args) {

    }
}

