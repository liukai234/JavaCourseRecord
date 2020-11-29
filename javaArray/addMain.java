import java.util.Arrays;

public class addMain {
    public static void main(String[] args) throws Exception {
       int[] array = {0, 2, 5, 13};
       Arrays.sort(array);
       for(int x : array){
           System.out.print(x + " ");
       } 
       System.out.print("\n");
       int index = Arrays.binarySearch(array, 1);
       System.out.println(index);
       index = -index - 1;
       System.out.println(index);
       int[] newArray = insertElement(array, 1, index);
       for(int x:newArray){
           System.out.print(x + " ");
       }
       System.out.print("\n");
    //    int newIndex = - index - 1;
    }
    private static int[] insertElement(int original[], int element, int index){
        int length = original.length;
        int[] destination = new int[length + 1];
        System.arraycopy(original, 0, destination, 0, index);
        destination[index] = element;
        System.arraycopy(original, index, destination, index + 1, length - index);
        return destination;
    }
}