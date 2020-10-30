import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WindowActionEvent extends JFrame{
    JTextField text;
    ActionListener listener;
    public WindowActionEvent() {
        text = new JTextField(10);
        setLayout(new FlowLayout());
//        add(text);
        JTextArea jTextArea = new JTextArea(9,30);
        listener = new ReaderListen(jTextArea);
        text.addActionListener(listener);
        setVisible(true);
//        add(jTextArea);
        panel p1 = new panel();
        add(p1);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}

class ReaderListen implements ActionListener{
    JTextArea jTextArea;
    public ReaderListen(JTextArea jTextArea){
        this.jTextArea = jTextArea;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();
        jTextArea.append(str + ":" + str.length() + '\n');
    }
}


class panel extends JPanel {
    public panel() {
        setSize(50, 50);

    }
    Graphics g;

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawRect(100, 100, 500, 500);
    }
}