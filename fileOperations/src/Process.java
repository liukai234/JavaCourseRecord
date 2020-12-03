//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.io.File;
//import java.io.IOException;
//
//public class Process extends JFrame {
//    private JButton btnMove;
//    private JButton btnCopy;
//    private JProgressBar progressBar;
//    private int num = 1;
//    private int sum = 1;
//
//    private File src;
//    private File dis;
//
//    public Process() {
//        init();
//        setVisible(true);
//        setTitle("title");
//        setBounds(300, 300, 400, 100);
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
//        setResizable(true);
//    }
//
//    class processThread implements Runnable{
//
//        private File src;
//        private File dis;
//        FileMoveAndCopy fileOper;
//        private int div = 1;
//        public processThread(File src, File dis) {
//            this.src = src;
//            this.dis = dis;
//
//        }
//
//        @Override
//        public void run() {
//            num = (int)dis.length();
//            while(num != sum) {
//                num = (int)dis.length();
//                if(sum == 0) sum = 1;
//                div = num / sum;
//                progressBar.setValue(div);
//            }
//        }
//    }
//
//    public void init() {
//        setLayout(new FlowLayout());
//        btnMove = new JButton("btnMove");
//        btnCopy = new JButton("btnCopy");
//        progressBar = new JProgressBar(0, 100);
//
//        this.src = new File("text5.txt");
//        this.dis = new File("text6.txt");
//        sum = (int)src.length();
//
//        processThread subThread = new processThread(src, dis);
//
//        btnMove.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent actionEvent) {
//                System.out.println("btnMove be clicked");
//                FileMoveAndCopy fileOpen = new FileMoveAndCopy();
//                try {
//
//                    fileOpen.move(src, dis);
//                    new Thread(subThread).start();
//
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//
//            }
//        });
//
//        add(btnMove);
//        add(btnCopy);
//        add(progressBar);
//    }
//}
