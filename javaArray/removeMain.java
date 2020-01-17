import java.util.ArrayList;

public class removeMain {
    public static void main(String[] args) {
        ArrayList<String> objArray = new ArrayList<String>();
        objArray.clear();
        objArray.add(0, "common1");
        objArray.add(1, "common2");
        objArray.add(2, "Notcommon3");
        // 两个集合的差集
        System.out.println(objArray);
        ArrayList<String> objArray2 = new ArrayList<String>();

        objArray2.clear();
        objArray2.add(0, "common1");
        objArray2.add(1, "common2");
        objArray2.add(2, "common3");
        objArray2.add(3, "common4");
        System.out.println(objArray2);

        objArray.retainAll(objArray2);
        System.out.println("数组交集" + objArray);
        System.out.println("是否包含" + objArray.contains("common1"));
        objArray.removeAll(objArray2);
        System.out.println("数组差集" + objArray);
    }
}