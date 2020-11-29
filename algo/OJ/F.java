/*
 * @Author: your name
 * @Date: 2020-04-11 14:52:23
 * @LastEditTime: 2020-04-11 14:58:35
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /java/OJ/F.java
 */

import java.util.Scanner;
// 小明对数位中含有 2、0、1、9 的数字很感兴趣（不包括前导 0），
// 在 1 到 40 中这样的数包括 1、2、9、10 至 32、39 和 40，共 28 个，他们的和是 574

public class F {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.close();
        int num;
        int sum = 0;
        for(num = 1; num <= n; num ++){
            if((num +  "").indexOf("2") != -1 || (num +  "").indexOf("0") != -1 || (num +  "").indexOf("1") != -1
            || (num +  "").indexOf("9") != -1) {
                sum += num;
            }
        }
        System.out.println(sum);
    }
}