import java.io.*;
import java.util.StringTokenizer;

public class FileMoveAndCopy {
    private File src;
    private File tar;

    public static void main(String[] args) throws IOException {
        File file1 = new File("text1.txt");
        File file2 = new File("text2.txt");
        FileMoveAndCopy fileOper = new FileMoveAndCopy(file1, file2);
        fileOper.copy();
    }

    public FileMoveAndCopy(File src, File tar) {
        this.src = src;
        this.tar = tar;
    }

    private boolean isSameFolder() {
        boolean isSameFolder = false;

        if(src.isDirectory() || tar.isDirectory()) {
            System.out.println("is Folder");
            return false;
        }

        String srcAbsolutePath = src.getAbsolutePath();
        String disAbsolutePath = tar.getAbsolutePath();

        StringTokenizer srcSt = new StringTokenizer(srcAbsolutePath, ":\\", false);
        StringTokenizer disSt = new StringTokenizer(disAbsolutePath, ":\\", false);

        if(srcSt.countTokens() != disSt.countTokens()) { /* 不在同一文件夹中 */ isSameFolder = false; }
        else {
            while (srcSt.hasMoreElements() && disSt.hasMoreElements()) {
                if (srcSt.nextElement().equals(disSt.nextElement())) {
                    isSameFolder = true;
                } else {
                    if (srcSt.countTokens() == 0 && disSt.countTokens() == 0) { /* 在同一文件夹中 */
                        isSameFolder = true;
                        break;
                    } else {
                        isSameFolder = false;
                    }
                }
            }
        }
        return isSameFolder;
    }

    public void move(){
        if(isSameFolder()) {
            src.renameTo(tar);
        }else {
            copy();
        }
        src.delete();
    }

    public void copy(){
        DataInputStream in = null;
        try {
            in = new DataInputStream(new FileInputStream(src));
            DataOutputStream out = new DataOutputStream(new FileOutputStream(tar));
            out.write(in.readAllBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}

