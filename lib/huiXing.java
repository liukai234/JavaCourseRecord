import java.util.Scanner;

public class huiXing {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int size = input.nextInt();
        input.close();

        InnerhuiXing huixing = new InnerhuiXing(size);
        huixing.output();
    }
}


class InnerhuiXing {
    private int size;
    private Integer[][] matrix;

    InnerhuiXing(int size) {
        this.size = size;
        matrix = new Integer[size][size];
    }

    void output() {
        fill();
        for(int row = 0; row < size; row ++) {
            for (int col = 0; col < size; col ++) {
                System.out.print(matrix[row][col] + "   ");
            }
            System.out.println();
        }
    }

    void fill() {
        // 第二象限
        for(int row = 0; row <= size / 2; row ++) { // 对奇数的第二象限补齐
            for(int col = 0; col <= size / 2; col ++) {
                matrix[row][col] = (row < col ? row : col) + 1;
            }
        }

        // 将第二象限中心对称到第四象限
        for(int row = size / 2; row < size; row++) {
            for(int col = size / 2; col < size; col ++) { // 填补奇数在其他象限的空缺
                matrix[row][col] = matrix[size - row - 1][size - col - 1];
            }
        }

        // 将二象限镜面对称到一象限
        for(int row = 0; row < size / 2; row ++) {
            for(int col = size / 2; col < size; col ++) {
                matrix[row][col] = matrix[row][size - col - 1];
            }
        }
        
        // 将第一象限中心对称到第三象限
        for(int row = size / 2; row < size; row++) {
            for(int col = 0; col < size / 2; col ++) {
                matrix[row][col] = matrix[size - row - 1][size - col - 1];
            }
        }
    }
}