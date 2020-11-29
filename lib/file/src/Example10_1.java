import java.io.*;

/**
 * src.Example10_1
 */
public class Example10_1 {
    public static void main(String[] args) throws IOException {
        FileExp file = new FileExp("test.txt"); // 当前目录
//        file.createNewFile();
//        System.out.println(file.getName() + " f.canRead() " + f.canRead());
//        System.out.println(file.getName() + " f.length() " + f.length());
        System.out.println(file.getName() + " f.getAbsolutePath() " + file.getAbsolutePath());

        try{
            boolean isExisted = file.createNewFile();
            if(!isExisted) System.out.println("boolean: 文件存在"); // 重载抛出的异常使isExisted没有更新
            System.out.println("文件创建正常");
        } catch(FileException e) {
            System.out.println(e.getMessage());
        }
    }
}

class FileException extends IOException {
    private static final long serialVersionUID = 1L;
    public FileException(String message) {
        super(message);
    }
}

class FileExp extends File {
    private static final long serialVersionUID = 1L;
    // public src.FileExp(File parent, String child) {
    //     super(parent, child);
    // }

    // @Override // Override语法糖重载不适用于构造器
    public FileExp(String pathname) {
        super(pathname);
    }

    @Override
    public boolean createNewFile() throws IOException { // 不用声明抛出异常的子异常
        if(super.exists()) throw new FileException("File is existed");
        return super.createNewFile();
    }
}