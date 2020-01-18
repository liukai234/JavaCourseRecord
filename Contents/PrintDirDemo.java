import java.io.File;
import java.util.Arrays;
import java.util.stream.Stream;

public class PrintDirDemo {
    public static void main(String[] args) {        
        printDir(1, new File("/home/liukai/Desktop/"));    
    }    
    /**     
    * 使用 java 8 lambda 表达式，打印目录结构
    * @param indent     
    * @param file     
    */    
    public static void printDir(int indent, File file) {        
        Stream.generate(() -> '-').limit(indent).forEach(System.out::print);//打印缩进字符"-"        
        System.out.println(file.getName());        
        if (file.isDirectory()) {            
            Arrays.asList(file.listFiles()).forEach(file2 -> printDir(indent + 2, file2));        
        }    
    }
}