/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BASIL.LOE.Exp05;


import java.util.Scanner;

/**
 *
 * @author 1761002
 */
public class Student {

    private int regid;
    private String name;
   

    Scanner sc = new Scanner(System.in);

    public void setregid(int r) {
        regid = r;

    }

    public int getregid() {
        return regid;
    }

    public void setname(String n) {
        name = n;
    }

    public String getname() {
        return name;
    }

  

    public void setDetails() {
        System.out.println("\n \t ENTER DETAILS");
        System.out.println("Enter Reg ID : ");
        int r = sc.nextInt();
        setregid(r);

        System.out.println("Enter name : ");
        String nm = sc.next();
        setname(nm);

    
    }
    
    
        public void getDetails() {
        System.out.println("\n \t DETAILS");
        System.out.println("Reg ID : "+regid);
      

        System.out.println("Name : "+ name);
      
    }
    
    

}
