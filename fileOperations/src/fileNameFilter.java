import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.FilenameFilter;

// renameTo  类似 linux: mv
// mkdir

public class fileNameFilter {
    public static void main(String[] args) {
        File file1 = new File("src"); // src
        boolean isExist = file1.exists() && file1.isFile();
        System.out.println(file1.getAbsoluteFile() + ": " + isExist);
        String[] fileList;
        // fileList = file1.list(new MyFileNameFilter());

        // 匿名类
        fileList = file1.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.indexOf("test") != -1;
            }
        });

        for(String str : fileList) {
            System.out.println(str);
        }
    }
}

// Filter // 使用匿名类 Batter
class MyFileNameFilter implements FilenameFilter {

    @Override
    public boolean accept(File dir, String name) {
        // 找到索引的第一个位置
        return name.indexOf("test") != -1;
    }
}