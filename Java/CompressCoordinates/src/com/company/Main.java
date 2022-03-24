/*
문제
수직선 위에 N개의 좌표 X1, X2, ..., XN이 있다. 이 좌표에 좌표 압축을 적용하려고 한다.

Xi를 좌표 압축한 결과 X'i의 값은 Xi > Xj를 만족하는 서로 다른 좌표의 개수와 같아야 한다.

X1, X2, ..., XN에 좌표 압축을 적용한 결과 X'1, X'2, ..., X'N를 출력해보자.

입력
첫째 줄에 N이 주어진다.

둘째 줄에는 공백 한 칸으로 구분된 X1, X2, ..., XN이 주어진다.

출력
첫째 줄에 X'1, X'2, ..., X'N을 공백 한 칸으로 구분해서 출력한다.

Solution: 오름차순으로 0부터 순위를 매기고 Hashmap 사용
 */

package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[] arr = new int[num];
        int[] sorted = new int[num];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        sorted = arr.clone();
        Arrays.sort(sorted);
        int rank = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < num; i++) {
            if(!map.containsKey(sorted[i])) {
                map.put(sorted[i], rank++);
            }
        }

        for(int key: arr) {
            System.out.print(map.get(key) + " ");
        }
    }
}
