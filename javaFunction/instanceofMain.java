import java.util.ArrayList;
import java.util.Vector;

public class instanceofMain{
    public static void main(String[] args) {
        Object testObject = new ArrayList();
        displayObjectClass(testObject);
    }
    public static void displayObjectClass(Object o) {
        if(o instanceof Vector){
            System.out.println("对象是Vector实例");
        }/* else if(o instanceof ArrayList) {
            System.out.println("对象是ArrayList实例");
        }*/ else {
            System.out.println(o.getClass());
        }


    }
}