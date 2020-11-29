import java.io.File;
import java.util.Date;

public class modifyDate {
    public static void main(String[] args) throws Exception {
        File fileToChange = new File("/home/liukai/Desktop/jar");
        // file.length() 返回读取文件的大小
        System.out.println(fileToChange.length());
        fileToChange.createNewFile();
        Date filetime = new Date(fileToChange.lastModified());
        System.out.println(filetime.toString());
        System.out.println(fileToChange.setLastModified(System.currentTimeMillis()));
        filetime = new Date(fileToChange.lastModified());
        System.out.println(filetime.toString());
        fileToChange.renameTo(new File("/home/liukai/Desktop/testJar"));
        System.out.println(fileToChange.getName());
    }
}