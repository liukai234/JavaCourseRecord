public class Board {
    public Board(){}

    private final int MAX_NUM = 10;
    private Rect [] rects = new Rect[10];
    private static int rectNumber = 0;
    private Circle[] circles = new Circle[10];
    private static int circleNumber = 0;

    public void creatRect() throws MaxNumException {
        if(rectNumber >= MAX_NUM) throw new MaxNumException(rectNumber);

        rects[rectNumber] = new Rect();
        rectNumber += 1;
    }

    public void creatCircle() throws MaxNumException {
        if(circleNumber >= MAX_NUM) throw new MaxNumException(circleNumber);

        circles[circleNumber] = new Circle();
        circleNumber += 1;
    }

    public void Refresh() {

        for(int i = 0; i < rectNumber; i ++) {
            System.out.println(rects[i].getType());
        }
        for(int i = 0; i < circleNumber; i++) {
            System.out.println(circles[i].getType());
        }

    }
}

class MaxNumException extends java.lang.Exception {
    static final long serialVersionUID = -3387516993124229948L;
    String message;
    public MaxNumException(Number n) {
        message = n + " overflow";
    }

    @Override
    public String getMessage() {
        return message;
    }
}