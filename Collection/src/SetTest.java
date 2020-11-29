import java.util.HashSet;
import java.util.Iterator;
import java.util.Queue;
import java.util.Set;

public class SetTest {
    public static void main(String[] args) {
        Set<String> set = new HashSet();

        set.add("123");
        set.add(Integer.toString(12));
        set.add(Integer.toString(12));

        Iterator<String> iter = set.iterator();

        while (iter.hasNext()) {
            Object str = iter.next();
            System.out.println(str.toString());
            System.out.println();
        }
    }


}
