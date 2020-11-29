import javax.swing.*;
import java.awt.*;

public class WindowMouse extends JFrame {
    JTextField textField;
    JTextArea textArea;
    JButton button;

    MousePolice mousePolice;
    WindowMouse () {
        init();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    void init() {
        setLayout( new FlowLayout());
        textField = new JTextField(8);
        textArea = new JTextArea(5, 28);
        mousePolice = new MousePolice();
        mousePolice.setTextField(textArea);

        textField.addMouseListener(mousePolice);
        button = new JButton("Cal");
        button.addMouseListener(mousePolice);

        addMouseListener(mousePolice);
        add(textField);
        add(button);
        add(new JScrollPane(textArea) );
    }
}