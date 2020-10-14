package src;

import java.io.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Summary {

    public static void main(String[] args) throws IOException{ // 对于BufferedWriter方法需要异常抛出
        // 字符输入输出
        String line;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        line = br.readLine();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(line);
        bw.newLine(); // 对BufferedWirter实例化对象新起一行
        bw.flush(); // 只有用了flush才会将BufferedWriter的对象内容写到目标上

    }

    static void match(String str) {
        Pattern p = Pattern.compile("[^aeiou]+[aeiou]+[^aeiou]+[aeiou]+");
        Matcher m = p.matcher(str);
        boolean success = m.matches();
        if(success) {
            System.out.println("Y");
        } else {
            System.out.println("N");
        }
    }
}
