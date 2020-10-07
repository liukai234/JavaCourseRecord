import com.sun.jdi.ClassType;

import java.util.Iterator;
import java.util.LinkedList;

class Class {
    private int num; // 班级号
    public Class(int num) {
        this.num = num;
    }
    public int getThisClass() { return num; }
    private LinkedList<Teacher> teachers = new LinkedList<>();
    private LinkedList<Student> students = new LinkedList<>();
    private LinkedList<Course> courses = new LinkedList<>();
    private LinkedList<GrandeStudent> grandeStudents = new LinkedList<>();

    public LinkedList<Teacher> getTeachers() { return teachers; }
    public LinkedList<Student> getStudents() { return students; }
    public LinkedList<Course> getCourses() { return courses; }
    public LinkedList<GrandeStudent> getGrandeStudents() { return grandeStudents; }


       /* @Override public String toString(){
            Iterator<Teacher> iter = teachers.iterator();
            stringCache = "\n";
            while(iter.hasNext()) {
                stringCache += iter.next().getName() + '\n';
            }
            return stringCache;
        }*/
}

//class PrintMemOperationInfo {
//    public void printMenOperationInfo(Class c) {
//        memberOperation.printAllMember(c);
//    }
//}
