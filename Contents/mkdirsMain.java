import java.io.File;
public class mkdirsMain {
    public static void main(String[] args) {
        String filePath = "/home/liukai/Desktop/a/b/c/d/e/f/g";
        File file = new File(filePath);
        file.mkdirs();
        String fileDel = "/home/liukai/Desktop/a";
        deleteDirs(new File(fileDel));
    }
    public static boolean deleteDirs(File dir) {
        if(dir.isDirectory()) {
            String[] children = dir.list();
            for(int i = 0; i < children.length; i++) {
                boolean success = deleteDirs(new File(dir, children[i]));
                if(!success) {
                    return false;
                }
            }
        }
        if(dir.delete()) {
            System.out.println("has deleted");
            return true;
        }
        else {
            System.out.println("not success");
            return false;
        }
    }
}