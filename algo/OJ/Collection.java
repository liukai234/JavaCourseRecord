/*
 * @Author: your name
 * @Date: 2020-04-05 09:27:36
 * @LastEditTime: 2020-04-11 18:57:33
 * @LastEditors: Please set LastEditors
 * @Description: java集合
 * @FilePath: /java/test.java
 */
import java.util.*;

public class Collection {
    public static void main(String[] main) {
        Scanner input = new Scanner(System.in);
        input.close();
        Set<String> set = new HashSet<String>(); // 哈希集合
        Queue<String> queue = new LinkedList<String>(); // 队列
        Stack<String> stack = new Stack<String>(); // 栈
        List<String> lst = new LinkedList<String>(); // 链表
    }
}