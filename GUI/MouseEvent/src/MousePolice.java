import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

class MousePolice implements MouseListener {
    JTextArea textArea;


    public void setTextField(JTextArea textArea) {
        this.textArea = textArea;
    }
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        textArea.append(e.getX() + "  " +  e.getY() + "\n");
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}