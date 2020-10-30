import javax.swing.*;
import java.awt.event.ActionListener;

public interface ExtendListener extends ActionListener {
    public void setTextField(JTextField textField);
    public void setTextArea(JTextArea textArea);
}
