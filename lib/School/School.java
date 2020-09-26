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
