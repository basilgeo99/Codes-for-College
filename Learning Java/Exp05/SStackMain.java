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
public class SStackMain {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        GenericStack<Student> Stack = new GenericStack();
        
        Student S1 = new Student();
        Student S2 = new Student();
        
        System.out.println("Stuent 1 deatils : ");
        S1.setDetails();
        Stack.Push(S1);
        
        System.out.println("Student 2 details : ");
        S2.setDetails();
        Stack.Push(S2);
        
        System.out.println("Pop ?:  ");
        String m = read.next();
        
        if(m.equalsIgnoreCase("y")){
            Student f = Stack.Pop();
            System.out.println("Popped item : " );
            f.getDetails();
        }
        
    }
}
