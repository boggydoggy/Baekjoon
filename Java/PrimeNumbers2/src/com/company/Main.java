/*
문제
M이상 N이하의 소수를 모두 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 자연수 M과 N이 빈 칸을 사이에 두고 주어진다. (1 ≤ M ≤ N ≤ 1,000,000) M이상 N이하의 소수가 하나 이상 있는 입력만 주어진다.

출력
한 줄에 하나씩, 증가하는 순서대로 소수를 출력한다.

에라토스테네스의 체로 구현.
 */

package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt(), n = sc.nextInt();

        getPrimeNumbers(m, n);
    }

    public static void getPrimeNumbers(int m, int n) {
        int[] chart = new int[n];

        chart[0] = 1;

        for(int i = 2; i < n; i++) {
            for(int j = 2; i*j <= n; j++) {
                chart[i*j - 1] = 1;
            }
        }

        for(int i = m - 1; i < n; i++) {
            if(chart[i] == 0) {
                System.out.println(i + 1);
            }
        }
    }
}
