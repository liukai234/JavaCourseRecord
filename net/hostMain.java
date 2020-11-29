import java.net.*;
import java.io.*;
 
public class hostMain {
   public static void main(String[] args) {
      Socket Skt;
      String host = "localhost";
      if (args.length > 0) {
         host = args[0];
      }
      for (int i = 0; i < 1024; i++) {
         try {
            System.out.println("查看 "+ i);
            Skt = new Socket(host, i); // 检查到端口未被使用即该端口的host为空 抛出异常IOException
            System.out.println("端口 " + i + " 已被使用");
         }
         catch (UnknownHostException e) {
            System.out.println("Exception occured"+ e);
            break;
         }
            catch (IOException e) {
         }
      }
   }
}