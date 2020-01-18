import java.util.LinkedList;

public class LinkedListMain {
    public static void main(String[] args) {
        LinkedList<String> lList = new LinkedList<String>();
        lList.add("1");
        lList.add("2");
        lList.add("3");
        lList.add("4");
        lList.add("5");
        lList.add("6");
        System.out.println(lList);
        lList.addFirst("0");
        System.out.println(lList);
        lList.addLast("7");
        System.out.println(lList);
        System.out.println(lList.getFirst());
        System.out.println(lList.getLast());
        lList.subList(2, 4).clear();
        System.out.println(lList);
        // 获取链表元素时把addFirst getFirst removeFirst 等封装起来当做队列
        lList.set(2, "AA");
        System.out.println(lList);
    }
}