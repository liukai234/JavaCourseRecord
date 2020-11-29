import java.util.Scanner;
class test3
{
    public static void main(String args[])
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter an integer");
        int a = input.nextInt();
        // 在使用nextInt等后在使用nextLine之前先需要一个空nextLine读取行末回车
        input.nextLine();
        System.out.println("Enter a String");
        String b = input.nextLine();
        System.out.println("You have entered: " + a + " " + "and name as " + b);
    }
}