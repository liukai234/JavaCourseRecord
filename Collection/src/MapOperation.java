import java.util.Map;

public class MapOperation {
    Map map = null;
    public MapOperation(Map map) {
        this.map = map;
    }

    public void clear() {
        map.clear();
    }
    public boolean containKey(Object key) { return map.containsKey(key); }
    public boolean containValue(Object value) { return map.containsValue(value); }
    public Object get(Object Key) { return map.get(Key); }
    public boolean isEmpty() { return map.isEmpty(); }
    public Object remove(Object key) { return map.remove(key); }
    public int size() { return map.size(); }
    public  void put(int key, String value) { map.put(key, value); }

}
