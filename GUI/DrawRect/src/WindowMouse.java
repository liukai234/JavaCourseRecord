import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class WindowMouse extends JFrame{
    MousePolice mousePolice;
    Board board;

    JButton btnRect;
    JButton btnCircle;

    Graphics g;
    WindowMouse () {
        init();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(300, 300, 500, 500);
        setResizable(false);
    }

    void init() {
        // ! 不能在此获得board.getGraphics 为空
        // 需要在mousePolice中获得
        setLayout( new FlowLayout());

        btnRect = new JButton("Rect");
        btnRect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mousePolice.setShapeType("Rect");
            }
        });

        btnCircle = new JButton("Circle");
        btnCircle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mousePolice.setShapeType("Circle");
            }
        });

        board = new Board();

        mousePolice = new MousePolice();
        mousePolice.setBoard(board);


        board.addMouseListener(mousePolice);
        board.addMouseMotionListener(mousePolice);

        board.setPreferredSize(new Dimension(500, 500));

        add(btnRect);
        add(btnCircle);
        add(board);

        mousePolice.setGraphics();
    }
}