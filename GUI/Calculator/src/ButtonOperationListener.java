import javax.swing.*;
import java.awt.event.ActionEvent;

public class ButtonOperationListener implements ExtendListener {
    JButton button;
    JTextField textField;

    @Override
    public void setButton(JButton button) {
        this.button = button;
    }

    @Override
    public void setTextField(JTextField textField) {
        this.textField = textField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        textField.setText(textField.getText() + button.getText());
    }
}

class ButtonAddOperationListener extends ButtonOperationListener{}
class ButtonSubOperationListener extends ButtonOperationListener{}
class ButtonMulOperationListener extends ButtonOperationListener{}
class ButtonDivOperationListener extends ButtonOperationListener{}
class ButtonClearOperationListener extends ButtonOperationListener{
    @Override
    public void actionPerformed(ActionEvent e) {
        textField.setText(null);
    }
}