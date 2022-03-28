/*
문제
N-Queen 문제는 크기가 N × N인 체스판 위에 퀸 N개를 서로 공격할 수 없게 놓는 문제이다.

N이 주어졌을 때, 퀸을 놓는 방법의 수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N이 주어진다. (1 ≤ N < 15)

출력
첫째 줄에 퀸 N개를 서로 공격할 수 없게 놓는 경우의 수를 출력한다.

sol: 재귀함수로 백 트래킹 구현
 */

package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int N;
    public static int[] arr; //index: 열, 값: 행
    public static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        nQueen(0);

        System.out.println(count);
    }

    public static void nQueen(int depth) {
        if(depth == N) {
            count++;
            return;
        }
        for(int i = 0; i < N; i++) {
            arr[depth] = i;
            if(possibility(depth)) {
                nQueen(depth + 1);
            }
        }
    }

    public static boolean possibility(int col) {
        for(int i = 0; i < col; i++) {
            if(arr[col] == arr[i]) { //같은 행에 있는 경우
                return false;
            }
            else if (Math.abs(col - i) == Math.abs(arr[col] - arr[i])) { //대각선에 있는 경우
                return false;
            }
        }

        return true;
    }
}
