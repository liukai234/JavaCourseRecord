import java.util.StringTokenizer;

public class StringSplitEmp {
    public static void main(String[] args) {
        String str = "www.hello.com";
        // 不带第二个参数默认使用空格分割，第二个字符串参数来指明分割符号，如果是点需要进行转义\\.,第三个参数为true表示分隔符也返回
        StringTokenizer st = new StringTokenizer(str, "l");
        System.out.println("通过l分割");

        String[] temp = new String[st.countTokens()]; // st.countTokens统计可以调用nextTokens的个数
        int i = 0;
        while(st.hasMoreElements()){
            temp[i] = st.nextElement().toString();
            i = i + 1;
        }

        // temp = str.split("l"); // str.split对于连续的分隔符会产生空字符串
        for (int j = 0; j < temp.length; j++) {
            System.out.print(temp[j] + "|");
        }

        // 大小写转换 str.toUpperCase() toLowerCase()
        // str.substring() // 求子串
    }
}