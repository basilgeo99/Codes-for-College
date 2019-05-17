/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BASIL.LOE.Exp01;

import java.util.Scanner;

/**
 *
 * @author 1761002
 */
public class Array_Search {

    int arr[] = new int[50];

    public static void main(String[] args) {
        Array_Search a = new Array_Search();
        int size = 0;
        int key;
        String m = "y";
        Scanner sc = new Scanner(System.in);
        System.out.println("ARRAY SEARCH PROGRAM ");
        System.out.println("ARRAY INPUT");

        do {
            System.out.println("\nSize must be less than 50!");
            System.out.println("\nEnter the array size required");
            size = sc.nextInt();
        } while (size > 50);

        System.out.println("\nInput values into array : ");
        for (int i = 0; i < size; i++) {
            a.arr[i] = sc.nextInt();
        }

        System.out.println("\nARRAY SEARCH PROGRAM ");

        do {
            System.out.println("\nEnter the value to be searched : ");
            key = sc.nextInt();
            boolean flag = false;
            for (int i = 0; i < size; i++) 
                {
                if (key == a.arr[i])
                    { 
                    System.out.println("\nValue " + key + " found at position " + (i + 1));
                    flag = true;
                    break;
                    }
                }
                
                if(!flag)
                {
                    System.out.println("Not Found");    
                }
                System.out.println("\nWant to search more ? (y/n) : ");
                m = sc.next();
            
        } while (!m.equalsIgnoreCase("n"));
    }

}
