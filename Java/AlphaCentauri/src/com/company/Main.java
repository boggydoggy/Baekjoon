package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int loopCase = sc.nextInt();

        for(int i = 0; i < loopCase; i++) {
            int departure = sc.nextInt();
            int destination = sc.nextInt();

            System.out.println(calJump(departure, destination));
        }
    }

    public static int calJump(int x, int y) {
        int jump = 1;
        int count = 1;
        x += 1;

        while(x < (y - 1)) {
            if(x + (jump + 1) < y) {
                x += (jump + 1);
                jump += 1;
                count += 1;
            }
            else if(x + jump < y) {
                x += jump;
                count += 1;
            }
            else if(x + (jump - 1) < y) {
                x += (jump - 1);
                jump -= 1;
                count +=1 ;
            }
            else {
                x -= jump;
                jump -= 2;
                count -= 1;
            }
        }

        return count;
    }
}
