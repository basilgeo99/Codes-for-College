/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BASIL.LOE.Exp02;

import java.util.Scanner;

/**
 *
 * @author 1761002
 */
public class SwitchCalc {

    public float calculate(int x, int y, int z) {
        float ans = 0;
        switch (y) {
            case 1:
                ans = x + z;
                break;
            case 2:
                ans = x - z;
                break;
            case 3:
                ans = x * z;
                break;
            case 4:
                ans = x / z;
                break;
            default:
                System.out.println("Invalid Choice");

        }
        return ans;
    }

    public static void main(String[] args) {

        int a, b, c;
        float ans;
        Scanner sc = new Scanner(System.in);
        SwitchCalc obj = new SwitchCalc();

        System.out.println("CALCULATOR");
        System.out.println("MENU \n1.ADD\n2.SUBTRACT\n3.MULTIPLY\n4.DIVIDE\nChoice : ");
        c = sc.nextInt();
        System.out.println("Enter 2 operands : ");
        a = sc.nextInt();
        b = sc.nextInt();
        
        ans = obj.calculate(a, c, b);
        
        System.out.println("RESULT = "+ans);

    }
}
