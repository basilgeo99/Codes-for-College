/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BASIL.LOE.Exp06;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author 1761002
 */
public class ExcepRecon {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        int[] arr = new int[10];
        boolean flag;
        do {
            flag = false;
            System.out.print("Enter your number : ");
            int num = read.nextInt();
            System.out.print("Enter the index where you want to save : ");
            int index = read.nextInt();

            try {
                arr[index] = num;
            } catch (ArrayIndexOutOfBoundsException arrexc) {
                System.out.println("Index match error!");
                flag = true;
            } finally {
                System.out.println("Good Job");
            }

        } while (flag);
        
    }
}
