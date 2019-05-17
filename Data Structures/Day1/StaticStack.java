/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day1;

import java.util.Scanner;

/**
 *
 * @author 1761002
 */
public class StaticStack {
    Scanner sc = new Scanner(System.in);
    int top = -1, max;
    int[] stack;

    void push() {
        if (top >= max - 1) {
            System.out.println("||OVERFLOW||");
        } else {
            System.out.print("\nInput : ");
            int a = sc.nextInt();
            stack[++top] = a;
            System.out.println(a + " stacked");
        }
    }

    void pop() {
        if (top == -1) {
            System.out.println("||UNDERFLOW||");
        } else {
            System.out.println(stack[top--] + " popped");
        }
    }

    void display() {
        if (top == -1) {
            System.out.println("Emptiness");
        } else {
            for (int i = 0; i <= top; i++) {
                System.out.print(" " + stack[i]);

            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StaticStack s = new StaticStack();

        System.out.println("\nSTATIC STACK\n");
        System.out.print("Stack limit :");
        s.max = sc.nextInt();
        s.stack = new int[s.max];
        int choice = 0;

        while (choice != 4) {
            System.out.print("\n\t MENU\n1.Push\n2.Pop\n3.Display\n4.Exit\nChoice : ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    s.push();
                    break;
                case 2:
                    s.pop();
                    break;
                case 3:
                    s.display();
                    break;
                case 4:
                    System.exit(0);

                default:
                    System.out.println("Invalid");
            }

        }

    }

}
