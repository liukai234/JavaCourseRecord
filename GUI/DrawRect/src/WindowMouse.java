import javax.swing.*;
import java.awt.*;

public class WindowMouse extends JFrame {
    Graphics graphics;
    MousePolice mousePolice;
    JPanel panel;
    Board board;
    WindowMouse () {
        init();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(300, 300, 500, 500);
    }

    void init() {
        setLayout( new FlowLayout());

        board = new Board();

//        textField = new JTextField(8);
//        textArea = new JTextArea(5, 28);

        mousePolice = new MousePolice();
        //
//        JLabel label = new JLabel("panel");
//        panel.add(label);
        board.setPreferredSize(new Dimension(500, 500));

//        mousePolice.setGraphics(graphics);
        mousePolice.setBoard(board);
        board.addMouseListener(mousePolice);
        add(board);
//        getContentPane().add(new Board()); //  add(panel);

//        mousePolice.setTextField(textArea);
//
//        textField.addMouseListener(mousePolice);
//        button = new JButton("Cal");
//        button.addMouseListener(mousePolice);
//
//        addMouseListener(mousePolice);
//        add(textField);
//        add(button);
//        add(new JScrollPane(textArea) );
    }
}