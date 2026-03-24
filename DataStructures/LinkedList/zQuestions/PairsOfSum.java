package zQuestions;
/*
Given a sorted doubly linked list of positive distinct elements, the task is to find pairs in a doubly-linked list whose 
sum is equal to given value target.

Input:  
1 <-> 2 <-> 4 <-> 5 <-> 6 <-> 8 <-> 9
target = 7
Output: (1, 6), (2,5)
Explanation: We can see that there are two pairs (1, 6) and (2,5) with sum 7.
*/

import java.util.HashSet;

public class PairsOfSum {
    private static class Node{
        int data;
        zQuestions.Node next;

        // Constructor:
        Node(int data, zQuestions.Node next){
            this.data = data;
            this.next = next;
        }
        // Constructor:
        Node(int data){
            this.data = data;
            // if only data is provided that means, its the end of the LinkedList:
            this.next = null;
        }
    }
    // Hashing Approach (Optimised):
    static void findPairsWithGivenSum(Node head, int sum){
    
        HashSet<Integer> myMap = new HashSet<>();
        Node temp = head;

        while(temp != null){
            if(myMap.contains(sum - temp.data)){
                System.out.println((sum - temp.data) + " " + temp.data);
            }
            else{
                myMap.add(temp.data);
            }
        }
    }

    public static void main(String[] args) {
        
    }
}