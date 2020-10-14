import java.util.*;

public class ArrayToCollection{
    public static void main(String[] args){
        // Integer Double 等包装类使用intValue() doubleValue()来获得值
        // Java拥有自动装箱自动拆箱机制，自动拆箱：int m = list.get(k) // 返回Integer对象
        // 自动转换为基本对象类型
        int n = 5;
        int j = 0;
        String[] intString = new String[n];
        for(int i = n - 1; i >= 0; i--){
            intString[j] = String.valueOf(i);
            j += 1;
        }
        Arrays.sort(intString);

        List list = CollectionsOperation.arraysToLinkedList(intString);

        // ListIterator liter = list.listIterator(); // list专用遍历器ListIterator 参数为list.size()时链表可以逆序
        // liter.next();
        // System.out.print("liter" + liter.nextIndex() + "\n");  // 查看当前指针的位置

        CollectionsOperation clist= new CollectionsOperation(list);

        clist.CollectionsTestOperation();
        System.out.print(clist);

        Stack<String> stack = new Stack<>();
        StackStrOperation stackStrOperation = new StackStrOperation(stack);
        for(Object str : list) {
            stackStrOperation.push(str.toString());
        }

        System.out.println();
        while(!stackStrOperation.empty()) {
            System.out.println(stackStrOperation.peek());
            stackStrOperation.pop();
        }
    }
}

// JNI 调用其他语言