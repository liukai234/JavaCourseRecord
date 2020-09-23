import java.io.*;
import java.util.Scanner;

public class Summary {
    public static void main(String[] args) throws IOException{
        // 字符输入输出
        String line;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        line = br.readLine();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(line);
    }
}
