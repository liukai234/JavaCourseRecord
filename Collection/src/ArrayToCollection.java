import java.util.*;

public class ArrayToCollection{
    public static void main(String[] args){

        int n = 5;
        String[] intString = new String[n];
        for(int i = 0; i < n; i++){
            intString[i] = String.valueOf(i);
        }

        // 将数组化为列表
        List<String> list = Arrays.asList(intString);

        for(String li: list){
            System.out.print(li + " ");
        }
    }
}