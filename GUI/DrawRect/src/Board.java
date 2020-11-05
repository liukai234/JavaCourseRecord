import javax.swing.*;
import java.awt.*;

public class Board extends JPanel {
    public Board(){}

    private final int MAX_NUM = 100000;
    private Shape [] shapes = new Shape[MAX_NUM];
    private static int index = 0;

    public void add(Shape shape) {
        shapes[index] = shape;
        index += 1;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        System.out.println("paint called");

        for(int i = 0; i < index; i++) {
            shapes[i].Draw(g);
        }
        g.dispose();
    }
}
