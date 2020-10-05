import java.util.Iterator;
import java.util.LinkedList;

public class School{
    public static void main(String[] args) {

        PrintMemOperationInfo printMemOperationInfo = new PrintMemOperationInfo(); // 打印班级内所有指定类型成员
        PrintMemInfo printInfo = new PrintMemInfo(); // 打印某指定成员所有信息

        Class class1 = new Class(1);
        class1.teacherOperation.addMember("class1's Teacher1");
        class1.teacherOperation.addMember("class1's Teacher2");
        printMemOperationInfo.printMenOperationInfo(class1.teacherOperation);

        System.out.println("重载sysout");
        System.out.println(class1.teacherOperation);
        System.out.println(class1.teacherOperation.getMember("class1's Teacher1"));

        class1.teacherOperation.removeMember("class1's Teacher2");
        printMemOperationInfo.printMenOperationInfo(class1.teacherOperation);

        class1.studentOperation.addMember("class1's Student1");
        printMemOperationInfo.printMenOperationInfo(class1.studentOperation);

        class1.grandeStudentsOperation.addMember("class1's GrandStudent1");

        class1.grandeStudentsOperation.getMember("class1's GrandStudent1").setThesis("论文");
        System.out.println(class1.grandeStudentsOperation.getMember("class1's GrandStudent1").getThesis());
    }
}

class Class {
    private int num; // 班级号
    public Class(int num) {
        this.num = num;
    }

    private LinkedList<Teacher> teachers = new LinkedList<>();
    LinkedList<Student> students = new LinkedList<>();
    LinkedList<Course> courses = new LinkedList<>();
    LinkedList<GrandeStudent> grandeStudents = new LinkedList<>();

    public TeacherOperation teacherOperation = new TeacherOperation(teachers);
    public StudentOperation studentOperation = new StudentOperation(students);
    public CourseOperation courseOperation = new CourseOperation(courses);
    public GrandeStudentOperation grandeStudentsOperation = new GrandeStudentOperation(grandeStudents);

    public class TeacherOperation implements MemberOperation {
        private LinkedList<Teacher> teachers;
        private String stringCache;
        public TeacherOperation(LinkedList<Teacher> teachers) {
            this.teachers = teachers;
        }

        @Override
        public void addMember(String name) {
            Teacher teacher = new Teacher(name);
            teachers.add(teacher);
        }

        @Override
        public void removeMember(String name) {
            Teacher teacher = new Teacher(name);
            Iterator<Teacher> iter = teachers.iterator();
            while(iter.hasNext()) {
                if(iter.next().getName().equals(name)){
                    iter.remove();
                    return;
                }
            }
        }

        @Override
        public void updateMember(String originName, String newName) {
            Iterator<Teacher> iter = teachers.iterator();
            while(iter.hasNext()) {
                Teacher temp = iter.next(); // iter每次访问.next()时会指向下一个结点
                if(temp.getName().equals(originName)){
                    temp.setName(newName);
                }
            }
        }

        @Override
        public Teacher getMember(String name){
            Teacher teacher = new Teacher(name);
            Iterator<Teacher> iter = teachers.iterator();
            while(iter.hasNext()) {
                Teacher temp = iter.next();
                if(temp.getName().equals(name)){
                    return temp;
                }
            }
            return null;
        }

        @Override
        public void printAllMember() {
            Iterator<Teacher> iter = teachers.iterator();
            while(iter.hasNext()) {
                System.out.println(iter.next().getName());
            }
            System.out.println("共有数据" + teachers.size() + "条");
        }

        @Override public String toString(){
            Iterator<Teacher> iter = teachers.iterator();
            stringCache = "\n";
            while(iter.hasNext()) {
                stringCache += iter.next().getName() + '\n';
            }
            return stringCache;
        }
    }


    public class StudentOperation implements MemberOperation {
        private LinkedList<Student> students;
        private String stringCache;
        public StudentOperation(LinkedList<Student> students) {
            this.students = students;
        }

        @Override
        public void addMember(String name) {
            Student student = new Student(name);
            students.add(student);
        }

