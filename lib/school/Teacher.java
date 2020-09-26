package school;
/**
 * Teacher
 */
public class Teacher {
    private String name;
    private int ID;

    public Teacher(String name, int ID){
        this.name = name;
        this.ID = ID;
    }

    public void printInfo() {
        System.out.print("Teacher Name: " + name + "; ID: " + ID);
    }
    
}