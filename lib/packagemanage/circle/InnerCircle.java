package circle; //包名用小写

/**
 * Circle
 */
// public class Circle {
//     public static void main(String[] args) {
//         InnerCircle.staticDraw aDraw = new InnerCircle.staticDraw();
//         aDraw.drawShape();

//         InnerCircle innerCircle = new InnerCircle(5.0);
//         InnerCircle.Draw bDraw = innerCircle.new Draw();
//         bDraw.drawShape();
//     }
    
// }

/**
 * InnerCircle
 */
public class InnerCircle {
    private double radius = 0;
    public static int count = 1;

    public InnerCircle(double radius) {
        this.radius = radius;
    }

    public class Draw {
        public void drawShape() {
            // Cannot make a static reference to the non-static field radius
            System.out.println("Draw drawShape");
            System.out.println(radius);
            System.out.println(count);
        }
    }

    public static class staticDraw {
        public void drawShape() {
            // Cannot make a static reference to the non-static field radius
            // System.out.println(radius);
            System.out.println(count);
        }
    }

    public void callCircle2() {
        InnerCircle2 a = new InnerCircle2();
        a.sysout();
        a.main();
    }
    
}

class InnerCircle2 { // 一个包中只能有一个公有类，也就是说：一个包只提供一个公有接口，剩下的类都是用于包内功能的实现
    // 包内可以有主函数，主函数不一定在公有类中
    public void sysout(){
        System.out.println("2InnerInnerCircle2");
    }
    
    // 同名而已
    public void main() {
        System.out.println("InnerCircle2->main");
        
    }
    
}