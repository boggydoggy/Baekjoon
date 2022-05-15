/*
스도쿠는 18세기 스위스 수학자가 만든 '라틴 사각형'이랑 퍼즐에서 유래한 것으로 현재 많은 인기를 누리고 있다.
이 게임은 아래 그림과 같이 가로, 세로 각각 9개씩 총 81개의 작은 칸으로 이루어진 정사각형 판 위에서 이뤄지는데, 게임 시작 전 일부 칸에는 1부터 9까지의 숫자 중 하나가 쓰여 있다.

나머지 빈 칸을 채우는 방식은 다음과 같다.

각각의 가로줄과 세로줄에는 1부터 9까지의 숫자가 한 번씩만 나타나야 한다.
굵은 선으로 구분되어 있는 3x3 정사각형 안에도 1부터 9까지의 숫자가 한 번씩만 나타나야 한다.

게임 시작 전 스도쿠 판에 쓰여 있는 숫자들의 정보가 주어질 때 모든 빈 칸이 채워진 최종 모습을 출력하는 프로그램을 작성하시오.

입력
아홉 줄에 걸쳐 한 줄에 9개씩 게임 시작 전 스도쿠판 각 줄에 쓰여 있는 숫자가 한 칸씩 띄워서 차례로 주어진다. 스도쿠 판의 빈 칸의 경우에는 0이 주어진다.
스도쿠 판을 규칙대로 채울 수 없는 경우의 입력은 주어지지 않는다.

출력
모든 빈 칸이 채워진 스도쿠 판의 최종 모습을 아홉 줄에 걸쳐 한 줄에 9개씩 한 칸씩 띄워서 출력한다.

스도쿠 판을 채우는 방법이 여럿인 경우는 그 중 하나만을 출력한다.
 */

package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int[][] sudoku = new int[9][9];
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 9; j++) {
                sudoku[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);

    }

    public static void dfs(int row, int col) {
        //행이 다 채워졌을 경우
        if(col == 9) {
            dfs(row + 1, 0);
            return;
        }

        //스도쿠가 완성되었을 경우
        if(row == 9) {
            for(int i = 0; i < 9; i++) {
                for(int j = 0; j < 9; j++) {
                    sb.append(sudoku[i][j]).append(" ");
                }
                sb.append("\n");
            }
            System.out.println(sb);
            System.exit(0);
        }

        //해당 행과 열이 빈 칸인 경우
        if(sudoku[row][col] == 0) {
            for(int i = 1; i <= 9; i++) {
                if(findValue(row, col, i)) {
                    sudoku[row][col] = i;
                    dfs(row, col + 1);
                }
            }
            //만약 이전 빈 칸을 잘못 넣어서 현재 빈 칸에 답이 없는 경우
            sudoku[row][col] = 0;
            return;
        }

        dfs(row, col + 1);
    }

    public static boolean findValue(int row, int col, int value) {
        //같은 행에 숫자가 존재하는 경우
        for(int i = 0; i < 9; i++) {
            if(sudoku[row][i] == value) {
                return false;
            }
        }
        //같은 열에 숫자가 존재하는 경우
        for(int i = 0; i < 9; i++) {
            if(sudoku[i][col] == value) {
                return false;
            }
        }
        //3x3 안에 숫자가 존재하는 경우
        int s_row = (row / 3) * 3;
        int s_col = (col / 3) * 3;

        for(int i = s_row; i < s_row + 3; i++) {
            for(int j = s_col; j < s_col + 3; j++) {
                if(sudoku[i][j] == value) {
                    return false;
                }
            }
        }

        return true;
    }
}
