import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Process extends JFrame {
    private JButton btnMove;
    private JButton btnCopy;
    private JProgressBar progressBar;

    public Process() {
        init();
        setVisible(true);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
//        setResizable(true);
    }

    public void init() {
        setLayout(new FlowLayout());
        btnMove = new JButton("btnMove");
        btnCopy = new JButton("btnCopy");
        progressBar = new JProgressBar(0, 100);

        btnMove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("btnMove be clicked");
            }
        });

        add(progressBar);
        add(btnMove);
        add(btnCopy);
    }



    private int num = 0;


}
