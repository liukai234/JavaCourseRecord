import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

class MousePolice implements MouseListener {
    Board board;

    int startX;
    int startY;
//    Graphics g;
//    public void setGraphics(Graphics g) {
//        this.g = g;
//    }

    public void setBoard(Board board) {
        this.board = board;
    }
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("mousePressed");
        startX = e.getX();
        startY = e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("mouseReleased");
        try{
//            if(startX - e.getX() >= 0)
//                board.creatRect(e.getX(), e.getY(), startX - e.getX(), startY - e.getY());
//            else
            int minX = Math.min(startX, e.getX());
            int minY = Math.min(startY, e.getY());

            board.creatRect(minX, minY, Math.abs(e.getX() - startX), Math.abs(e.getY() -  startY));
            board.repaint();
        } catch (MaxNumException exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}