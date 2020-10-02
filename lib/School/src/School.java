import java.util.Iterator;
import java.util.LinkedList;

public class School{
    public static void main(String[] args) {
        Class class1 = new Class(1);
        class1.addTeacher("class1's Teacher1");
        class1.addTeacher("class1's Teacher2");
        class1.printAllTeacher();
//        Teacher t = class1.getTeacher("class1's Teacher1");
//        t.printInfo();
        class1.removeTeacher("class1's Teacher1");
        class1.printAllTeacher();
        class1.removeTeacher("class1's Teacher1");
        class1.changeTeacher("class1's Teacher2", "class1's Teacher3");
        class1.printAllTeacher();

//        Teacher t = new Teacher("zhaoliu", 20030826);
//        Student s1 = new Student("zhangsan", 1707000101, t);
//        s1.printInfo();
//        Student s2 = new Student("lisi", 1707000102, t);
//        s2.printInfo();
//        Student s3 = new Student("wangwu", 1707000103, t);
//        s3.printInfo();
//
//        GrandeStudent gs = new GrandeStudent("gs", 1907000104, t, "article");
//        System.out.println();
//        System.out.println("Name: " + gs.getName() + " ID:" + gs.getID());
//        gs.printArticle();
//        System.out.println();
//
//        s3.printInfo();
        
    }
}

class Class {
    private int num; // 班级号
    LinkedList<Teacher> teachers = new LinkedList<>();
    public Class(int num) {
        this.num = num;
    }
    public void addStudent() {

    }

    // 增
    public void addTeacher(String name) {
        Teacher teacher = new Teacher(name);
        teachers.add(teacher);
    }

    // 删
    public void removeTeacher(String name) {
        // 新建的对象一定与原对象不同
        Teacher teacher = new Teacher(name);
//        if(teachers.contains(teacher)) {
//            teachers.remove(teacher);
//        } else {
//            System.out.println(name + "不存在");
//        }
        Iterator<Teacher> iter = teachers.iterator();
        while(iter.hasNext()) {
            if(iter.next().getTeacherName().equals(name)){
                iter.remove();
                return;
            }
        }
    }

    // 改
    public void changeTeacher(String originName, String newName) {
        Iterator<Teacher> iter = teachers.iterator();
        while(iter.hasNext()) {
            Teacher temp = iter.next(); // iter每次访问.next()时会指向下一个结点
            if(temp.getTeacherName().equals(originName)){
                temp.setTeacherName(newName);
            }
        }

    }

    // 查
    public Teacher getTeacher(String name) {
        Teacher teacher = new Teacher(name);
        Iterator<Teacher> iter = teachers.iterator();
        while(iter.hasNext()) {
            if(iter.next().getTeacherName().equals(name)){
                return iter.next();
            }
        }
        return null;
    }


    public void printAllTeacher() {
        Iterator<Teacher> iter = teachers.iterator();
        System.out.println("printAllTeachers:");
        while(iter.hasNext()) {
            System.out.println(iter.next().getTeacherName());
        }
        System.out.println(this.num + "班共有老师" + teachers.size() + "名");
    }

    public void addCourse() {

    }


}

class Teacher {
    private String name;
    public Teacher(String name){
        this.name = name;
    }
    public void setTeacherName(String name) { this.name = name; }
    public String getTeacherName(){
        return name;
    }
    public void printInfo() { System.out.println("Teacher Name: " + name + "; "); }
}

class Student {
    protected String name;
    protected int ID;
    Teacher tutor;
    public Student(String name, int ID, Teacher tutor){
        this.name = name;
        this.ID = ID;
        this.tutor = tutor;
    }

    public void printInfo() {
        System.out.print("Student Name: " + name + "; ID: " + ID + ".   ");
        tutor.printInfo();
        System.out.println();
    }
    
    // 重载
    public void printInfo(boolean idPrintID) {
        System.out.print("Student Name: " + name + "; ID: " + ID + ".   ");
        tutor.printInfo();
        System.out.println();
    }

}

class GrandeStudent extends Student {
    private String article;
    // private Teacher tutor;
    public GrandeStudent(String name, int ID, Teacher tutor,String article) {
        super(name, ID, tutor);
        this.article = article;
    }

    public int getID() {
        return super.ID;
    }

    public String getName() {
        return super.name;
    }

    public void printArticle() {
        System.out.println(article);
    }
    
}