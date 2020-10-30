import javax.swing.*;
import java.awt.event.ActionEvent;

public class ButtonNumListener implements ExtendListener {
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

class Button0NumListener extends ButtonNumListener {}
class Button1NumListener extends ButtonNumListener {}
class Button2NumListener extends ButtonNumListener {}
class Button3NumListener extends ButtonNumListener {}
class Button4NumListener extends ButtonNumListener {}
class Button5NumListener extends ButtonNumListener {}
class Button6NumListener extends ButtonNumListener {}
class Button7NumListener extends ButtonNumListener {}
class Button8NumListener extends ButtonNumListener {}
class Button9NumListener extends ButtonNumListener {}
