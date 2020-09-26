/**
 * Circle
 */
public class Circle {
    public static void main(String[] args) {
        InnerCircle.staticDraw aDraw = new InnerCircle.staticDraw();
        aDraw.drawShape();

        InnerCircle innerCircle = new InnerCircle(5.0);
        InnerCircle.Draw bDraw = innerCircle.new Draw();
        bDraw.drawShape();
    }
    
}

/**
 * InnerCircle
 */
class InnerCircle {
    private double radius = 0;
    public static int count = 1;

    public InnerCircle(double radius) {
        this.radius = radius;
    }

    public class Draw {
        public void drawShape() {
            // Cannot make a static reference to the non-static field radius
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
    
}