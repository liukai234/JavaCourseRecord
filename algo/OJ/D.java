/*
 * @Author: your name
 * @Date: 2020-04-11 14:52:00
 * @LastEditTime: 2020-04-11 14:56:50
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /java/OJ/D.java
 */

public class D {
    public static void main(String[] args) {
        int k;
        int sum = 0;
        int sum1 = 0;
        for (int i = 1; i < 2019; i++) {
            // System.out.println("i = " + i);
            for (int j = 1; j < 2019; j++) {
                // System.out.println("j = " + j);
                k = 2019 - i - j;
                // System.out.println("k = " + k);
                if (k < 1){
                    continue;
                }
                if (include(i) && include(j) && include(k)) {
                    if (i == j || i == k || j == k) {
                        continue;
                    } else {
                        sum++;
                    }
                }
            }
        }
        System.out.println("sum = " + sum);
        System.out.println("sum1 = " + sum1);
        System.out.println("(sum + sum1) / 6 = " + ((sum + sum1) / 6));
        /* for(i = 0 ; i < 100; i++) {
            if(include(i)) {
                System.out.println(i);
            }
        } */
    }

    // not include return true
    static boolean include(int num) {
        if (num / 1000 == 2) {
            return false;
        } else {
            num %= 1000;
            if ((num / 100) == 2 || (num / 100) == 4) {
                return false;
            } else {
                num %= 100;
                if ((num / 10) == 2 || (num / 10) == 4) {
                    return false;
                } else {
                    num %= 10;
                    if (num == 2 || num == 4) {
                        return false;
                    } else {
                        return true;
                    }
                }
            }
        }
    }
}