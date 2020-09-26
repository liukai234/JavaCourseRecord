package school;


/**
 * GrandeStudent
 */
public class GrandeStudent extends Student {
    private String article;
    // private Teacher tutor;
    public GrandeStudent(String name, int ID, Teacher tutor,String article) {
        super(name, ID, tutor);
        this.article = article;
    }

    public int getID() {
        return super.ID;
    }

    public String getName() {
        return super.name;
    }

    public void printArticle() {
        System.out.println(article);
    }
    
}