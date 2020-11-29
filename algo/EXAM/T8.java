import java.io.*;
import java.util.Scanner;
import java.util.LinkedList;

public class T8 {
    static int m;
    static int n;
    static int [][] vis = new int[1010][1010];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};


    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        m = input.nextInt();
        input.nextLine();
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        LinkedList<Block> q = new LinkedList<Block>();
        for(int i = 0; i < n; i++) {
            String line = input.nextLine(); // line = br.readline();
            for(int j = 0; j < m; j++) {
                char c = line.charAt(j);
                if(c == 'g') {
                    q.add(new Block(i, j, 0));
                    vis[i][j] = 1;
                }
            }
        }

        int k = input.nextInt(); // 

        while(!q.isEmpty()) {
            Block b = q.poll();
            int month = b.month;
            if(month < k) {
                for(int i = 0; i < 4; i ++) {
                    int nx = b.i + dx[i];
                    int ny = b.j + dy[i];
                    if(0 <= nx && nx < n && 0 <= ny && ny < m && vis[nx][ny] == 0) {
                        vis[nx][ny] = 1;
                        q.add(new Block(nx, ny, month + 1));
                    }
                }
            }
        }


        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(vis[i][j] == 1) {
                    bw.write('g');
                } else {
                    bw.write('.');
                }
            }
            bw.write('\n');
        }
        bw.flush();

    }
}

class Block {
    int i;
    int j;
    int month;

    public Block(int i, int j, int month) {
        this.i = i;
        this.j = j;
        this.month = month;
    }
}