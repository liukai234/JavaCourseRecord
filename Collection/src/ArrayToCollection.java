import java.lang.reflect.Array;
import java.util.*;
import java.io.*;
 
public class ArrayToCollection{
   public static void main(String args[]) throws IOException{
      int n = 5;         // 5 个元素
      String[] name = new String[n];
      for(int i = 0; i < n; i++){
         name[i] = String.valueOf(i);
      }

      // 将数组化为列表
      List<String> list = Arrays.asList(name);

      System.out.println();
      for(String li: list){
         String str = li;
         System.out.print(str + " ");
      }

   }
}