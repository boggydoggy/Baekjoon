/*
Write a function the will return multiplication of all digits in given number.
 */

package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String number = sc.next();

        int ans = multiDigits(number);

        System.out.println(ans);
    }

    public static int multiDigits(String num) {
        int digit = Character.getNumericValue(num.charAt(0));

        if (num.length() == 1) {
            return digit;
        }
        else {
            return digit * multiDigits(num.substring(1));
        }
    }
}
