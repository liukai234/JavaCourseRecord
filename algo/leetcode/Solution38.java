import java.util.Scanner;

public class Solution38{ 
    String ostr = "1";
    String str = new String();
    public String countAndSay(int n) {
        if(n > 1) {
            n --;
            str =  countAndSay(n);
        }
        if(n == 1) str += "1"; // 产生第一代
        int count = 1;
        for(int i = 0; i < str.length(); i++) {
            int tmp = i;
            if(i + 1 < str.length() && ostr.charAt(i) == ostr.charAt(i + 1)) {
                count ++;

            } else {
                count = 1;
                str += ();
                str += ostr.charAt(i);
            }
        }       
        return str;
    }
}