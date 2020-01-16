public class test {
    public static void main(String[] args) {
        String str = "Hello World";
        String anotherString = "hello world";
        Object object = str;

        System.out.println(str.compareTo(anotherString));
        System.out.println(str.compareToIgnoreCase(anotherString));
        System.out.println(str.compareTo(object.toString()));
    }
}