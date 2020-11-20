import java.util.*;

public class Main {
    public static void main(String[] args) {
        Student A = new Student("1");
        Student B = new Student("2");
        Student C = new Student("3");

        // Student Array
        Student[] students = {A, B ,C};
        for (Student student : students) { System.out.println(student.getName()); }

        // ArrayList查询快
        List<Student> arrayList = Arrays.asList(students);
        for (int i = 0; i < arrayList.size(); i ++) { System.out.println(arrayList.get(i).getName()); }

        // LinkedList 增删快
        List<Student> linkedList = new LinkedList<>();
        linkedList.add(A);
        linkedList.add(B);
        linkedList.add(C);
        Iterator<Student> iter = linkedList.listIterator();
        while(iter.hasNext()) { System.out.println(iter.next().getName()); }

        // Hash Set 索引
        Set<Student> hashSet = new HashSet<>();
        hashSet.add(A);
        hashSet.add(B);
        hashSet.add(C);
        Iterator<Student> iterSet = hashSet.iterator();
        while(iterSet.hasNext()) {System.out.println(iterSet.next().getName()); }
        System.out.println(hashSet.contains(A));

        // Hash Map 索引
        Map<Integer, Student> hashMap = new HashMap<>();
        hashMap.put(1, A);
        hashMap.put(2, B);
        hashMap.put(3, C);
        System.out.println(hashMap.containsKey(2));
        System.out.println(hashMap.get(1).getName());
    }
}


class Student {
    private String name = null;
    public Student(String name) { this.name = name; }
    public String getName() { return name; }
}