// 大数相乘
class InnerBigInteger {
    private char[] a;
    private char[] b;
    private int[] result;
    private char[] charA;

    InnerBigInteger(char[] a, char[] b) {
        this.a = a;
        this.b = b;
        result = new int[a.length + b.length];
    }

    // 返回char[]类型结果，高位在下标0
    char[] getResult(){

        // 类型转换 int[] result -> char[] charA
        boolean flag = true; // 清除因没有进位产生的首位0

        int length = 0;
        length = result.length;
        for (int index = result.length - 1; index >= 0; index--) {
            if (result[index] != '\0')
                flag = false;

            // boolean 使用 == 判断相等，而Boolean是boolean的封装类，Boolean作为对象必须使用equals判断相等
            if (flag == true && result[index] == '\0')
                length --;
        }

        // 重新分配大小
        charA = new char[length];
        for (int k = 0; k < charA.length; k++) {
            charA[k] = (char) (result[k] + '0');
        }

        // 逆序
        char[] tempA = new char[charA.length];
        for(int i = 0; i < tempA.length; i ++) {
            tempA[tempA.length - 1 - i] = charA[i];
        }
        for(int i = 0; i < tempA.length; i ++) {
            charA[i] = tempA[i];
        }
        return charA;
    }

    // 对char[] a, char[] b执行乘法
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