/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BASIL.LOE.Exp02;

import java.util.Scanner;

/**
 *
 * @author 1761002
 */
public class Matadd {

    int a[][] = new int[10][10];
    int b[][] = new int[10][10];

    public static void main(String[] args) {
        int m, n, i, j;
        Scanner sc = new Scanner(System.in);
        Matadd dod = new Matadd();
        System.out.println("\nMatrix Add Program");

        do {
            System.out.println("\nSize Values must be less than 5! ");
            System.out.println("Row size : ");
            m = sc.nextInt();
            System.out.println("Column Size : ");
            n = sc.nextInt();
        } while (m > 5 && n > 5);

        System.out.println("\nEnter values for MATRIX A : ");

        for (i = 0; i < m; i++) {
            for (j = 0; j < n; j++) {
                System.out.println("Position " + i + "," + j + " : ");
                dod.a[i][j] = sc.nextInt();
            }
        }

        System.out.println("\nEnter values for MATRIX B : ");

        for (i = 0; i < m; i++) {
            for (j = 0; j < n; j++) {
                System.out.println("Position " + i + "," + j + " : ");
                dod.b[i][j] = sc.nextInt();
            }
        }

        //ADDING STARTS HERE 
        for (i = 0; i < m; i++) {
            for (j = 0; j < n; j++) {
                dod.a[i][j] += dod.b[i][j];
            }
        }

        System.out.println("\nMatrix A + matrix B = ");

        for (i = 0; i < m; i++) {
            System.out.println();
            for (j = 0; j < n; j++) {
                System.out.print(" " + dod.a[i][j]);
            }
        }
 
    }
}
