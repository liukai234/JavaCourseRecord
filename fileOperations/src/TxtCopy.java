import java.io.*;

public class TxtCopy {
    public static void copyStream(String inFilename, String outFilename) throws IOException {
        File inFile = new File(inFilename);
        FileInputStream ins = new FileInputStream(inFile);
        OutputStream os = new FileOutputStream(outFilename);
        byte[] buf = new byte[1024];
        long length = inFile.length();
        System.out.println(length);
        int bytesRead;
        int i = 1;
        while ((bytesRead = ins.read(buf)) != -1) {
            os.write(buf, 0, bytesRead);
            double num = (double)1024 * i / length;
            int num2 = (int) (num * 100);
            if(num2 >= 100) num2 = 100;
            System.out.println("buf: " + num2);
            i++;
        }
        ins.close();
        os.close();
    }

    public static void main(String[] args) throws IOException {
        copyStream("text1.txt", "text2.txt");
    }
}
