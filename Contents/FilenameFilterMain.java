import java.io.*;
 
class FilenameFilterMain {
   public static void main(String[] args) {
      File dir = new File("/home/liukai/Desktop");
      FilenameFilter filter = new FilenameFilter() {
         public boolean accept
         (File dir, String name) {
            return name.endsWith(".desktop");
            // return name.startWith("j");
        }
      };
      String[] children = dir.list(filter);
      if (children == null) {
         System.out.println("目录不存在或它不是一个目录");
      } 
      else {
         for (int i=0; i < children.length; i++) {
            String filename = children[i];
            System.out.println(filename);
         }
      } 
   }
}