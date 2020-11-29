import java.util.*;
import java.lang.*;

public class outputMain{
    public static void main(String[] args) {
        ArrayList<String> test = new ArrayList<String>();
        test.add("1 ");
        test.add("2 ");
        test.add("3 ");
        for(Iterator<String> iterator = test.iterator(); iterator.hasNext(); System.out.println(iterator.next()));
    }
}