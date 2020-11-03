import javax.swing.*;
import java.awt.*;

public class Board extends JPanel {
    public Board(){}

    private final int MAX_NUM = 100;
    private Rect [] rects = new Rect[MAX_NUM];
    private static int rectNumber = 0;
//    private Circle[] circles = new Circle[10];
//    private static int circleNumber = 0;
//    Graphics g;
    public void creatRect(int x, int y, int width, int height) throws MaxNumException {
//        this.g = g;
        System.out.println(x +" " + y +" "+ width +" "+ height);
        if(rectNumber >= MAX_NUM) throw new MaxNumException(rectNumber);

        rects[rectNumber] = new Rect(x, y, width, height);
        rectNumber += 1;
    }

//    public void creatCircle() throws MaxNumException {
//        if(circleNumber >= MAX_NUM) throw new MaxNumException(circleNumber);
//
//        circles[circleNumber] = new Circle();
//        circleNumber += 1;
//    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);
        System.out.println("paint called");
//        Graphics2D graphics2D = (Graphics2D) g;
        Rect x;
        for(int i = 0; i < rectNumber; i++) {
            x = rects[i];
            g.drawRect(x.getX(), x.getY(), x.getWidth(), x.getHeight());
        }
        repaint();
        g.dispose();
    }
}

class MaxNumException extends java.lang.Exception {
    static final long serialVersionUID = -3387516993124229948L;
    String message;
    public MaxNumException(Number n) {
        message = n + " overflow";
    }

    @Override
    public String getMessage() {
        return message;
    }
}