/*
 * @Author: your name
 * @Date: 2020-04-12 10:02:03
 * @LastEditTime: 2020-04-12 10:09:44
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /EXAM/T6.java
 */
import java.util.*;
public class T6 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n;
        int a, b, c;
        int sum = 0;
        n = input.nextInt();
        a = input.nextInt();
        b = input.nextInt();
        c = input.nextInt();
        input.close();
        for(int i = 1; i <= n; i++) {
            if(i % a != 0 && i % b != 0 && i % c != 0) {
                ++ sum;
                // System.out.print(i + " ");
            }
        }
        System.out.print(sum);
    }
}