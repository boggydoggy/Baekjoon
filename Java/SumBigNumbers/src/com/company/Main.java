package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String a = sc.next(), b = sc.next();

        int[] parseA = new int[a.length() + 1], parseB = new int[b.length() + 1];

        for(int i = 0, j = a.length() - 1; i < a.length(); i++, j--) {
            parseA[i] = a.charAt(j) - '0';
        }
        for(int i = 0, j = b.length() - 1; i < b.length(); i++, j--) {
            parseB[i] = b.charAt(j) - '0';
        }

        int min_length;
        int[] ans;
        int[] less;


        if(a.length() > b.length()) {
            min_length = b.length();
            ans = parseA.clone();
            less = parseB.clone();
        }
        else {
            min_length = a.length();
            ans = parseB.clone();
            less = parseA.clone();
        }

        for(int i = 0; i < min_length; i++) {
            if(ans[i] + less[i] > 9) {
                ans[i] = (ans[i] + less[i]) % 10;
                ans[i+1] += 1;
            }
            else {
                ans[i] += less[i];
            }

        }

        int ansLength = ans.length - 1;

        if(ans[ans.length - 1] == 0) {
            ansLength -= 1;
        }

        StringBuilder sb = new StringBuilder();

        for(int i = ansLength; i >= 0; i--) {
            sb.append(ans[i]);
        }

        System.out.println(sb);
    }
}
