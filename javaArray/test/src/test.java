public class test {
    public static void main(String[] args) {
        String[] str = new String[3];
        str[0] = "1";
        str[1] = "2";
        str[2] = "3";
        String[] str2 = new String[3];
        System.arraycopy(str, 0, str2, 0, 3); // 数组复制
        for(String s : str2) {
            System.out.println(s);
        }
        System.out.println();

        for(int i = 0; i < str.length; i ++) {
            str2[i] = str[i];
        }

        for(String s : str2) {
            System.out.println(s);
        }
    }
}
