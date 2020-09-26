import imple234.*;

public class Example {
    public static void main(String[] args) {
        China china = new China();
        Japan japan = new Japan();
        
        china.number = Computable3.MAX + 20;
        japan.number = Computable3.MAX + 20;
        
        System.out.println(china.f(100));    
        System.out.println(japan.f(100));    
    }
}
