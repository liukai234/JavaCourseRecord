import java.util.Scanner;
public class test {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Solution38 solution = new Solution38();
        int num = input.nextInt();
        String str = solution.countAndSay(num);

        System.out.println(str);
        input.close();
    }
}
