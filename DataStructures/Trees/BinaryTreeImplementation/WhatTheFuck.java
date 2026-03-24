package BinaryTreeImplementation;

import java.util.LinkedList;
import java.util.*;

public class WhatTheFuck {
//public class BinaryTree {
    private static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.data=val;
        }
    }
    public static TreeNode insertAtlevel(TreeNode root , int val) {
        TreeNode p=new TreeNode(val);
        if(root==null) {
            return p;
        }
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode t= queue.poll();
            if(t.left== null) {
                t.left=p;
                break;
            }else {
                queue.add(t.left);
            }
            if(t.right==null) {
                t.right=p;
                break;
            }
            else {
                queue.add(t.right);
            }
        }


        return root;
    }
    static ArrayList<Integer> List=new ArrayList<>();
    static int max= Integer.MIN_VALUE;
    static int min =Integer.MAX_VALUE;

    public static void inOrder(TreeNode root) {
        if(root==null)return;
        inOrder(root.left);
        //System.out.println(root.data + " ");
        List.add(root.data);
        inOrder(root.right);
        if(min >root.data)min =root.data;
        if(max<root.data) max=root.data;
    }

    public static void main(String[] args) {
        TreeNode root=insertAtlevel(null,25);
        root=insertAtlevel(root,15);
        root=insertAtlevel(root,50);
        root=insertAtlevel(root,10);
        root=insertAtlevel(root,22);
        root=insertAtlevel(root,35);
        root=insertAtlevel(root,70);
        root=insertAtlevel(root,4);
        root=insertAtlevel(root,12);
        root=insertAtlevel(root,18);
        root=insertAtlevel(root,24);
        root=insertAtlevel(root,31);
        root=insertAtlevel(root,34);
        root=insertAtlevel(root,66);
        root=insertAtlevel(root,90);

        inOrder(root);
        //System.out.println(List.toString());
        System.out.print(min+ " "+ max);
    }
}