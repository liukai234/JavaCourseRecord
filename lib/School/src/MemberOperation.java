import java.util.Iterator;
import java.util.LinkedList;

class MemberOperation  {
    private String stringCache;

    public static void addMember(Member m, Class c) {
        if (m instanceof Teacher) {
            c.getTeachers().add((Teacher) m);
        } else if (m instanceof Student) {
            c.getStudents().add((Student) m);
        } else if (m instanceof Course) {
            c.getCourses().add((Course) m);
        } else if (m instanceof GrandeStudent) {
            c.getGrandeStudents().add((GrandeStudent) m);
        }
    }

    public static void removeMember(Member m, Class c) {
        if (m instanceof Teacher) {
            Iterator<Teacher> iter = c.getTeachers().iterator();
            while (iter.hasNext()) {
                if (iter.next().getName().equals(m.getName())) {
                    iter.remove();
                    return;
                }
            }
        } else if (m instanceof Student) {
            Iterator<Student> iter = c.getStudents().iterator();
            while (iter.hasNext()) {
                if (iter.next().getName().equals(m.getName())) {
                    iter.remove();
                    return;
                }
            }
        }
        if (m instanceof Course) {
            Iterator<Course> iter = c.getCourses().iterator();
            while (iter.hasNext()) {
                if (iter.next().getName().equals(m.getName())) {
                    iter.remove();
                    return;
                }
            }
        }
        if (m instanceof GrandeStudent) {
            Iterator<GrandeStudent> iter = c.getGrandeStudents().iterator();
            while (iter.hasNext()) {
                if (iter.next().getName().equals(m.getName())) {
                    iter.remove();
                    return;
                }
            }
        }

    }

    public void setThesis(Member m, String thesis) {
        if (m instanceof GrandeStudent) {
            ((GrandeStudent) m).setThesis(thesis);
        } else {
            System.out.println("null");
        }
    }

    public String getThesis(Member m) {
        if (m instanceof GrandeStudent) {
            return ((GrandeStudent) m).getThesis();
        } else {
            return null;
        }
    }

    public static void updateMember(Member originMember, Member newMember, Class c) {
        if (originMember instanceof Teacher) {

            Iterator<Teacher> iter = c.getTeachers().iterator();
            while (iter.hasNext()) {
                Teacher temp = iter.next(); // iter每次访问.next()时会指向下一个结点
                if (temp.getName().equals(originMember.getName())) {
                    temp.setName(newMember.getName());
                }
            }
        } else if (originMember instanceof Student) {

            Iterator<Student> iter = c.getStudents().iterator();
            while (iter.hasNext()) {
                Student temp = iter.next(); // iter每次访问.next()时会指向下一个结点
                if (temp.getName().equals(originMember.getName())) {
                    temp.setName(newMember.getName());
                }
            }
        }
        if (originMember instanceof Course) {
            Iterator<Course> iter = c.getCourses().iterator();
            while (iter.hasNext()) {
                Course temp = iter.next(); // iter每次访问.next()时会指向下一个结点
                if (temp.getName().equals(originMember.getName())) {
                    temp.setName(newMember.getName());
                }
            }
        }
        if (originMember instanceof GrandeStudent) {

            Iterator<GrandeStudent> iter = c.getGrandeStudents().iterator();
            while (iter.hasNext()) {
                GrandeStudent temp = iter.next(); // iter每次访问.next()时会指向下一个结点
                if (temp.getName().equals(originMember.getName())) {
                    temp.setName(newMember.getName());
                }
            }
        }
    }

    public static Member getMember(Member m, Class c) {
        if (m instanceof Teacher) {
            Iterator<Teacher> iter = c.getTeachers().iterator();
            while (iter.hasNext()) {
                Teacher temp = iter.next();
                if (temp.getName().equals(m.getName())) {
                    return temp;
                }
            }
        } else if (m instanceof Student) {
            Iterator<Student> iter = c.getStudents().iterator();
            while (iter.hasNext()) {
                Student temp = iter.next();
                if (temp.getName().equals(m.getName())) {
                    return temp;
                }
            }
        } else if (m instanceof Course) {
            Iterator<Course> iter = c.getCourses().iterator();
            while (iter.hasNext()) {
                Course temp = iter.next();
                if (temp.getName().equals(m.getName())) {
                    return temp;
                }
            }
        } else if (m instanceof GrandeStudent) {
            Iterator<GrandeStudent> iter = c.getGrandeStudents().iterator();
            while (iter.hasNext()) {
                GrandeStudent temp = iter.next();
                if (temp.getName().equals(m.getName())) {
                    return temp;
                }
            }
        }
        return null;
    }

    public static void printAllMember(Class c) {
        System.out.println("print ALL Member: class" + c.getThisClass());

        System.out.println("Teacher: " + c.getTeachers().size());
        Iterator<Teacher> iterTeachers = c.getTeachers().iterator();
        while (iterTeachers.hasNext()) {
            System.out.println(iterTeachers.next());
        }
        System.out.println("---");

        System.out.println("Student: " + c.getStudents().size());
        Iterator<Student> iterStudents = c.getStudents().iterator();
        while (iterStudents.hasNext()) {
            System.out.println(iterStudents.next());
        }
        System.out.println("---");

        System.out.println("Course: " + c.getCourses().size());
        Iterator<Course> iterCourse = c.getCourses().iterator();
        while (iterCourse.hasNext()) {
            System.out.println(iterCourse.next());
        }
        System.out.println("---");

        System.out.println("GrandStudent: " + c.getGrandeStudents().size());
        Iterator<GrandeStudent> iterGrandStudent = c.getGrandeStudents().iterator();
        while (iterGrandStudent.hasNext()) {
            System.out.println(iterGrandStudent.next());
        }
        System.out.println("---");
    }
}