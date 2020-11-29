/*
 * @Author: your name
 * @Date: 2020-04-12 10:11:42
 * @LastEditTime: 2020-04-12 16:19:34
 * @LastEditors: Please set LastEditors
 * @Description: // 旋转矩阵
 * @FilePath: /EXAM/T7.java
 */

import java.util.*;

public class T7 {
    static int n, m;
    static int nlen, mlen;
    static int num = 0;
    static int[][] M;
    static int r, c;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        n = input.nextInt();
        m = input.nextInt();
        nlen = n - 1; mlen = m;
        M = new int[n][m];
        r = input.nextInt() - 1;
        c = input.nextInt() - 1;
        input.close();
        div(0, 0, 1);
        /* for(int i = 0; i < n ;i ++) {
            for(int j = 0; j < m; j ++) {
                System.out.print(M[i][j] + " ");
            }
            System.out.println();
        } */
        System.out.print(num);
    }
    static void div(int x, int y, int dir) {
        if(M[x][y] != 0) return;
        switch (dir) {
            case 1:
            for(int i = y, j = 0; j < mlen; i ++, j++) {
                M[x][i] = ++num;
                if(r == x && c == i) return;
            }
            mlen --;
            /* if(x == 0 && y == 0) div(x + 1, y + mlen, 2);
            else div(x + 1, y + mlen + 1, 2); */
            div(x + 1, y + mlen, 2);
            break;
            case 2:
            for(int i = x, j = 0; j < nlen; i ++, j++) {
                M[i][y] = ++num;
                if(r == i && c == y) return;
            }
            nlen --;
            div(x + nlen, y - 1, 3);
            break;
            case 3:
            for(int i = y, j = 0; j < mlen; i --, j++) {
                M[x][i] = ++num;
                if(r == x && c == i) return;
            }
            mlen --;
            div(x - 1, y - mlen, 4);
            break;
            case 4:
            for(int i = x, j = 0; j < nlen; i--, j++) {
                M[i][y] = ++num;
                if(r == i && c == y) return;
            }
            nlen --;
            div(x - nlen, y + 1, 1);
            break;
        }

    }

}