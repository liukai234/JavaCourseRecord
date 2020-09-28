public class School{
    public static void main(String[] args) {
        Teacher t = new Teacher("zhaoliu", 20030826);
        Student s1 = new Student("zhangsan", 1707000101, t);
        s1.printInfo();
        Student s2 = new Student("lisi", 1707000102, t);
        s2.printInfo();
        Student s3 = new Student("wangwu", 1707000103, t);
        s3.printInfo();
        
        GrandeStudent gs = new GrandeStudent("gs", 1907000104, t, "article");
        System.out.println();
        System.out.println("Name: " + gs.getName() + " ID:" + gs.getID());
        gs.printArticle();
        System.out.println();

        s3.printInfo();
        
    }
}

class Teacher {
    private String name;
    private int ID;

    public Teacher(String name, int ID){
        this.name = name;
        this.ID = ID;
    }

    public void printInfo() {
        System.out.print("Teacher Name: " + name + "; ID: " + ID);
    }
    
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