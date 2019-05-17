/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HMS;

import java.util.Scanner;

/**
 *
 * @author slimjim
 */
public class Main {

    

    public static void main(String[] args) {

        System.out.println("HOSPITAL MANGAEMENT SYSTEM");
        Scanner read = new Scanner(System.in);
        int i = 0;        //for the User Class array
        User[] P = new User[10];
        String m;
        boolean flag = true;  //To make the number of patients dynamic
        while (flag) {
            P[i] = new User();

            P[i].ReadData();

            System.out.println("Display this patient's details ? (y/n) :");
            m = read.next();
            
            if(m.equalsIgnoreCase("y")){
                P[i].GetData();
            }
            
            System.out.println("New Patient? (y/n) : ");
            m = read.next();
            
            if(m.equalsIgnoreCase("y")){
                if(i<9){
                    i++;            //To check if the max limit 10 has reached or not
                }
                else{
                    System.out.println("Patient Capacity full !! ------ Exiting Program !");
                    flag = false;
                }
                
            }
            else{
                flag = false;
            }
            

        }
    }
}
