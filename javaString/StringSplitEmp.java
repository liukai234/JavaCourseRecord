import java.util.StringTokenizer;

public class StringSplitEmp {
    public static void main(String[] args) {

        String str = "Hello";
        String[] temp;
        
        String delimeter = "l";
        temp = str.split(delimeter);
        for (int i = 0; i < temp.length; i++) {
            System.out.println(temp[i]);
        }

        StringTokenizer sTok = new StringTokenizer(str, "l");
        while(sTok.hasMoreElements()){
            System.out.println(sTok.nextElement());
        }
        String str2 = "www.liukai.com";
        String delimeter2 = "\\.";
        // 对 . 进行转义　\\.
        temp = str2.split(delimeter2);
        for(String subStr : temp){
            System.out.println(subStr);
        }
    }
}