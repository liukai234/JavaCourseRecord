import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BufferBuilder {

    public static void main(String[] args) throws IOException{ // 对于BufferedWriter方法需要异常抛出
        // 字符输入输出
        String line;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        line = "---";// br.readLine();

        // Scanner input = new Scanner(System.in);
        // line = input.nextLine();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(line);
        bw.newLine(); // 对BufferedWriter实例化对象新起一行
        bw.flush(); // 只有用了flush才会将BufferedWriter的对象内容写到目标上

        System.out.println(match("cece"));
    }

    // 正则表达式 模式匹配
    public static boolean match(String str) {
        // ^表示不为此指定的字符, +表示匹配一个或多个
        Pattern p = Pattern.compile("[^aeiou]+[aeiou]+[^aeiou]+[aeiou]+");
        Matcher m = p.matcher(str);
        return m.matches();
    }
}
