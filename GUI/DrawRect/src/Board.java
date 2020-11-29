import javax.swing.*;
import java.awt.*;

public class Board extends JPanel {
    public Board(){}

    private final int MAX_NUM = 1000;
    private Shape [] shapes = new Shape[MAX_NUM];
    private static int index = 0;

    public void add(Shape shape) {
        shapes[index] = shape;
        index += 1;
    }

    @Override
    public void paint(Graphics g) {
        for(int i = 0; i < index; i++) {
            shapes[i].Draw();
        }
    }

    public void reFresh() {
        for(int i = 0; i < index; i++) {
            shapes[i].Draw();
        }
    }

}
