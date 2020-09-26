import pack.circle.InnerCircle;

public class test {
    public static void main(String[] args) {
        InnerCircle.staticDraw staticCircle = new InnerCircle.staticDraw();
        staticCircle.drawShape();


        InnerCircle innerCircle = new InnerCircle(5);
        innerCircle.callCircle2();
    }
}

