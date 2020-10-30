import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.StringTokenizer;

public class CalculatorWindow extends JFrame implements ActionListener {
    Calculate calculate;
    Button0NumListener button0NumListener;
    Button1NumListener button1NumListener;
    Button2NumListener button2NumListener;
    Button3NumListener button3NumListener;
    Button4NumListener button4NumListener;
    Button5NumListener button5NumListener;
    Button6NumListener button6NumListener;
    Button7NumListener button7NumListener;
    Button8NumListener button8NumListener;
    Button9NumListener button9NumListener;

    ButtonAddOperationListener buttonAddOperationListener;
    ButtonSubOperationListener buttonSubOperationListener;
    ButtonMulOperationListener buttonMulOperationListener;
    ButtonDivOperationListener buttonDivOperationListener;

//    ButtonCalOperationListener buttonCalOperationListener;
    ButtonClearOperationListener buttonClearOperationListener;

    ClearAllTextIn clearAllTextIn;
    JTextField textFieldIn;
    JTextField textFieldOut;

    JButton button0;
    JButton button1;
    JButton button2;
    JButton button3;
    JButton button4;
    JButton button5;
    JButton button6;
    JButton button7;
    JButton button8;
    JButton button9;
    JButton add;
    JButton sub;
    JButton multiply;
    JButton div;
    JButton cal;
    JButton clear;

    CalculatorWindow() {
        init();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    void AddListenIn(JButton button, JTextField textField, ExtendListener extendListener) {
        button.addActionListener(extendListener);
        extendListener.setButton(button);
        extendListener.setTextField(textField);
    }

    void addListenOut() {

    }

    void init() {
        textFieldIn = new JTextField(10);
        textFieldOut = new JTextField(10);
        button0NumListener = new Button0NumListener();
        button1NumListener = new Button1NumListener();
        button2NumListener = new Button2NumListener();
        button3NumListener = new Button3NumListener();
        button4NumListener = new Button4NumListener();
        button5NumListener = new Button5NumListener();
        button6NumListener = new Button6NumListener();
        button7NumListener = new Button7NumListener();
        button8NumListener = new Button8NumListener();
        button9NumListener = new Button9NumListener();

        buttonAddOperationListener = new ButtonAddOperationListener();
        buttonSubOperationListener = new ButtonSubOperationListener();
        buttonMulOperationListener = new ButtonMulOperationListener();
        buttonDivOperationListener = new ButtonDivOperationListener();
        buttonClearOperationListener = new ButtonClearOperationListener();
//        buttonCalOperationListener = new ButtonCalOperationListener();

        clearAllTextIn = new ClearAllTextIn();
        JPanel panel = new JPanel();
        panel.add(new JLabel("In: "));
        panel.add(textFieldIn);
        panel.add(new JLabel("Out: "));
        panel.add(textFieldOut);
        add(panel, BorderLayout.NORTH);


        button0 = new JButton("0");
        button1 = new JButton("1");
        button2 = new JButton("2");
        button3 = new JButton("3");
        button4 = new JButton("4");
        button5 = new JButton("5");
        button6 = new JButton("6");
        button7 = new JButton("7");
        button8 = new JButton("8");
        button9 = new JButton("9");

        add = new JButton("+");
        sub = new JButton("-");
        multiply = new JButton("*");
        div = new JButton("/");
        cal = new JButton("Cal");
        clear = new JButton("AC");

        JPanel panelCenter = new JPanel();
        panelCenter.add(button9);
        panelCenter.add(button8);
        panelCenter.add(button7);
        panelCenter.add(add);
        panelCenter.add(button6);
        panelCenter.add(button5);
        panelCenter.add(button4);
        panelCenter.add(sub);
        panelCenter.add(button3);
        panelCenter.add(button2);
        panelCenter.add(button1);
        panelCenter.add(multiply);
        panelCenter.add(button0);
        panelCenter.add(cal);
        panelCenter.add(clear);
        panelCenter.add(div);

        AddListenIn(button0, textFieldIn, button0NumListener);
        AddListenIn(button1, textFieldIn, button1NumListener);
        AddListenIn(button2, textFieldIn, button2NumListener);
        AddListenIn(button3, textFieldIn, button3NumListener);
        AddListenIn(button4, textFieldIn, button4NumListener);
        AddListenIn(button5, textFieldIn, button5NumListener);
        AddListenIn(button6, textFieldIn, button6NumListener);
        AddListenIn(button7, textFieldIn, button7NumListener);
        AddListenIn(button8, textFieldIn, button8NumListener);
        AddListenIn(button9, textFieldIn, button9NumListener);
        AddListenIn(add, textFieldIn, buttonAddOperationListener);
        AddListenIn(sub, textFieldIn, buttonSubOperationListener);
        AddListenIn(multiply, textFieldIn, buttonMulOperationListener);
        AddListenIn(div, textFieldIn, buttonDivOperationListener);
        AddListenIn(clear, textFieldIn, buttonClearOperationListener);
//        AddListenIn(cal, textFieldOut, buttonCalOperationListener);

        add(Box.createHorizontalStrut(50), BorderLayout.EAST);
        add(Box.createHorizontalStrut(50), BorderLayout.WEST);

        add(panelCenter, BorderLayout.CENTER);

        cal.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String expression = textFieldIn.getText();
        StringTokenizer st = new StringTokenizer(expression, "+-*/", true);

        String[] temp = new String[st.countTokens()]; // st.countTokens统计可以调用nextTokens的个数
        int i = 0;
        while(st.hasMoreElements()){
            temp[i] = st.nextElement().toString();
            i = i + 1;
        }

//        Scanner input = new Scanner(expression);
        int a = Integer.parseInt(temp[0]);
        int b = Integer.parseInt(temp[2]);
        String symbol = temp[1];

        calculate = new Calculate(a, b, symbol);
        int c = calculate.calculate();
        textFieldOut.setText(String.valueOf(c));


    }
}
