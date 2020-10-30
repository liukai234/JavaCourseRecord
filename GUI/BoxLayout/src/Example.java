import javax.swing.*;
import java.awt.*;

public class Example {

    public static void main(String[] args) {
//        JFrame window1 = new JFrame("第一个窗口");
//        JFrame window2 = new JFrame("第二个窗口");
//        Container con = window1.getContentPane();

        WindowsMenu window2 = new WindowsMenu("嵌套盒模型", 500, 500);
//        window2.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

    }
}

class  WindowsMenu extends JFrame{
    public WindowsMenu(String s, int w, int h) {
        init(s);
        // setBounds(400, 400, 300, 300) = setLocation + setSize
        setLocation(50, 50); // 起始位置
        setSize(w, h); // 大小
        setVisible(true); // 设置可见
        setResizable(false); // 不可调整大小
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    void init(String s) {
        setTitle(s);
        JMenuBar jMenuBar = new JMenuBar();
        // JMenuBar 是横排菜单条
        // JMenu 是有下一级的菜单
        // JMenuItem 是最后一级可以点击的菜单
        JMenu jMenu = new JMenu("First JMenu");
        JMenuItem jMenuItem = new JMenuItem("First JMeneItem");
        JMenu jMenuItem2 = new JMenu("Second JMene");
        JMenuItem jMenuItem3 = new JMenuItem("Second JMeneItem");


        jMenu.add(jMenuItem);
        jMenu.add(jMenuItem2);
        jMenuItem2.add(jMenuItem3);
        jMenuBar.add(jMenu);
        setJMenuBar(jMenuBar);

        setLayout(new FlowLayout()); // 该布局使用setSize设置效果无效，需要借助setPreferredSize(new Dimension());来设置
        Box boxH = Box.createHorizontalBox();
        Box boxVOne = Box.createVerticalBox();
        Box boxVTwo = Box.createVerticalBox();
        boxVOne.add(new JLabel("姓名："));
        boxVOne.add(new JLabel("职业："));
        boxVTwo.add(new JTextField(10));
        boxVTwo.add(new JTextField(10));
        boxH.add(boxVOne);
        boxH.add(Box.createHorizontalStrut(10));
        boxH.add(boxVTwo);
        add(boxH);


//        JTextField jTextField = new JTextField();
//        jTextField.setPreferredSize(new Dimension(50, 20));
//        add(jTextField);
    }
}