package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String a = sc.next(), b = sc.next();

        int maxLength = Math.max(a.length(), b.length());
        int[] parseA = new int[maxLength + 1], parseB = new int[maxLength + 1];

        for(int i = 0, j = a.length() - 1; i < a.length(); i++, j--) {
            parseA[i] = a.charAt(j) - '0';
        }
        for(int i = 0, j = b.length() - 1; i < b.length(); i++, j--) {
            parseB[i] = b.charAt(j) - '0';
        }

        for(int i = 0; i < maxLength; i++) {
            int value = parseA[i] + parseB[i];
            parseA[i] = value % 10;
            parseA[i+1] += value / 10;
        }

        if(parseA[maxLength] == 0) {
            maxLength -= 1;
        }

        StringBuilder sb = new StringBuilder();

        for(int i = maxLength; i >= 0; i--) {
            sb.append(parseA[i]);
        }

        System.out.println(sb);
    }
}
