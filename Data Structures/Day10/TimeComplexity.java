/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day99_10;

import java.util.Scanner;
import Day6.HeapSort;
import Day7.MergeSort;
import Day8.QuickSort;
import java.util.Random;

/**
 *
 * @author tulsi
 */
public class TimeComplexity {

    public static void main(String[] args) {
        long timea, timeb;

        Scanner in = new Scanner(System.in);
        QuickSort qs = new QuickSort();
        MergeSort ms = new MergeSort();
        HeapSort hs = new HeapSort();
        Random r = new Random();

        System.out.println("Max Size : ");
        int size = in.nextInt();
        int arr[] = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = r.nextInt(500);
            System.out.println(arr[i]);
        }

        System.out.println("\n Time Complexity :: \n");
        timea = System.nanoTime();
        qs.sort(arr, 0, size-1);
        timeb = System.nanoTime();
        System.out.println("QUICKSORT : " + (timeb - timea));

        timea = System.nanoTime();
        hs.sort(arr);
        timeb = System.nanoTime();
        System.out.println("HEAPSORT : " + (timeb - timea));

        timea = System.nanoTime();
        ms.sort(arr, 0, size-1);
        timeb = System.nanoTime();
        System.out.println("MERGESORT : " + (timeb - timea));

    }

}
