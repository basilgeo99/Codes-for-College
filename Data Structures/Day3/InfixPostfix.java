/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day3;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author 1761002
 */
public class InfixPostfix {
    
    
    //To check precedence of scanned operator
    static int precedence(char c) {
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    //Magic factory  - - Evrything happens here
    static String infixPostfix(String original) {

        String result = new String("");                 //To store postfix expression
        Stack<Character> stack = new Stack<>();         //Stack for the operators

        for (int i = 0; i < original.length(); i++) {
            char c = original.charAt(i);

            //if operand then add to result
            if (Character.isLetterOrDigit(c)) {
                result += c;
            } 
            //otherwise cases follow --->
            
            //open parenthesis you can just push
            else if (c == '(') {
                stack.push(c);
            } 
            
            //closing parenthesis take some effort
            else if (c == ')') {
                //popping everyting until you encounter an opening parenthesis
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result += stack.pop();
                }
                /*if your stack is not empty and you did not encounter
                  opening parenthesis then the original expression is wrong
                */
                if (!stack.isEmpty() && stack.peek() != '(') {
                    return "Invalid Expression";
                } 
                //opening parenhesis exist
                //since parenthesis don't go in postfix -- remove
                else {
                    stack.pop();
                }
            }
            
            //for other operators
            else{
                //popping higher precedence if lower precedence operator is in stack
                while(!stack.isEmpty() && precedence(c)<=precedence(stack.peek())){
                    result+=stack.pop();
                }
                //pushing the new opeartor 
                stack.push(c);
            }

        }
        //popping everything out finally
        while(!stack.isEmpty()){
            result+=stack.pop();
        }
        return result;

    }
    
    
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("\nInfix Expression : ");
        String original = new String();
        original = sc.nextLine();
        System.out.print("\nPostfix Expression : " + infixPostfix(original));
        
    }

}
