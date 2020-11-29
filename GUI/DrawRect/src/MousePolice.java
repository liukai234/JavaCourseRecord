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
    int lastX = 0;
    int lastY = 0;

    String shapeType = "null";
    public void setBoard(Board board) { this.board = board; }
    public  void setShapeType(String shapeType) { this.shapeType = shapeType; }
    public void setGraphics() { this.g = board.getGraphics(); }
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("mousePressed");
        leftButtonDown = true;
        board.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));

        startX = e.getX();
        startY = e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {

        // 获得绘图 g
        // 调用继承JPanel的对象的getGraphics()方法
        g = board.getGraphics();
        board.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        System.out.println("mouseReleased");
        leftButtonDown = false;

        int minX = Math.min(startX, e.getX());
        int minY = Math.min(startY, e.getY());
        Shape shape = switch (shapeType) {
            case "Rect" -> new Rect(minX, minY, Math.abs(e.getX() - startX), Math.abs(e.getY() - startY));
            case "Circle" -> new Circle(minX, minY, Math.abs(e.getX() - startX), Math.abs(e.getY() - startY));
            default -> new Rect(minX, minY, Math.abs(e.getX() - startX), Math.abs(e.getY() - startY));
        };

        // 从board这个显示且添加到主面板中的组件中获取graphics
        board.add(shape);
        board.reFresh();

        lastX = 0;
        lastY = 0;
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

        Shape shapeErase = null;
        Shape shape = null;

        switch (shapeType) {
            case "Rect" -> {
                shapeErase = new Rect(lastX, lastY, lastWidth, lastHeight);
                g.setColor(board.getBackground());
                shapeErase.Draw();
                board.reFresh();
                shape = new Rect(minX, minY, Math.abs(e.getX() - startX), Math.abs(e.getY() - startY));
                g.setColor(Color.blue);
                shape.Draw();
            }
            case "Circle" -> {
                shapeErase = new Circle(lastX, lastY, lastWidth, lastHeight);
                g.setColor(board.getBackground());
                shapeErase.Draw();
                board.reFresh();
                board.repaint();
                shape = new Circle(minX, minY, Math.abs(e.getX() - startX), Math.abs(e.getY() - startY));
                g.setColor(Color.blue);
                shape.Draw();
            }
            default -> {
                shapeErase = new Rect(lastX, lastY, lastWidth, lastHeight);
                g.setColor(board.getBackground());
                shapeErase.Draw();
                board.reFresh();
                shape = new Rect(minX, minY, Math.abs(e.getX() - startX), Math.abs(e.getY() - startY));
                g.setColor(Color.blue);
                shape.Draw();
            }
        }

        lastWidth = Math.abs(e.getX() - startX);
        lastHeight = Math.abs(e.getY() - startY);

        lastX = minX;
        lastY = minY;
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

}