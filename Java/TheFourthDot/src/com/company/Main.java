/*
문제
세 점이 주어졌을 때, 축에 평행한 직사각형을 만들기 위해서 필요한 네 번째 점을 찾는 프로그램을 작성하시오.

입력
세 점의 좌표가 한 줄에 하나씩 주어진다. 좌표는 1보다 크거나 같고, 1000보다 작거나 같은 정수이다.

출력
직사각형의 네 번째 점의 좌표를 출력한다.
 */

package com.company;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] xPoint = new int[4];
        int[] yPoint = new int[4];

        for(int i = 0; i < 3; i++) {
            xPoint[i] = sc.nextInt();
            yPoint[i] = sc.nextInt();
        }
        xPoint[3] = findFourthXPoint(xPoint);
        yPoint[3] = findFourthYPoint(yPoint);

        System.out.println(xPoint[3] + " " + yPoint[3]);

    }
    public static int findFourthXPoint(int[] xPoint) {
        HashMap<Integer, Integer> count = new HashMap<>();

        for(int i = 0; i < 3; i++) {
            if(count.containsKey(xPoint[i])) {
                count.put(xPoint[i], count.get(xPoint[i]) + 1);
            }
            else {
                count.put(xPoint[i], 1);
            }
        }

        for(Integer point: count.keySet()) {
            if(count.get(point) == 1) {
                return point;
            }
        }

        return 0;
    }

    public static int findFourthYPoint(int[] yPoint) {
        HashMap<Integer, Integer> count = new HashMap<>();

        for(int i = 0; i < 3; i++) {
            if(count.containsKey(yPoint[i])) {
                count.put(yPoint[i], count.get(yPoint[i]) + 1);
            }
            else {
                count.put(yPoint[i], 1);
            }
        }

        for(Integer point: count.keySet()) {
            if(count.get(point) == 1) {
                return point;
            }
        }

        return 0;
    }
}
