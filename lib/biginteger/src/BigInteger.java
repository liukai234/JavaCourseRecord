import java.util.Scanner;

public class BigInteger {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();
        input.close();

        InnerBigInteger bigInteger = new InnerBigInteger(String.valueOf(a).toCharArray(), String.valueOf(b).toCharArray());
        bigInteger.Multipy();
        char[] result = bigInteger.getResult();
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
        }
        System.out.println();
    }
}
