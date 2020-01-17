public class SearchString {
    public static void main(String[] args) {
        String strOrig = "Hello world, Hello java";
        int index = strOrig.indexOf("Hello");
        int lastIndex = strOrig.lastIndexOf("Hello");

        System.out.println(index);
        System.out.println(lastIndex);
    }
}