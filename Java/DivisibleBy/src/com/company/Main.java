/*
Print all integer number that are divisible by 5 or 7 or 14 from the range(1, 10000)
 */

package com.company;

public class Main {

    public static void main(String[] args) {
        printDivisibleNumbers();
    }

    public static void printDivisibleNumbers() {
        for(int i = 1; i < 10000; i ++) {
            if (i % 5 == 0 || i % 7 == 0 || i % 14 == 0) {
                System.out.println(i);
            }
        }
    }

}
