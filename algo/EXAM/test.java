/*
 * @Author: your name
 * @Date: 2020-04-11 18:54:54
 * @LastEditTime: 2020-04-12 16:16:12
 * @LastEditors: Please set LastEditors
 * @Description: 2020蓝桥杯JavaB组测试文件
 * @FilePath: /EXAM/test.java
 */
import java.util.*;
/*
JAVA主类名称：如果你使用Java语言，对于所有的试题，你的主类名称都必须是Main。
注意：java 语言中不要使用package语句，代码要求符合JDK1.6的语法规范。
*/
public class test {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        input.close();
        // Set<String> hset = new HashSet<String>();
        List<String> lst = new LinkedList<String>();
        lst.add("123");
        lst.add("456");
        for(int i = 0; i < lst.size(); i++) {
            System.out.println(lst.get(i));
        }
        for(String str : lst) {
            System.out.println(str);
        } 
        Iterator<String> ite = lst.iterator();
        while(ite.hasNext()) {
            System.out.println(ite.next());
        }
        System.out.println("end");
    }
}