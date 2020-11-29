import java.util.Arrays;

public class fillArray {
    public static void main(String[] args) {
        int[] array = new int[6];
        Arrays.fill(array, 100);
        for(int x : array)
        System.out.println(x);
        Arrays.fill(array, 0, 2, 333);
        System.out.println("-----------------");
        for(int x : array)
        System.out.println(x);
    }
}