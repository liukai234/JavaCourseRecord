import java.util.Arrays;

public class sortMain{
    public static void main(String[] args) throws Exception{
        int[] Array = {0, 1, 4, 9, -1};
        Arrays.sort(Array);
        printArray(Array);
    }
    private static void printArray(int[] array){
        for(int x : array) {
            System.out.println(x);
        }
    }
}