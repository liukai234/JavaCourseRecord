import java.awt.*;

public class Rect implements Shape {
    private final int x;
    private final int y;
    private final int width;
    private final int height;
    public Rect(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void Draw(Graphics g) {
        System.out.println("Rect Draw called");
        g.drawRect(x, y, width, height);
    }
}
