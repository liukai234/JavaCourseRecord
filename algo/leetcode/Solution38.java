public class Solution38{ 
    String ostr = "1";
    String str = new String();
    public String countAndSay(int n) {
        if(n > 1) {
            n --;
            str =  countAndSay(n);
        }


        if(n == 1) {
            str += "1"; // 产生第一代
            return str;
        }


        int count = 1;
        for(int i = 0; i < str.length(); i++) {
            if(i + 1 < str.length() && str.charAt(i) == str.charAt(i + 1)) {
                count ++;

            } else {
                str += Integer.toString(count); // 将int型的count转换为String
                if(count == 1) str += str.charAt(i);
                else str += str.charAt(i - 1);
                count = 1;
            }
        }
        return str;
    }
}