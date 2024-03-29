/*
문제
1보다 큰 자연수 중에서  1과 자기 자신을 제외한 약수가 없는 자연수를 소수라고 한다. 예를 들어, 5는 1과 5를 제외한 약수가 없기 때문에 소수이다. 하지만, 6은 6 = 2 × 3 이기 때문에 소수가 아니다.

골드바흐의 추측은 유명한 정수론의 미해결 문제로, 2보다 큰 모든 짝수는 두 소수의 합으로 나타낼 수 있다는 것이다. 이러한 수를 골드바흐 수라고 한다. 또, 짝수를 두 소수의 합으로 나타내는 표현을 그 수의 골드바흐 파티션이라고 한다. 예를 들면, 4 = 2 + 2, 6 = 3 + 3, 8 = 3 + 5, 10 = 5 + 5, 12 = 5 + 7, 14 = 3 + 11, 14 = 7 + 7이다. 10000보다 작거나 같은 모든 짝수 n에 대한 골드바흐 파티션은 존재한다.

2보다 큰 짝수 n이 주어졌을 때, n의 골드바흐 파티션을 출력하는 프로그램을 작성하시오. 만약 가능한 n의 골드바흐 파티션이 여러 가지인 경우에는 두 소수의 차이가 가장 작은 것을 출력한다.

입력
첫째 줄에 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있고 짝수 n이 주어진다.

출력
각 테스트 케이스에 대해서 주어진 n의 골드바흐 파티션을 출력한다. 출력하는 소수는 작은 것부터 먼저 출력하며, 공백으로 구분한다.

검사할 때, n / 2로 검사하고 소수 집합 전체에서 돌리는 것이 아님.
 */

package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static ArrayList<Integer> primeNumber = new ArrayList<>();
    public static ArrayList<Boolean> sieve = new ArrayList<>();
    public static final int MAX = 10000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        makeSieve();

        int testCase = sc.nextInt();

        for(int i = 0; i < testCase; i++) {
            int number = sc.nextInt();
            int[] ans = conjecture(number);
            System.out.println(ans[0] + " " + ans[1]);
        }

    }
    public static void makeSieve() {
        sieve.add(0, false);
        sieve.add(1, false);

        for(int i = 2; i <= MAX; i++) {
            sieve.add(i, true);
        }
        for(int i = 2; i <= MAX; i++) {
            if(sieve.get(i)) {
                primeNumber.add(i);
                for(int j = i + i; j <= MAX; j += i) {
                    sieve.set(j, false);
                }
            }
        }
    }
    public static int[] conjecture(int n) {
        int first = n / 2, seconds = n / 2;
        int[] returns = new int[2];

        while(true) {
            if(primeNumber.contains(first) && primeNumber.contains(seconds)) {
                returns[0] = first; returns[1] = seconds;
                break;
            }
            first--; seconds++;
        }

        return returns;
    }
}
