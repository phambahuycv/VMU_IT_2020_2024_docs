package com.company;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void sortAsc(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    swap(arr, i, j);
                }
            }
        }
    }

    public static void main(String[] args) {
	    // write your code here
        try {
            FileReader fr = new FileReader("data.txt");
            Scanner sc = new Scanner(fr);
            int length = sc.nextInt();
            int[] arr = new int[length];
            for (int i = 0; i < length; i++) {
                arr[i] = sc.nextInt();
            }

            System.out.println("Mảng đọc được từ tệp tin: ");
            for (int v: arr) {
                System.out.print(v);
                System.out.print(" ");
            }
            System.out.println();
            System.out.println("Sắp xếp mảng theo thứ tự tăng dần: ");
            sortAsc(arr);
            for (int v: arr) {
                System.out.print(v);
                System.out.print(" ");
            }
            System.out.println();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
}
