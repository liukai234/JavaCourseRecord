
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
    @Override public String toString(){ stringCache = "GrandeStudent Name: " + super.getName() + ", thesis: " + thesis; return stringCache; }

    public void setThesis(String thesis){ this.thesis = thesis; }
    public String getThesis(){ return thesis; }
}

class PrintMemInfo { public void printMemInfo(Member member) { member.printInfo(); }}