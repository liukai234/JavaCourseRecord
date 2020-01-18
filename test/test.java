public class test {
    public static void main(String[] args) {
        System.out.println("\n");

        String str = "Hello World, Hello java";
        int lastIndex = str.lastIndexOf("Hello");
        int firstIndex = str.indexOf("Hello");
        System.out.println(firstIndex);
        if(lastIndex == -1) {
            System.out.print("not found\n");
        } else {
            System.out.println("found" + lastIndex);
        }
   }
}