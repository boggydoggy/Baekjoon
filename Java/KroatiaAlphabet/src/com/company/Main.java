/*
예를 들어, ljes=njak은 크로아티아 알파벳 6개(lj, e, š, nj, a, k)로 이루어져 있다. 단어가 주어졌을 때, 몇 개의 크로아티아 알파벳으로 이루어져 있는지 출력한다.

dž는 무조건 하나의 알파벳으로 쓰이고, d와 ž가 분리된 것으로 보지 않는다. lj와 nj도 마찬가지이다. 위 목록에 없는 알파벳은 한 글자씩 센다.

입력
첫째 줄에 최대 100글자의 단어가 주어진다. 알파벳 소문자와 '-', '='로만 이루어져 있다.

단어는 크로아티아 알파벳으로 이루어져 있다. 문제 설명의 표에 나와있는 알파벳은 변경된 형태로 입력된다.

출력
입력으로 주어진 단어가 몇 개의 크로아티아 알파벳으로 이루어져 있는지 출력한다.
 */

package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner((System.in));

        String text = sc.next();

        int counts = countAlphabets(text);

        System.out.println(counts);
    }

    public static int countAlphabets(String text) {
        int counts = 0;

        for(int i = 0; i < text.length(); i++) {
            if(i + 1 < text.length()) {
                switch (text.charAt(i)) {
                    case 'd':
                        if(text.charAt(i + 1) == 'z' && i + 2 < text.length()){
                            i = findDZAlphabets(text, i);
                        }
                    case 'c':
                    case 's':
                    case 'z':
                        i = findBarAlphabets(text, i);
                        break;
                    case 'l':
                    case 'n':
                        i = findJAlphabets(text, i);
                        break;
                }
            }
            counts += 1;
        }

        return counts;
    }

    public static int findBarAlphabets(String text, int index) {
        if(text.charAt(index + 1) == '-' || text.charAt(index + 1) == '=') {
            return index + 1;
        }
        else
            return index;
    }

    public static int findJAlphabets(String text, int index) {
        if(text.charAt(index + 1) == 'j') {
            return index + 1;
        }
        else
            return index;
    }

    public static int findDZAlphabets(String text, int index) {
        if(text.charAt(index + 2) == '=') {
            return index + 1;
        }
        else
            return index;
    }
}
