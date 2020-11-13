import java.io.*;

// File.exists()
// File.isFile()
// File.compareTo() 路径比较
// File.getAbsoluteFile() 获得绝对路径

public class FileStreamOperator {
    public static void main(String[] args) throws IOException{

        // 文件字节流
        BufferedReader in = new BufferedReader(new FileReader("text.txt"));
        BufferedWriter out = new BufferedWriter(new FileWriter("text2.txt"));

        // 指明路径时使用windows下的\\路径分隔符或Linux下的/都可以  src/text.txt 或 src\\text.txt
        // File file1 = new File("text.txt");
        // boolean isExist = file1.exists() && file1.isFile();
        // System.out.println(file1.getAbsoluteFile() + ": " + isExist);

        StringBuffer sb = new StringBuffer();
        while(in.ready()) {
            sb.append(in.readLine());
        }
        System.out.println(sb);
        in.close();

        out.write(String.valueOf(sb));
        out.flush();
    }

}
                //对文件内容操作
//                List<String> results = new ArrayList<>();
//                int index = 0;
//                int num = 18;
//                System.out.println("将文件内容存入到数组中");
//                for (int i = 0; i < result.length()/num; i++) {
//                    results.add(result.substring(index, index + num));
//                    index = index + num;
//                    System.out.println("索引： " + index);
//                }
//                System.out.println(results);


