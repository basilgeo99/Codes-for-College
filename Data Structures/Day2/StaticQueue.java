/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day2;

import java.util.Scanner;

/**
 *
 * @author 1761002
 */
public class StaticQueue {

    int front = -1;
    int rear = -1;
    int[] Q ;
    int max;
    Scanner sc = new Scanner(System.in);

    void enqueue() {
        if (rear>=max-1) {
            System.out.println("Queue is Full");
        } else {
            if (front == -1) {
                front++;
            }
            System.out.print("\nInput : ");
            int a = sc.nextInt();
            Q[++rear] = a;
            System.out.println(a + " queued");
        }
    }

    void dequeue() {
        if (front ==-1 || front>rear) {
            System.out.println("Queue is Empty");
        } else {
            System.out.println(Q[front++] + " dequeued");
        }
    }

    void display() {
        if (front ==-1 || front >rear) {
            System.out.println("Queue is Empty");
        } else {
            System.out.print("[");
            for (int i = front; i <= rear; i++) {
                System.out.print(Q[i] + ",");
            }
            System.out.print("]");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StaticQueue q = new StaticQueue();

        System.out.println("\nSTATIC QUEUE\n");
        System.out.print("Queue limit :");
        q.max = sc.nextInt();
        q.Q = new int[q.max];
        int choice = 0;

        while (choice != 4) {
            System.out.print("\n\t MENU\n1.Enqueue\n2.Dequeue\n3.Display\n4.Exit\nChoice : ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    q.enqueue();
                    break;
                case 2:
                    q.dequeue();
                    break;
                case 3:
                    q.display();
                    break;
                case 4:
                    System.exit(0);

                default:
                    System.out.println("Invalid");
            }
            
        }

    }

}
