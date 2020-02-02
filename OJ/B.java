import java.util.HashSet;
import java.util.Set;

// set集合去重
public class B {
    public static void main(String[] args) {
        String target = new String();
        Set<String> sub = new HashSet<String>();
        target = "01234567"; // 8
        for (int begin = 0; begin < target.length(); begin++) {
            for (int end = begin + 1; end < target.length() + 1; end++) {
                System.out.println(target.length()); // end < 8
                sub.add(target.substring(begin, end)); // end < 8 - 1
            }
        }
        System.out.println(sub.size());
    }
}