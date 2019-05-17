/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day5;

/**
 *
 * @author tulsi
 */

import java.util.Scanner;



public class BinarySearchTree {
    class Node{
        int key;
        Node left,right;
        public Node(int item){
            key=item;
            left=right=null;
        }
    }
    Node root;
    BinarySearchTree(){
        root=null;
    }
    void insert(int key){
        root=insertRec(root,key);
    }
    void deleteKey(int key){
        root=deleteRec(root,key);
    }
    Node insertRec(Node root,int key){
        if(root==null){
            root=new Node(key);
            return root;
        }
        if(key<root.key){
            root.left=insertRec(root.left,key);
        }else if(key>root.key){
            root.right=insertRec(root.right,key);
        }
        return root;
    }
    Node deleteRec(Node root,int key){
        if(root==null){
            root=null;
        }
        if(key<root.key){
            root.left=deleteRec(root.left,key);
        }else if(key>root.key){
            root.right=deleteRec(root.right,key);
        }else{
            if(root.left==null){
                return root.right;
            }else if(root.right==null){
                return root.left;
            }
            root.key=minValue(root.right);
            root.right=deleteRec(root.right,root.key);
        }
            return root;
    }
    int minValue(Node root){
        int minv=root.key;
        while(root.left!=null){
            minv=root.left.key;
            root=root.left;
        }
        return minv;
    }
    void inorder(){
        inorderRec(root);
    }
    void inorderRec(Node root){
        if(root!=null){
            inorderRec(root.left);
            System.out.println(root.key);
            inorderRec(root.right);
        }
    }
    public static void main(String[] args){
        BinarySearchTree tree=new BinarySearchTree();
        Scanner in=new Scanner(System.in);
        int choice,element;
        while(true){
        System.out.println("1.Insert\n2.Delete\n3.Display\n4.exit\n:::::::::::");
        choice=in.nextInt();
        switch(choice){
            case 1:
                System.out.println("Enter element to insert:");
                element=in.nextInt();
                tree.insert(element);
                System.out.println("Element="+element+" is inserted");
                break;
            case 2:
                System.out.println("Enter element to delete:");
                element=in.nextInt();
                tree.deleteKey(element);
                System.out.println("Element="+element+" is deleted");
                break;
            case 3:
                System.out.println("Elements are:");
                tree.inorder();
                break;
            case 4:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid Input");
                
        }
    
    }
    
}
}
