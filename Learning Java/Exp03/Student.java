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
public class Student {

    private int regid;
    private String name;
    private int semester;
    private String section;
    private String grade;
    private double[] marks = new double[6];
    private double avgMarks;

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

    public void setsemester(int s) {
        semester = s;

    }

    public int getsemester() {
        return semester;
    }

    public void setsection(String s) {
        section = s;
    }

    public String getsection() {
        return section;
    }

    public void setmarks(int i) {
        marks[i] = sc.nextDouble();
    }

    public double getmarks(int i) {
        return marks[i];
    }

    public void setavgmarks() {
        double sum = 0.0;
        for (int i = 0; i < 6; i++) {
            sum += marks[i];
        }
        avgMarks = sum / 6;
    }

    public double getavgmarks() {
        return avgMarks;
    }

    public void setgrade() {
        double avg = getavgmarks();

        if (avg < 40) {
            grade = "fail";
        } else if (avg >= 40 && avg < 50) {
            grade = "E";
        } else if (avg >= 50 && avg < 60) {
            grade = "D";
        } else if (avg >= 60 && avg < 70) {
            grade = "C";
        } else if (avg >= 70 && avg < 80) {
            grade = "B";
        } else if (avg >= 80 && avg < 90) {
            grade = "A";
        } else {
            grade = "A+";
        }

    }

    public String getgrade() {
        return grade;
    }

    public void setDetails() {
        System.out.println("\n \t ENTER DETAILS");
        System.out.println("Enter Reg ID : ");
        int r = sc.nextInt();
        setregid(r);

        System.out.println("Enter name : ");
        String nm = sc.next();
        setname(nm);

        System.out.println("Enter semester : ");
        int sem = sc.nextInt();
        setsemester(sem);

        System.out.println("Enter section :");
        String sec = sc.next();
        setsection(sec);

        System.out.println("Enter Marks : ");
        for (int i = 0; i < 6; i++) {
            setmarks(i);
        }

        setavgmarks();
        setgrade();

        System.out.println("Grade = " + getgrade());

    }
    
    
        public void getDetails() {
        System.out.println("\n \t DETAILS");
        System.out.println("Reg ID : "+regid);
      

        System.out.println("Name : "+ name);
       

        System.out.println("Semester : "+semester);
       
        System.out.println("Section :"+section);
      

        System.out.println("Marks : ");
        for (int i = 0; i < 6; i++) {
            System.out.println(getmarks(i));
        }

       System.out.println("Average marks : "+avgMarks);

        System.out.println("Grade = " + grade);

    }
    
    

}
