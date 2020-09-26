package school;
public class Student {
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