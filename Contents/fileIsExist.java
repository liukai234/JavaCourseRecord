import java.io.File;

public class fileIsExist {
    public static void main(String[] args) {
        String filePath = "/home/liukai/Desktop/testMain";
        File file = new File(filePath);
        if(file.isDirectory()) {
            if(file.list().length > 0) {
                System.out.println("当前目录不为空");
            } else {
                System.out.println("当前目录为空");
            }
        } else {
            System.out.println("not a 目录");
        }
    }
}