import java.util.Iterator;
import java.util.LinkedList;

class Class {
    private int num; // 班级号
    public Class(int num) {
        this.num = num;
    }

    private LinkedList<Teacher> teachers = new LinkedList<>();
    LinkedList<Student> students = new LinkedList<>();
    LinkedList<Course> courses = new LinkedList<>();
    LinkedList<GrandeStudent> grandeStudents = new LinkedList<>();

    public class MemberOperation implements IMemberOperation {
        private String stringCache;
/*
        private LinkedList<Member> members;
        public MemberOperation(LinkedList<Member> members) {

            this.members = members;
        }
*/

        @Override
        public void addMember(Member m) {
            if(m instanceof Teacher) { teachers.add((Teacher) m); }
            else if(m instanceof Student) { students.add((Student)m); }
            else if(m instanceof Course) { courses.add((Course)m); }
            else if(m instanceof GrandeStudent) { grandeStudents.add((GrandeStudent)m); }
            //            teachers.add(teacher);
        }

        @Override
        public void removeMember(Member m) {
            if(m instanceof Teacher) {
                Iterator<Teacher> iter = teachers.iterator();
                while(iter.hasNext()) {
                    if(iter.next().getName().equals(m.getName())){
                        iter.remove();
                        return;
                    }
                }
            }
            else if(m instanceof Student) {
                Iterator<Student> iter = students.iterator();
                while(iter.hasNext()) {
                    if(iter.next().getName().equals(m.getName())){
                        iter.remove();
                        return;
                    }
                }
            }
            if(m instanceof Course) {
                Iterator<Course> iter = courses.iterator();
                while(iter.hasNext()) {
                    if(iter.next().getName().equals(m.getName())){
                        iter.remove();
                        return;
                    }
                }
            }
            if(m instanceof GrandeStudent) {
                Iterator<GrandeStudent> iter = grandeStudents.iterator();
                while(iter.hasNext()) {
                    if(iter.next().getName().equals(m.getName())){
                        iter.remove();
                        return;
                    }
                }
            }

        }
        public void setThesis(Member m, String thesis){
            if(m instanceof GrandeStudent) {
                ((GrandeStudent) m).setThesis(thesis);
            } else {
                System.out.println("null");
            }
        }

        public String getThesis(Member m){
            if(m instanceof GrandeStudent) {
                return ((GrandeStudent) m).getThesis();
            } else {
                return null;
            }
        }
        @Override
        public void updateMember(Member originMember, Member newMember) {
            if(originMember instanceof  Teacher) {

                Iterator<Teacher> iter = teachers.iterator();
                while(iter.hasNext()) {
                    Teacher temp = iter.next(); // iter每次访问.next()时会指向下一个结点
                    if(temp.getName().equals(originMember.getName())){
                        temp.setName(newMember.getName());
                    }
                }
            }
            else if(originMember instanceof Student) {

                Iterator<Student> iter = students.iterator();
                while(iter.hasNext()) {
                    Student temp = iter.next(); // iter每次访问.next()时会指向下一个结点
                    if(temp.getName().equals(originMember.getName())){
                        temp.setName(newMember.getName());
                    }
                }
            }
            if(originMember instanceof Course) {
                Iterator<Course> iter = courses.iterator();
                while(iter.hasNext()) {
                    Course temp = iter.next(); // iter每次访问.next()时会指向下一个结点
                    if(temp.getName().equals(originMember.getName())){
                        temp.setName(newMember.getName());
                    }
                }
            }
            if(originMember instanceof GrandeStudent) {

                Iterator<GrandeStudent> iter = grandeStudents.iterator();
                while(iter.hasNext()) {
                    GrandeStudent temp = iter.next(); // iter每次访问.next()时会指向下一个结点
                    if(temp.getName().equals(originMember.getName())){
                        temp.setName(newMember.getName());
                    }
                }
            }
        }

        @Override
        public Member getMember(Member m){
            if(m instanceof Teacher) {
                Iterator<Teacher> iter = teachers.iterator();
                while(iter.hasNext()) {
                    Teacher temp = iter.next();
                    if(temp.getName().equals(m.getName())){
                        return temp;
                    }
                }
            }else if(m instanceof Student) {
                Iterator<Student> iter = students.iterator();
                while(iter.hasNext()) {
                    Student temp = iter.next();
                    if(temp.getName().equals(m.getName())){
                        return temp;
                    }
                }
            }else if(m instanceof Course) {
                Iterator<Course> iter = courses.iterator();
                while(iter.hasNext()) {
                    Course temp = iter.next();
                    if(temp.getName().equals(m.getName())){
                        return temp;
                    }
                }
            }else if(m instanceof GrandeStudent) {
                Iterator<GrandeStudent> iter = grandeStudents.iterator();
                while(iter.hasNext()) {
                    GrandeStudent temp = iter.next();
                    if(temp.getName().equals(m.getName())){
                        return temp;
                    }
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

       /* @Override public String toString(){
            Iterator<Teacher> iter = teachers.iterator();
            stringCache = "\n";
            while(iter.hasNext()) {
                stringCache += iter.next().getName() + '\n';
            }
            return stringCache;
        }*/
    }
}


interface IMemberOperation {
    public abstract void addMember(Member m);
    public abstract void removeMember(Member m);
    public abstract void updateMember(Member originMem, Member newMem);
    public abstract Member getMember(Member m);
    public abstract void printAllMember();
//    public String toString();
}

class PrintMemOperationInfo {
    public void printMenOperationInfo(IMemberOperation memberOperation) {
        memberOperation.printAllMember();
    }
}
