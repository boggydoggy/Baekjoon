/*
문제
자연수 M과 N이 주어질 때 M이상 N이하의 자연수 중 소수인 것을 모두 골라 이들 소수의 합과 최솟값을 찾는 프로그램을 작성하시오.

예를 들어 M=60, N=100인 경우 60이상 100이하의 자연수 중 소수는 61, 67, 71, 73, 79, 83, 89, 97 총 8개가 있으므로, 이들 소수의 합은 620이고, 최솟값은 61이 된다.

입력
입력의 첫째 줄에 M이, 둘째 줄에 N이 주어진다.

M과 N은 10,000이하의 자연수이며, M은 N보다 작거나 같다.

출력
M이상 N이하의 자연수 중 소수인 것을 모두 찾아 첫째 줄에 그 합을, 둘째 줄에 그 중 최솟값을 출력한다.

단, M이상 N이하의 자연수 중 소수가 없을 경우는 첫째 줄에 -1을 출력한다.

제한 시간 1초
 */

package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt(), n = sc.nextInt();

        ArrayList<Integer> sets = getPrimeNumbers(m, n);

        if(sets.get(0) == -1) {
            System.out.println(-1);
        }
        else {
            int firstAns = sumNumbers(sets);

            System.out.println(firstAns);
            System.out.println(sets.get(0));
        }

    }

    public static ArrayList<Integer> getPrimeNumbers(int m, int n) {
        ArrayList<Integer> primeNumbers = new ArrayList<>();

        for(int i = m; i <= n; i++) {
            boolean check = false;
            if(i == 2) {
                primeNumbers.add(2);
                continue;
            }
            if(i == 1 || i % 2 == 0) {
                continue;
            }
            for(int j = 3; j < i; j+=2) {
                if (i % j == 0) {
                    check = true;
                    break;
                }
            }
            if(!check) {
                primeNumbers.add(i);
            }
        }

        if(primeNumbers.isEmpty()) {
            primeNumbers.add(-1);
        }

        return primeNumbers;
    }

    public static int sumNumbers(ArrayList<Integer> numbers) {
        int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }

        return sum;
    }
}
