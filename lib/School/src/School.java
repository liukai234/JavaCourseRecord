import java.util.Iterator;
import java.util.LinkedList;

public class School{
    public static void main(String[] args) {

//        PrintMemOperationInfo printMemOperationInfo = new PrintMemOperationInfo(); // 打印班级内所有指定类型成员
//        PrintMemInfo printInfo = new PrintMemInfo(); // 打印某指定成员所有信息
//
        Class class1 = new Class(1);
        Class class2 = new Class(2);
//        Class.MemberOperation class1memberOperation = class1.new MemberOperation();

        MemberOperation.addMember(new Teacher("class1's Teacher1"), class1);
        MemberOperation.addMember(new Student("class1's Student1"), class1);
        MemberOperation.addMember(new Student("class1's Student2"), class1);
        MemberOperation.addMember(new Course("class1's Course1"), class1);
        MemberOperation.printAllMember(class1);

        MemberOperation.addMember(new GrandeStudent("class2's GrandeStudent1"), class2);

        GrandeStudent t = (GrandeStudent)MemberOperation.getMember(new GrandeStudent("class2's GrandeStudent1"), class2);
        t.setThesis("GrandStudent1's thesis");
        System.out.println(t);

        MemberOperation.printAllMember(class2);
        // name,
//        class1memberOperation.addMember(new Teacher("class1's Teacher1"));
//        class1memberOperation.printAllMember();

//        class1.teacherOperation.addMember("class1's Teacher2");
//        printMemOperationInfo.printMenOperationInfo(class1.teacherOperation);
//
//        System.out.println("重载sysout");
//        System.out.println(class1.teacherOperation);
//        System.out.println(class1.teacherOperation.getMember("class1's Teacher1"));
//
//        class1.teacherOperation.removeMember("class1's Teacher2");
//        printMemOperationInfo.printMenOperationInfo(class1.teacherOperation);
//
//        class1.studentOperation.addMember("class1's Student1");
//        printMemOperationInfo.printMenOperationInfo(class1.studentOperation);
//
//        class1.grandeStudentsOperation.addMember("class1's GrandStudent1");
//
//        class1.grandeStudentsOperation.getMember("class1's GrandStudent1").setThesis("论文");
//        System.out.println(class1.grandeStudentsOperation.getMember("class1's GrandStudent1").getThesis());
    }
}


