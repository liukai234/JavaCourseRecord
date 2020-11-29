/*
 * @Author: your name
 * @Date: 2020-04-11 14:56:22
 * @LastEditTime: 2020-04-11 14:56:23
 * @LastEditors: your name
 * @Description: In User Settings Edit
 * @FilePath: /OJ/A.java
 */

import java.util.*;

public class A {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[][] team = new int[20][5];
        for(int i = 0; i < 20; i++) {
            for(int j = 0; j < 5; j ++){
                team[i][j] = input.nextInt();
            }
        }
        /* for(int i = 0; i < 20; i++) {
            for(int j = 0; j < 5; j ++){
                System.out.print(team[i][j] + " ");
            }
            System.out.println();
        } */
        int max = 0;
        for(int ready1 = 0; ready1 < 20; ready1 ++){
            for(int ready2 = 0; ready2 < 20; ready2 ++){
                for(int ready3 = 0; ready3 < 20; ready3 ++){
                    for(int ready4 = 0; ready4 < 20; ready4 ++){
                        for(int ready5 = 0; ready5 < 20; ready5 ++){
                            if((ready5 != ready4 && ready5 != ready3 && ready5 != ready2 && ready5 != ready1) && 
                                (ready4 != ready3 && ready4 != ready2 && ready4 != ready1) &&
                                (ready3 != ready2 && ready3 != ready1) &&
                                (ready2 != ready1)) {
                                    if(max < team[ready1][0] + team[ready2][1] + team[ready3][2] + team[ready4][3] + team[ready5][4]){
                                        max = team[ready1][0] + team[ready2][1] + team[ready3][2] + team[ready4][3] + team[ready5][4];
                                        /* System.out.println(team[ready1][0]);
                                        System.out.println(team[ready2][1]);
                                        System.out.println(team[ready3][2]);
                                        System.out.println(team[ready4][3]);
                                        System.out.println(team[ready5][4]);
                                        System.out.println(); */
                                        
                                    }

                                }
                        }
                    }
                }
            }
        }

        System.out.println(max);

        input.close();
    }
}
