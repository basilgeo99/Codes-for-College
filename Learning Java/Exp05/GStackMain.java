/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BASIL.LOE.Exp05;

/**
 *
 * @author 1761002
 */
public class GStackMain {
 
    public static void main(String[] args){
        GenericStack<String>GStackMain = new GenericStack();
        GStackMain.Push("Hello");
        GStackMain.Push("World");
        String f = GStackMain.Pop();  
        System.out.println("Popped item : " +f);
    }
}
