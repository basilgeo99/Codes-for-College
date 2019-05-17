/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day6;

import java.util.Scanner;

/**
 *
 * @author tulsi
 */

public class Hashing {

    public void insert(int n, int arr[]) {
        int s = arr.length;
        int count = 0;
        int index = n % s;
        for (int i = 0; i < s; i++) {
            if (arr[i] == 0) {
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Table is full...!!!");
        } else {
            while (arr[index] != 0) {
                index = (index + 1) % 10;
            }
            arr[index] = n;
        }
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int arr[] = new int[10];
        Hashing h = new Hashing();
        while (true) {
            System.out.println("1.Enter element\n2.display table\n3.exit:::");
            int c = in.nextInt();
            switch (c) {
                case 1:
                    System.out.println("Enter element:");
                    h.insert(in.nextInt(), arr);
                    System.out.println("Element inserted");
                    break;
                case 2:
                    for (int j = 0; j < arr.length; j++) {
                        System.out.println("index =" + j + "  " + arr[j]);
                    }
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid input");
            }
        }
    }
}