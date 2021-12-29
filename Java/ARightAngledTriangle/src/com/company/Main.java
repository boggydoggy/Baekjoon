/*
문제
과거 이집트인들은 각 변들의 길이가 3, 4, 5인 삼각형이 직각 삼각형인것을 알아냈다. 주어진 세변의 길이로 삼각형이 직각인지 아닌지 구분하시오.

입력
입력은 여러개의 테스트케이스로 주어지며 마지막줄에는 0 0 0이 입력된다. 각 테스트케이스는 모두 30,000보다 작은 양의 정수로 주어지며, 각 입력은 변의 길이를 의미한다.

출력
각 입력에 대해 직각 삼각형이 맞다면 "right", 아니라면 "wrong"을 출력한다.
 */

package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);

        int[] points = new int[3];

        for(int i = 0; i < 3; i++) {
            points[i] = Integer.parseInt(st.nextToken());
        }

        while(points[0] > 0 && points[1] > 0 && points[2] > 0) {
            if(checkRightAngled(points[0], points[1], points[2])) {
                System.out.println("right");
            }
            else {
                System.out.println("wrong");
            }

            s = br.readLine();
            st = new StringTokenizer(s);
            for(int i = 0; i < 3; i++) {
                points[i] = Integer.parseInt(st.nextToken());
            }
        }
    }

    public static boolean checkRightAngled(int f, int s, int t) {
        int[] maxList = {f, s, t};
        int temp;

        for(int i = 0; i < 2; i++) {
            for(int j = i + 1; j < 3; j++) {
                if(maxList[i] < maxList[j]) {
                    temp = maxList[i];
                    maxList[i] = maxList[j];
                    maxList[j] = temp;
                }
            }
        }

        return Math.pow(maxList[0], 2) == (Math.pow(maxList[1], 2) + Math.pow(maxList[2], 2));
    }
}
