package com.LearningJava;

import java.util.*;

public class HashMapQuestions {
    public static void findFrequency(String str){
        HashMap<Character, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < str.length(); i++) {

            char temp = str.charAt(i);

            if(temp == ' '){
                continue;
            }
            if(map.containsKey(temp)){
                int curr = map.get(temp);
                map.put(temp, ++curr);
            }
            else{
                map.put(temp, 1);
            }
        }

        for(Character key : map.keySet()){
            System.out.println(key + " -> " + map.get(key));
        }
    }

    public static void findDuplicates(int[] arr){
        HashMap<Integer, Integer> list = new HashMap<>();

        for(Integer num : arr){
            if(list.containsKey(num)){
                list.put(num, list.get(num) + 1);
            }
            else{
                list.put(num, 1);
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        for(Integer num : list.keySet()){
            if(list.get(num) > 1){
                result.add(num);
            }
        }

        System.out.println(result);
    }

    public static void wordCount(String[] sentences){
        HashMap<String, Integer> map = new LinkedHashMap<>();

        for(int i = 0; i < sentences.length; i++) {

            String temp = sentences[i];

            if(map.containsKey(temp)){
                int curr = map.get(temp);
                map.put(temp, ++curr);
            }
            else{
                map.put(temp, 1);
            }
        }

        for(String key : map.keySet()){
            System.out.println(key + " -> " + map.get(key));
        }
    }

    public static void isAnagram(String str1, String str2){
        if(str1.length() != str2.length()){
            System.out.println("No");
            return;
        }

        HashMap<Character, Integer> map1 = new LinkedHashMap<>();
        HashMap<Character, Integer> map2 = new LinkedHashMap<>();


        for (int i = 0; i < str1.length(); i++) {

            char temp = str1.charAt(i);

            if(map1.containsKey(temp)){
                int curr = map1.get(temp);
                map1.put(temp, ++curr);
            }
            else{
                map1.put(temp, 1);
            }
        }
        for (int i = 0; i < str2.length(); i++) {

            char temp = str2.charAt(i);

            if(map2.containsKey(temp)){
                int curr = map2.get(temp);
                map2.put(temp, ++curr);
            }
            else{
                map2.put(temp, 1);
            }
        }

        for(Character chr : map1.keySet()){
            if(map2.containsKey(chr)){
                if(map1.get(chr) != map2.get(chr)){
                    System.out.println("No");
                    return;
                }
            }
            else{
                System.out.println("No");
                return;
            }
        }

        System.out.println("Yes");
    }

    // More Optimised:
    public static void isAnagram2(String str1, String str2){
        if(str1.length() != str2.length()){
            System.out.println("No");
            return;
        }

        HashMap<Character, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < str1.length(); i++) {

            char temp = str1.charAt(i);
            char temp2 = str2.charAt(i);

            if(map.containsKey(temp)){
                int curr = map.get(temp);
                map.put(temp, --curr);
            }
            else {
                map.put(temp, 1);
            }

            if(map.containsKey(temp2)){
                int curr = map.get(temp2);
                map.put(temp2, --curr);
            }
            else{
                map.put(temp2, 1);
            }
        }
        for (Character chr : map.keySet()) {
            if(map.get(chr) != 0){
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//        String str = sc.nextLine();
//        findFrequency(str);

//        int[] arr = new int[]{1, 2, 3, 1, 4, 5, 2};
//        findDuplicates(arr);

//        String[] sentences = sc.nextLine().split(" ");
//        wordCount(sentences);

//        String str1 = "silent";
//        String str2 = "listen";
//        isAnagram(str1, str2);
//        isAnagram2(str1, str2);

        sc.close();
    }
}