        @Override
        public void removeMember(String name) {
            Student teacher = new Student(name);
            Iterator<Student> iter = students.iterator();
            while(iter.hasNext()) {
                if(iter.next().getName().equals(name)){
                    iter.remove();
                    return;
                }
            }
        }

        @Override
        public void updateMember(String originName, String newName) {
            Iterator<Student> iter = students.iterator();
            while(iter.hasNext()) {
                Student temp = iter.next(); // iter每次访问.next()时会指向下一个结点
                if(temp.getName().equals(originName)){
                    temp.setName(newName);
                }
            }
        }

        @Override
        public Student getMember(String name){
            Student student = new Student(name);
            Iterator<Student> iter = students.iterator();
            while(iter.hasNext()) {
                Student temp = iter.next();
                if(temp.getName().equals(name)){
                    return temp;
                }
            }
            return null;
        }

        @Override
        public void printAllMember() {
            Iterator<Student> iter = students.iterator();
            while(iter.hasNext()) {
                System.out.println(iter.next().getName());
            }
            System.out.println("共有数据" + teachers.size() + "条");
        }

        @Override public String toString(){
            Iterator<Student> iter = students.iterator();
            stringCache = "\n";
            while(iter.hasNext()) {
                stringCache += iter.next().getName() + '\n';
            }
            return stringCache;
        }
    }
    public class CourseOperation implements MemberOperation {
        private LinkedList<Course> courses;
        private String stringCache;
        public CourseOperation(LinkedList<Course> courses) {
            this.courses = courses;
        }

        @Override
        public void addMember(String name) {
            Course course = new Course(name);
            courses.add(course);
        }

        @Override
        public void removeMember(String name) {
            Course course = new Course(name);
            Iterator<Course> iter = courses.iterator();
            while(iter.hasNext()) {
                if(iter.next().getName().equals(name)){
                    iter.remove();
                    return;
                }
            }
        }

        @Override
        public void updateMember(String originName, String newName) {
            Iterator<Course> iter = courses.iterator();
            while(iter.hasNext()) {
                Course temp = iter.next(); // iter每次访问.next()时会指向下一个结点
                if(temp.getName().equals(originName)){
                    temp.setName(newName);
                }
            }
        }

        @Override
        public Course getMember(String name){
            Course course = new Course(name);
            Iterator<Course> iter = courses.iterator();
            while(iter.hasNext()) {
                Course temp = iter.next();
                if(temp.getName().equals(name)){
                    return temp;
                }
            }
            return null;
        }

        @Override
        public void printAllMember() {
            Iterator<Course> iter = courses.iterator();
            while(iter.hasNext()) {
                System.out.println(iter.next().getName());
            }
            System.out.println("共有数据" + teachers.size() + "条");
        }

        @Override public String toString(){
            Iterator<Course> iter = courses.iterator();
            stringCache = "\n";
            while(iter.hasNext()) {
                stringCache += iter.next().getName() + '\n';
            }
            return stringCache;
        }
    }
    public class GrandeStudentOperation implements MemberOperation {
        private LinkedList<GrandeStudent> grandeStudents;
        private String stringCache;
        public GrandeStudentOperation(LinkedList<GrandeStudent> grandeStudents) {
            this.grandeStudents = grandeStudents;
        }

        @Override
        public void addMember(String name) {
            GrandeStudent grandeStudent = new GrandeStudent(name);
            grandeStudents.add(grandeStudent);
        }

        @Override
        public void removeMember(String name) {
            GrandeStudent grandeStudent = new GrandeStudent(name);
            Iterator<GrandeStudent> iter = grandeStudents.iterator();
            while(iter.hasNext()) {
                if(iter.next().getName().equals(name)){
                    iter.remove();
                    return;
                }
            }
        }

        @Override
        public void updateMember(String originName, String newName) {
            Iterator<GrandeStudent> iter = grandeStudents.iterator();
            while(iter.hasNext()) {
                GrandeStudent temp = iter.next(); // iter每次访问.next()时会指向下一个结点
                if(temp.getName().equals(originName)){
                    temp.setName(newName);
                }
            }
        }

