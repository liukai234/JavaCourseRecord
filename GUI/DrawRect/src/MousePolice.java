import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

class MousePolice implements MouseMotionListener, MouseListener{
    Board board;
    static boolean leftButtonDown = false;
    int startX;
    int startY;
    Graphics g;
    private static int lastWidth = 0;
    private static int lastHeight = 0;
    int lastx = 0;
    int lasty = 0;

    public void setBoard(Board board) { this.board = board; }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("mousePressed");
        leftButtonDown = true;
        startX = e.getX();
        startY = e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {

        // 获得绘图 g
        // 调用继承JPanel的对象的getGraphics()方法
        g = board.getGraphics();

        System.out.println("mouseReleased");
        leftButtonDown = false;

        int minX = Math.min(startX, e.getX());
        int minY = Math.min(startY, e.getY());

        Shape shape = new Rect(minX, minY, Math.abs(e.getX() - startX), Math.abs(e.getY() -  startY));
        // 从board这个显示且添加到主面板中的组件中获取graphics
        shape.Draw(g);

        board.add(shape);
        board.repaint();

        lastx = 0;
        lasty = 0;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        g = board.getGraphics();
        System.out.println("mouseDragged");
        int minX = Math.min(startX, e.getX());
        int minY = Math.min(startY, e.getY());

        // erase
        Shape shape = new Rect(lastx, lasty, lastWidth, lastHeight);
        g.setColor(board.getBackground());
        shape.Draw(g);

        Shape shape1 = new Rect(minX, minY, Math.abs(e.getX() - startX), Math.abs(e.getY() -  startY));
        g.setColor(Color.blue);
        shape1.Draw(g);

        lastWidth = Math.abs(e.getX() - startX);
        lastHeight = Math.abs(e.getY() - startY);

        lastx = minX;
        lasty = minY;
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

}