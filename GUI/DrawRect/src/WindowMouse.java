import javax.swing.*;
import java.awt.*;

public class WindowMouse extends JFrame {
    MousePolice mousePolice;
    Board board;
    WindowMouse () {
        init();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(300, 300, 500, 500);
    }

    void init() {
        // ! 不能在此获得board.getGraphics 为空
        // 需要在mousePolice中获得
        setLayout( new FlowLayout());

        board = new Board();
        mousePolice = new MousePolice();
        mousePolice.setBoard(board);

        board.addMouseListener(mousePolice);
        board.addMouseMotionListener(mousePolice);

        board.setPreferredSize(new Dimension(500, 500));
        add(board);
    }
}