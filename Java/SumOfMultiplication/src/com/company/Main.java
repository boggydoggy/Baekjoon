/*
Write a function that will sum all results of multiplication in multiplication table
up to the number given by user. For example, for argument 3 the table looks like this
and the sum of the results is 1+2+2+3+3+4+6+6+9=36
 */

package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        int ans = cal_num(num);

        System.out.println(ans);
    }

    public static int cal_num(int num) {
        int count = 0;

        for (int i = 1; i < num + 1; i++) {
            for(int j = 1; j < num + 1; j++) {
                int cal = i * j;
                count += cal;
            }
        }
        return count;
    }
}
