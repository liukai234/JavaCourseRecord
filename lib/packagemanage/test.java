import circle.*;
public class test {
    public static void main(String[] args) {
        // 内部静态类
        InnerCircle.staticDraw staticCircle = new InnerCircle.staticDraw();
        staticCircle.drawShape();


        // 内部类
        InnerCircle innerCircle = new InnerCircle(5);
        innerCircle.callCircle2();
        // 
        InnerCircle.Draw d = innerCircle.new Draw();
        d.drawShape();

    }
}

