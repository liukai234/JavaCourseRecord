import java.util.Iterator;
import java.util.LinkedList;

public class School{
    public static void main(String[] args) {

//        PrintMemOperationInfo printMemOperationInfo = new PrintMemOperationInfo(); // 打印班级内所有指定类型成员
//        PrintMemInfo printInfo = new PrintMemInfo(); // 打印某指定成员所有信息
//
        Class class1 = new Class(1);
        Class.MemberOperation class1memberOperation = class1.new MemberOperation();

        // name,
        class1memberOperation.addMember(new Teacher("class1's Teacher1"));
        class1memberOperation.printAllMember();

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


