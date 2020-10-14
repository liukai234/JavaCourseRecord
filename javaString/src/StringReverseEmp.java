public class StringReverseEmp {
    public static void main(String[] args) {
        String str = "Hello World";
        // 借助StringBuffer进行逆序
        String reverse = new StringBuffer(str).reverse().toString();
        System.out.println(str + "\n" + reverse);
    }
}