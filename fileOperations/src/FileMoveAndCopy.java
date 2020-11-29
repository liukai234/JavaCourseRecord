import java.io.*;
import java.util.StringTokenizer;

public class FileMoveAndCopy {
    public static void main(String[] args) throws IOException {
        FileMoveAndCopy fileOper = new FileMoveAndCopy();
        fileOper.move("text3.txt", "text4.txt");
    }

    public void move(String src, String dis) throws IOException{
        File fileSrc = new File(src);
        copy(src, dis);
        fileSrc.delete();
    }

    public void copy(String src, String dis) throws IOException {
        boolean isSameFolder = false;
        File fileSrc = new File(src);
        File fileDis = new File(dis);

        if(fileSrc.isDirectory() || fileDis.isDirectory()) {
            System.out.println("is Folder");
            return;
        }

        String srcAbsolutePath = fileSrc.getAbsolutePath();
        String disAbsolutePath = fileDis.getAbsolutePath();

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

         if(isSameFolder) {
             fileSrc.renameTo(fileDis);
         }
         else {
             DataInputStream in = new DataInputStream(new FileInputStream(fileSrc));
             DataOutputStream out = new DataOutputStream(new FileOutputStream(fileDis));

             out.writeUTF(in.readUTF());

         }
    }
}

