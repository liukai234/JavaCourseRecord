
class Node {
    int x, y;
    int step;
    int preX, preY;
    String direction;

    Node(int x, int y, int preX, int preY, int step, String direction) {
        this.x = x;
        this.y = y;
        this.preX = preX;
        this.preY = preY;
        this.step = step;
        this.direction = direction;
    }
}
