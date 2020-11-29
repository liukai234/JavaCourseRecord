import javax.swing.*;
import java.awt.event.ActionEvent;

public class PoliceListener implements ExtendListener{
    JTextField textField; // 视图
    JTextArea textArea; // 视图

    @Override
    public void setTextField(JTextField textField) {
        this.textField = textField;
    }

    @Override
    public void setTextArea(JTextArea textArea) {
        this.textArea = textArea;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String str = textField.getText();
        MyBigInteger myBigInteger = new MyBigInteger(str); // 模型
        String result = myBigInteger.calculate();
        textArea.append(result + "\n");
    }
}
