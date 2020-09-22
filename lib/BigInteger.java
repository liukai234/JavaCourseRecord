// import java.util.Scanner;

// public class BigInteger {

//     public static void main(String[] args) {
//         Scanner input = new Scanner(System.in);
//         int a = input.nextInt();
//         int b = input.nextInt();
//         input.close();

//         InnerBigInteger bigInteger = new InnerBigInteger(String.valueOf(a).toCharArray(), String.valueOf(b).toCharArray());
//         bigInteger.Multipy();
//         int[] result = bigInteger.getResult();

//         boolean flag = true; // 清除因没有进位产生的首位0

//         for (int i = result.length - 1; i >= 0; i--) {
//             if(result[i] != '\0') flag = false;

//             // boolean 使用 == 判断相等，而Boolean是boolean的封装类，Boolean作为对象必须使用equals判断相等
//             if(flag == true && result[i] == '\0') continue;

//             System.out.print(result[i]);
//         }
//         System.out.println();
//     }
// }
// // 大数相乘
// class InnerBigInteger {
//     private char[] a;
//     private char[] b;
//     private int[] result;

//     InnerBigInteger(char[] a, char[] b) {
//         this.a = a;
//         this.b = b;
//         result = new int[a.length + b.length];
//     }

//     int[] getResult(){
//         return result;
//     }

//     void Multipy() {
        
//         int[] tempa = new int[a.length];
//         int[] tempb = new int[b.length];
//         int p = 0;

//         // 将result初始化为0
//         for (int i = 0; i < result.length; i++){
//             result[i] = 0;
//         }

//         // 对数组逆序
//         for (int i = 0; i < a.length; i++) {
//             tempa[a.length - 1 - i] = (int) (a[i] - '0');
//         }

//         for (int i = 0; i < b.length; i++) {
//             tempb[b.length - 1 - i] = (int) (b[i] - '0');
//         }

//         for (int i = 0; i < a.length; i++) {
//             for (int j = 0; j < b.length; j++) {
//                 result[i + j] += tempa[i] * tempb[j]; // 累加到位上
//             }
//         }

//         // 进位
//         for (int i = 0; i < result.length - 1; i++) {
//             if (result[i] >= 10) {
//                 p = result[i] / 10;
//                 result[i + 1] += p;
//                 result[i] = result[i] - p * 10;
//             }
//         }
//     }
// }