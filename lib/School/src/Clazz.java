import java.util.LinkedList;

class Clazz {
    private int num; // 班级号
    public Clazz(int num) {
        this.num = num;
    }
    public int getThisClazz() { return num; }

    private LinkedList<Teacher> teachers = new LinkedList<>();
    private LinkedList<Student> students = new LinkedList<>();
    private LinkedList<Course> courses = new LinkedList<>();
    private LinkedList<GrandStudent> grandStudents = new LinkedList<>();

    public LinkedList<Member> getMembers(Member m) throws NullPointerException{
        LinkedList<Member> ret = null;
        String mName = m.getClass().getName();
        if(mName == "Teacher") ret = (LinkedList)teachers;
        else if(mName == "Student") ret = (LinkedList)students;
        else if(mName == "Course") ret = (LinkedList)courses;
        else if(mName == "GrandStudent") ret = (LinkedList) grandStudents;
        if(ret == null) throw new NullPointerException("Member Type not exist");
        return ret;
    }

    public LinkedList<Member> getMembers(String s) throws NullPointerException {
        LinkedList<Member> ret = null;
        if(s == "Teacher") ret = (LinkedList)teachers;
        else if(s == "Student") ret = (LinkedList)students;
        else if(s == "Course") ret = (LinkedList)courses;
        else if(s == "GrandStudent") ret = (LinkedList) grandStudents;
        if(ret == null) throw new NullPointerException("Member Type not exist");
        return ret;
    }
}
