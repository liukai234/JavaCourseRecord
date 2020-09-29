import java.io.*;

/**
 * Example10_1
 */
public class Example10_1 {

    public static void main(String[] args) throws IOException {
        
        File f = new File("/home/lk234/javaCourseRecord/lib/file", "Example10_1.java");
        System.out.println(f.getName() + " f.canRead() " + f.canRead());
        System.out.println(f.getName() + " f.length() " + f.length());
        System.out.println(f.getName() + " f.getAbsolutePath() " + f.getAbsolutePath());

        FileExp file = new FileExp("new.txt");

        try{
            file.createNewFile();
        } catch(FileException e) {
            System.out.println(e.getMessage());
        }

    }
}

class FileException extends IOException {

    private static final long serialVersionUID = 1L;
    public void createNewFile() throws java.io.IOException {
        throw new FileException();
    }
    public FileException() {

    }
    public String getMessage() {
        return "FileException";
    }
}

class FileExp extends File {

    public FileExp(File parent, String child) {
        super(parent, child);
        // 父类实现
    }

    public FileExp(String parent) {
        super(parent);
    }

    public boolean createNewFile() throws java.io.IOException {
        
        throw new FileException();
    }

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    
}