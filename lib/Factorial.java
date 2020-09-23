import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int a = input.nextInt();
        char[] charA = String.valueOf(a).toCharArray();

        System.out.println("a->charA");
        for(int i = 0; i < charA.length; i++) {
            System.out.print(charA[i]);
        }
        System.out.println();
        System.out.println("a->charA");

        input.close();
        InnerBigInteger bigInteger = null;
        int[] result = null;
        for (int i = a - 1; i > 0; i--) {
            bigInteger = new InnerBigInteger(charA, String.valueOf(i).toCharArray());
            bigInteger.Multipy();
            result = bigInteger.getResult();

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

            charA = new char[length];
            for (int k = 0; k < charA.length; k++) {
                charA[k] = (char) (result[k] + '0');
            }

            // 逆序
            char[] tempA = new char[charA.length];
            for(int ii = 0; ii < tempA.length; ii ++) {
                tempA[tempA.length - 1 - ii] = charA[ii];
            }
            for(int ii = 0; ii < tempA.length; ii ++) {
                charA[ii] = tempA[ii];
            }

            // for (int k = charA.length - 1; k >= 0; k--) {
            //     System.out.print("--" + charA[k]);
            // }
            // System.out.println();
        }
        // for (int i = a; i > 0; i--) {
        // bigInteger = new InnerBigInteger(String.valueOf(a).toCharArray(),
        // String.valueOf(i).toCharArray());
        // bigInteger.Multipy();
        // }

        boolean flag = true; // 清除因没有进位产生的首位0

        for (int i = result.length - 1; i >= 0; i--) {
            if (result[i] != '\0')
                flag = false;

            // boolean 使用 == 判断相等，而Boolean是boolean的封装类，Boolean作为对象必须使用equals判断相等
            if (flag == true && result[i] == '\0')
                continue;

            System.out.print(result[i]);
        }
        System.out.println();
    }
}
