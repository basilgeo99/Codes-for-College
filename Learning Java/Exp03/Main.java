/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BASIL.LOE.Exp03;

import java.util.Scanner;

/**
 *
 * @author 1761002
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of students : ");
        int n = sc.nextInt();
        Student[] mystudents = new Student[n];

       for(int i=0;i<n;i++){
           mystudents[i] = new Student();
       }
      
        for (int i = 0; i < n; i++) {
            mystudents[i].setDetails();
        }
        
        System.out.println("\n Do you want to see the details of the student? (y/n) : ");
        String ch = sc.next();
        
        if(ch.equalsIgnoreCase("y")){
            for(int i=0;i<n;i++){
                mystudents[i].getDetails();
            }
        }
        
        System.out.println("\n\tTHANKYOU!");
    }
}
