import javax.swing.*;
import java.awt.*;
import java.math.BigInteger;

public class Window extends JFrame {
    JTextField textField;
    JTextArea textArea;
    JButton button; // 控制器
    ExtendListener listener;

    Window () {
        init();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setSize(300, 350);
        setResizable(false);
        setTitle("Calculate");
    }

    void init() {
        setLayout(new FlowLayout());
        textField = new JTextField(15);
        textArea = new JTextArea(15, 25);
        button = new JButton("Calculate");

        add(textField);
        add(button);
        add(new JScrollPane(textArea));
    }

    void process(ExtendListener extendListener) {
        this.listener = extendListener;
        listener.setTextField(textField);
        listener.setTextArea(textArea);

        textField.addActionListener(listener);
        button.addActionListener(listener);

    }
}