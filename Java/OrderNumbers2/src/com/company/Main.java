/*
문제
N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.

입력
첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000,000)이 주어진다. 둘째 줄부터 N개의 줄에는 수가 주어진다. 이 수는 절댓값이 1,000,000보다 작거나 같은 정수이다. 수는 중복되지 않는다.

출력
첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.

solution: merge sort 이용, quick sort인 Arrays.sort()는 시간초과, println이 시간을 많이 소비하니 StringBuilder로 하나의 string으로 만든 다음
한번에 출력
 */

package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());

        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 0; i < num; i++) {
            arr.add(Integer.parseInt(br.readLine())) ;
        }

        Collections.sort(arr);

        for(int i = 0; i < num; i++) {
            sb.append(arr.get(i)).append('\n');
        }
        System.out.println(sb);
    }
}
