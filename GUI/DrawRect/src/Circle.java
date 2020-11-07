import java.awt.*;

public class Circle implements Shape {
    private final int x;
    private final int y;
    private final int width;
    private final int height;
    private final Graphics g;
    public Circle(int x, int y, int width, int height, Graphics g) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.g = g;
    }

    public void Draw() {
        g.drawOval(x, y, width, height);
    }

    @Override
    public void Draw(Graphics g) {
        g.drawOval(x, y, width, height);
    }
}
