import java.io.*;
public class FileFilterMain {
    public static void main(String[] args) {
        File dir = new File("/home/liukai/Desktop");
        // File[] files = dir.listFiles();
        FileFilter fileFilter = new FileFilter() {
            public boolean accept(File file) {
                return file.isDirectory();
            }
        };
        File[] files = dir.listFiles(fileFilter);
        System.out.println(files.length);
        if(files.length == 0) {
            System.out.println("目录不存在或不是目录");
        } else {
            for(int i = 0; i < files.length; i++) {
                File filename = files[i];
                System.out.println(filename.toString());
            }
        }
    }
}