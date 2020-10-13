import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class CollectionsOperation {
    private String stringCache = "";
    List list = null;
    public CollectionsOperation(List list) {
        this.list = list;
    }

    public void CollectionsTestOperation() {
        // Collections的静态方法
        Collections.sort(list); // 默认升序
        Collections.reverse(list); // 逆序链表，或将升序链表转换为降序
        Collections.rotate(list, -1); // 旋转链表中的数据，正值时向右旋转，负值时向左旋转
        Collections.shuffle(list); // 根据洗牌算法重新排序
    }

    @Override
    public String toString() {
        for(Object str : list) {
            stringCache += str.toString() + " ";
        }
//        stringCache += "\n";
        return stringCache;
    }

    public static List arraysToLinkedList (String[] intString) {
        // Arrays.asList(T... a) return java.util.Arrays$ArrayList // 从数组得到顺序表
        List<String> array = Arrays.asList(intString); // 数组表使用顺序结构，适用于查改，但不适用增删

        List<String> list = new LinkedList<>(array); // LinkedList使用链式结构，适用于增删，但查询不如链表快

        // LinkedList和ArrayList都是由List继承而来
        // List<String> list = new LinkedList<>(array);
        // List<String> array = new ArrayList<>(list);

        return list;
    }
}
