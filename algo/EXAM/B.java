/*
 * @Author: your name
 * @Date: 2020-04-12 09:04:32
 * @LastEditTime: 2020-04-12 16:14:24
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /EXAM/B.java
 */

 // LANQIAO
import java.util.*;
 public class B {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        input.close();
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) >= 'a' && str.charAt(i) <= 'w'){
                System.out.print((char)(str.charAt(i) + 3));
            } else {
                System.out.print((char)(str.charAt(i) - 23));
            }
        }
    }
}