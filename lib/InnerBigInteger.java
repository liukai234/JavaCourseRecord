public class InnerBigInteger {
    private char[] a;
    private char[] b;
    private int[] result;

    InnerBigInteger(char[] a, char[] b) {
        this.a = a;
        this.b = b;
        result = new int[a.length + b.length];
    }

    int[] getResult(){
        return result;
    }

    void Multipy() {
        
        int[] tempa = new int[a.length];
        int[] tempb = new int[b.length];
        int p = 0;

        // 将result初始化为0
        for (int i = 0; i < result.length; i++){
            result[i] = 0;
        }

        // 对数组逆序
        for (int i = 0; i < a.length; i++) {
            tempa[a.length - 1 - i] = (int) (a[i] - '0');
        }

        for (int i = 0; i < b.length; i++) {
            tempb[b.length - 1 - i] = (int) (b[i] - '0');
        }

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                result[i + j] += tempa[i] * tempb[j]; // 累加到位上
            }
        }

        // 进位
        for (int i = 0; i < result.length - 1; i++) {
            if (result[i] >= 10) {
                p = result[i] / 10;
                result[i + 1] += p;
                result[i] = result[i] - p * 10;
            }
        }
    }
}