        @Override
        public GrandeStudent getMember(String name){
            GrandeStudent grandeStudent = new GrandeStudent(name);
            Iterator<GrandeStudent> iter = grandeStudents.iterator();
            while(iter.hasNext()) {
                GrandeStudent temp = iter.next();
                if(temp.getName().equals(name)){
                    return temp;
                }
            }
            return null;
        }

        public void setThesis(String name, String thesis){
            GrandeStudent grandeStudent = getMember(name);
            if(grandeStudents == null) {
                System.out.println("setThesis ERROR");
                return;
            }
            grandeStudent.setThesis(thesis);
        }
        public String getThesis(String name){
            GrandeStudent grandeStudent = getMember(name);
            if(grandeStudents == null) {
                System.out.println("getThesis ERROR");
            }
            return grandeStudent.getThesis();
        }

        @Override
        public void printAllMember() {
            Iterator<GrandeStudent> iter = grandeStudents.iterator();
            while(iter.hasNext()) {
                System.out.println(iter.next().getName());
            }
            System.out.println("共有数据" + teachers.size() + "条");
        }

        @Override public String toString(){
            Iterator<GrandeStudent> iter = grandeStudents.iterator();
            stringCache = "\n";
            while(iter.hasNext()) {
                stringCache += iter.next().getName() + '\n';
            }
            return stringCache;
        }
    }
}

interface Member {
    public abstract void setName(String name);
    public abstract String getName();
    public abstract void printInfo();
    public String toString();
}

class Teacher implements Member{
    private String stringCache;
    private String name;
    public Teacher(String name){
        this.name = name;
    }
    @Override public void setName(String name) { this.name = name; }
    @Override public String getName(){
        return name;
    }
    @Override public void printInfo() { System.out.println("Teacher Name: " + name); }
    @Override public String toString(){ stringCache = "Teacher Name: " + name; return stringCache; }
}

class Student implements Member{
    private String stringCache;
    private String name;
    protected int isGraduation = 0;
    protected boolean canGraduation;
    public Student(String name) { this.name = name; }
    @Override public void setName(String name) { this.name = name; }
    @Override public String getName(){
        return name;
    }
    @Override public void printInfo() { System.out.print("Student Name: " + name); }
    @Override public String toString(){ stringCache = "Student Name: " + name; return stringCache; }

    public void setIsGraduation(int isGraduation) { this.isGraduation = isGraduation; }
    public int getIsGraduation() { return isGraduation; }
    public void setCanGraduation(boolean canGraduation) { this.canGraduation = canGraduation; }
    public boolean getCanGraduation() { return canGraduation; }
}

class Course implements Member{
    private String stringCache;
    private String name;
    public Course(String name){
        this.name = name;
    }
    @Override public void setName(String name) { this.name = name; }
    @Override public String getName(){
        return name;
    }
    @Override public void printInfo() { System.out.println("Course Name: " + name); }
    @Override public String toString(){ stringCache = "Course Name: " + name; return stringCache; }
}

class GrandeStudent extends Student implements Member{
    private String stringCache;
    private String thesis;
    public GrandeStudent(String name) { super(name); }
    @Override public void printInfo() { System.out.println("GrandeStudent Name: " + super.getName()); }
    @Override public String toString(){ stringCache = "GrandeStudent Name: " + super.getName(); return stringCache; }

    public void setThesis(String thesis){ this.thesis = thesis; }
    public String getThesis(){ return thesis; }
}

class PrintMemInfo { public void printMemInfo(Member member) { member.printInfo(); }}

interface MemberOperation {
    public abstract void addMember(String name);
    public abstract void removeMember(String name);
    public abstract void updateMember(String originName, String newName);
    public abstract Member getMember(String name);
    public abstract void printAllMember();
    public String toString();
}

class PrintMemOperationInfo {
    public void printMenOperationInfo(MemberOperation memberOperation) {
        memberOperation.printAllMember();
    }
}

