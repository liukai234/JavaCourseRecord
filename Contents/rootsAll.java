import java.io.File;

public class rootsAll {
    public static void main(String[] args) {
        File[] roots = File.listRoots();
        System.out.println("系统根目录为: ");
        for(int i = 0; i < roots.length; i++) {
            System.out.println(roots[i].toString());
        }
        System.out.println(System.getProperty("user.dir"));
    }
}