import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int a = input.nextInt();
        char[] charA = String.valueOf(a).toCharArray();
        input.close();
        InnerBigInteger bigInteger = null;
        for (int i = a - 1; i > 0; i--) {
            bigInteger = new InnerBigInteger(charA, String.valueOf(i).toCharArray());
            bigInteger.Multipy();
            charA = bigInteger.getResult();
        }
        
        for(int i = 0; i < charA.length; i ++) {
            System.out.print(charA[i]);
        }
        System.out.println();
    }
}
