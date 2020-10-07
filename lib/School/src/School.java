public class School{
    public static void main(String[] args) {

//        PrintMemOperationInfo printMemOperationInfo = new PrintMemOperationInfo(); // 打印班级内所有指定类型成员
//        PrintMemInfo printInfo = new PrintMemInfo(); // 打印某指定成员所有信息
//
        Clazz clazz1 = new Clazz(1);
        Clazz clazz2 = new Clazz(2);
//        Class.MemberOperation class1memberOperation = class1.new MemberOperation();

        MemberOperation.addMember(new Teacher("class1's Teacher1"), clazz1);
        MemberOperation.addMember(new Student("class1's Student1"), clazz1);
        MemberOperation.addMember(new Student("class1's Student2"), clazz1);
        MemberOperation.addMember(new Course("class1's Course1"), clazz1);
        MemberOperation.printAllMember(clazz1);

        MemberOperation.addMember(new GrandStudent("class2's GrandeStudent1"), clazz2);

        GrandStudent t = (GrandStudent)MemberOperation.getMember(new GrandStudent("class2's GrandeStudent1"), clazz2);
        t.setThesis("GrandStudent1's thesis");
        System.out.println(t);

        MemberOperation.printAllMember(clazz2);
    }
}


