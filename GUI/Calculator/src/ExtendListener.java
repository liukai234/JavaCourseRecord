import javax.swing.*;
import java.awt.event.ActionListener;

public interface ExtendListener extends ActionListener {
    public void setButton(JButton button);
    public void setTextField(JTextField textField);
}
