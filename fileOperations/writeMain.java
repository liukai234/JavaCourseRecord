import java.io.*;
public class writeMain {
    public static void main(String[] args) {
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("test.txt"));
            out.write("12306");
            out.close();
        } catch(IOException e) {
            
        }
    }
}
