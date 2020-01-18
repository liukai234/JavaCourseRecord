import java.io.File;

public class filePathCompare {
    public static void main(String[] args) {
        File file1 = new File("/home/Desktop/java/fileOperations/test.txt");
        File file2 = new File("/home/Desktop/java/fileOperations/test.txt");
        if(file1.compareTo(file2) == 0) {
            System.out.println("路径相同");
        }
        else {
            System.out.println("路径不相同");
        }
    }
}