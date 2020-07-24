import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Solution26 solution = new Solution26();
        int[] nums = {1, 1, 2};
        int len = solution.removeDuplicates(nums);

        System.out.println("len: " + len);
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i]);
        }
        System.out.println();
        input.close();
    }
}
