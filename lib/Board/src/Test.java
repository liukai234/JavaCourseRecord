public class Test {
    public static void main(String[] args) {
        Board board = new Board();
        try{
            // for(int i = 0; i < 11; i++)  board.creatRect(); // Error overflow
            board.creatRect();
            board.creatCircle();
            board.Refresh();
        } catch(MaxNumException e) {
            System.out.println(e.getMessage());
        }
    }
}
