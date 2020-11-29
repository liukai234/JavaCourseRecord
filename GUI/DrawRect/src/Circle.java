import javax.swing.*;
import java.awt.*;

public class Circle extends JPanel implements Shape{
    private final int x;
    private final int y;
    private final int width;
    private final int height;
//    private final Graphics g;
    public Circle(int x, int y, int width, int height) { // , Graphics g
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
//        this.g = g;
    }

    public void Draw() {
        getGraphics().drawOval(x, y, width, height);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawOval(x, y, width, height);
    }

//    @Override
//    public void Draw(Graphics g) {
//        g.drawOval(x, y, width, height);
//    }
}
