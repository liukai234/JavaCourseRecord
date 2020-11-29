import java.io.*;

public class BinFile {
    public static void main(String[] args) throws IOException {
        writeBinFile("text.txt");
        readBinFile("text.txt");
    }

    public static void writeBinFile(String filename) throws IOException {
        int val0 = 255;
        int val1 = 0;
        DataOutputStream out = new DataOutputStream(new FileOutputStream(filename));
        out.writeInt(val0);
        out.writeInt(val1);
        out.close();
    }

    public static void readBinFile(String filename) throws IOException {
        DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(filename)));

        // 当读取速度不同步时可以选择加一个buff来缓冲
        // DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(filename)));

        System.out.println(in.readInt());
        System.out.println(in.readInt());
    }
}

