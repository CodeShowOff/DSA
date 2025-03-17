package com.LearningJava;

import java.util.*;

public class BasicQuestions {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        ArrayList<Integer> myList = new ArrayList<>(size);

        for(int i = 0; i < size; i++){
            myList.add(sc.nextInt());
        }

        for(Integer x : myList){
            System.out.print(x + " ");
        }

        for(int i = 0; i < size; i++){
            int num = myList.get(i);
            System.out.print(num + " ");
        }

        boolean b = myList.contains(50);
        int index = myList.indexOf(50);
        int lastIndex = myList.lastIndexOf(50);

        int v = myList.remove(myList.indexOf(50));

        myList.set(2, 40);
        myList.add(2, 30);

        int v2 = myList.get(3);


        int max = Integer.MIN_VALUE;
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1,2,2,3,4,4,5));
        for(Integer num: list){
            if(num > max){
                max = num;
            }
        }
//        or
        int maxNum = Collections.max(list);
        System.out.println(maxNum);

        Collections.reverse(list);
        System.out.println(list);

        LinkedHashSet<Integer> resList = new LinkedHashSet<>(list);
//        or
        resList.addAll(list);
        System.out.println(resList);


        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1,2,3,4));
        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(3,4,5,6,7));

        list1.addAll(list2);
        Collections.sort(list1);
        System.out.println(list1);


        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1,2,3,4));
        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(3,4,5,6,7));
//        Method-1:
        list1.retainAll(list2);
        System.out.println(list1);


        sc.close();
    }
}
