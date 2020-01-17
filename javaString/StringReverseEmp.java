public class StringReverseEmp {
    public static void main(String[] args) {
        String str = "Hello World";
        String reverse = new StringBuffer(str).reverse().toString();
        System.out.println(str + "\n" + reverse);
    }
}