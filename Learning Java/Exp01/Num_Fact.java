/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BASIL.LOE.Exp01;

import java.util.Scanner;

/**
 *
 * @author 1761002
 */
public class Num_Fact {

    int number;
    int fa;

    public Num_Fact() {
        number = 1;
        fa = 1;
    }

    public int calc_facto(int n) {
        for (int i = 1; i <= n; i++) {
            fa = fa * i;
        }

        return fa;
    }

   

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            Num_Fact odo = new Num_Fact();
            int n;
            int result;

            System.out.println(" \t FACTORIAL CALCULATOR ");
            System.out.println("Enter a number ( < 10) : ");
            n = sc.nextInt();

            result = odo.calc_facto(n);

            System.out.println("\n Result = " + result);

        }
    }
