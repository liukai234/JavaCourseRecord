import java.util.HashMap;
import java.util.Map;

public class MapTest {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();

        MapOperation mapOperation = new MapOperation(map);

        mapOperation.put(1, "123");
        System.out.println(mapOperation.size());
        System.out.println(mapOperation.get(1));
    }
}
