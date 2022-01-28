/*
문제
N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.

입력
첫째 줄에 수의 개수 N(1 ≤ N ≤ 10,000,000)이 주어진다. 둘째 줄부터 N개의 줄에는 수가 주어진다. 이 수는 10,000보다 작거나 같은 자연수이다.

출력
첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.

Java 11: 3 초
Java 11: 512 MB

solution: 카운팅 정렬 사용
 */

package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int[] arr;
    public static int[] counting = new int[10000];
    public static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        arr = new int[num];
        result = new int[num];

        for(int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        countValue();
        sumCounting();
        makeResult();

        StringBuilder sb = new StringBuilder();

        for (int j : result) {
            sb.append(j).append("\n");
        }

        System.out.print(sb);
    }

    public static void countValue() {
        for(int i = 0; i < arr.length; i++) {
            counting[arr[i]-1]++;
        }
    }

    public static void sumCounting() {
        for(int i = 1; i < counting.length; i++) {
            counting[i] += counting[i - 1];
        }
    }

    public static void makeResult() {
        for(int  i = arr.length - 1; i >= 0; i--) {
            int value = arr[i];
            counting[value-1]--;
            result[counting[value-1]] = value;
        }
    }
}
