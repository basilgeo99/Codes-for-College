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
public class Meds {
    
    private String[] meds = new String[20];
    private double[] price = new double[20];
    Scanner read = new Scanner(System.in);
    private double totalBill = 0;
    
    public void MedList(int n){
        
        for(int i=0;i<n;i++){
            
            System.out.print("Enter Drug Name : ");
            meds[i] = read.nextLine();
            System.out.print("Enter Drug Price : ");
            price[i] = read.nextDouble();
            totalBill += price[i];
            read.nextLine();
        }
    }

    public double getTotalBill() {
        return totalBill;
    }
    
    public void PrintMedList(int n){
        System.out.println("List of Medicines : ");
        for(int i =0;i<n;i++){
            System.out.println(meds[i] + " ----- " + price[i]);
        }
        
    }
    
}
