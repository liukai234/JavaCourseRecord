import javax.swing.*;
import java.awt.event.ActionEvent;

public class ClearAllTextIn implements ExtendListener {
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
        textField.setText(null);
    }
}
