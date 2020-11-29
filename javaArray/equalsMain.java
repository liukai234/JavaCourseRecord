import java.util.Arrays;

public class equalsMain {
    public static void main(String[] args) {
        int[] ary = {1,2,3,4};
        int[] ary1 = {1,2,3,4};
        int[] ary2 = {1,2,3};
        System.out.println(Arrays.equals(ary, ary1));
        System.out.println(Arrays.equals(ary, ary2));
    }
}