interface Student {
    int getScore();
    String getName();
    boolean isGradute();
    String toString();
}

class underGraduateStudent implements Student {
    private int score;
    private String name;
    private final static int graduteScore = 26;
    public underGraduateStudent(int score, String name) {
        this.score = score;
        this.name = name;
    }

    @Override public int getScore() { return score; }
    @Override public String getName() { return name; }
    @Override public boolean isGradute() { if(score > graduteScore) {return true;} return false; }

    @Override
    public String toString() {
        return "underGraduateStudent{" +
                "score=" + score +
                ", name='" + name + '\'' +
                "} isGradute: " + isGradute();
    }
}

class graduateStudent implements Student {
    private int score;
    private String name;
    private final static int graduteScore = 15;

    public graduateStudent(int score, String name) {
        this.score = score;
        this.name = name;
    }

    @Override public int getScore() { return score; }
    @Override public String getName() { return name; }
    @Override public boolean isGradute() { if(score > graduteScore) {return true;} return false; }

    @Override
    public String toString() {



        return "graduateStudent{" +
                "score=" + score +
                ", name='" + name + '\'' +
                "} isGradute: " + isGradute();
    }
}

public class Test {
    public static void main(String[] args) {
        Student[] students = new Student[10];
        students[0] = new underGraduateStudent(23, "No.1");
        students[1] = new underGraduateStudent(24, "No.2");
        students[2] = new underGraduateStudent(25, "No.3");
        students[3] = new underGraduateStudent(26, "No.4");
        students[4] = new underGraduateStudent(27, "No.5");
        students[5] = new graduateStudent(13, "No.6");
        students[6] = new graduateStudent(14, "No.7");
        students[7] = new graduateStudent(15, "No.8");
        students[8] = new graduateStudent(16, "No.9");
        students[9] = new graduateStudent(17, "No.10");

        for(Student x : students) { System.out.println(x); }
    }
}