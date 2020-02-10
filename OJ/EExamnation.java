import java.util.*;

public class EExamnation {
    public static void main(String[] args) {
        String str = "000" + "000" + "110";
        int[][] labyrinth = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                labyrinth[i][j] = str.charAt(i * 3 + j) - '0';
            }
        }
        String anser = BFS(labyrinth, 3, 3);
        System.out.println(anser);
        String checkstr = "RRDD";
        System.out.println(anser.equals(checkstr));
    }

    static String BFS(int[][] labyrinth, int row, int column) {
        int[][] visit = new int[row][column];
        /* int[][] stepArr = { { 1, 0 }, { 0, -1 }, { 0, 1 }, { -1, 0 } };
        String[] direction = { "D", "L", "R", "U" }; */
        
         int[][] stepArr = { { -1, 0 }, { 0, 1 }, { 0, -1 }, { 1, 0 } }; String[]
        direction = { "U", "R", "L", "D" };
         // 在字典序中有D < L < R < U, 选择的是 后选择的路线, 所以在搜索过程中先走字典序最大的方向

        Queue<Node> queue = new LinkedList<Node>();
        Stack<Node> stack = new Stack<>();
        Node node = new Node(0, 0, -1, -1, 0, null);
        StringBuilder sb = new StringBuilder();

        queue.offer(node);
        while (!queue.isEmpty()) {
            Node head = queue.poll();
            stack.push(head);
            visit[head.x][head.y] = 1;
            for (int i = 0; i < 4; i++) {
                int x = head.x + stepArr[i][0];
                int y = head.y + stepArr[i][1];

                String d = direction[i];

                if (x == row - 1 && y == column - 1 && labyrinth[x][y] == 0 && visit[x][y] == 0) {
                    Node top = stack.pop();
                    sb.append(d);
                    sb.append(top.direction);
                    int preX = top.preX;
                    int preY = top.preY;
                    while (!stack.isEmpty()) {
                        top = stack.pop();
                        if (top.x == preX && top.y == preY) {
                            if (top.direction != null) {
                                sb.append(top.direction);
                            }
                            preX = top.preX;
                            preY = top.preY;
                        }
                    }
                    return sb.reverse().toString();
                }

                if (x >= 0 && x < row && y >= 0 && y < column && labyrinth[x][y] == 0 && visit[x][y] == 0) {
                    Node newnode = new Node(x, y, head.x, head.y, head.step + 1, d);
                    queue.offer(newnode);
                }
            }
        }
        return null;
    }
}
/*
 * class Node { int x; int y; int preX; int preY; int step; String direction;
 * 
 * Node(int x, int y, int preX, int preY, int step,String direction) { this.x =
 * x; this.y = y; this.preX = preX; this.preY = preY; this.step = step;
 * this.direction = direction; } }
 */
