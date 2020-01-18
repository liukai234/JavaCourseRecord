import java.io.*;

public class getFileMain {
    public static void main(String[] args) {
        try {
            BufferedReader in = new BufferedReader(new FileReader("test.txt"));
            StringBuffer sb;
            while(in.ready()) {
                sb = new StringBuffer(in.readLine());
                System.out.println(sb);
            }
            in.close();
        } catch (IOException e) {

        }
    }
}